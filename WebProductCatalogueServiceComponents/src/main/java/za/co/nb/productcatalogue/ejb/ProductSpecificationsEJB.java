package za.co.nb.productcatalogue.ejb;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.common.helper.namespacebinding.CachedNameSpaceBindingHelper;
import za.co.nb.juristic.productcatalogue.remoteejb.IJuristicProductSpecifications;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseHeader;
import za.co.nb.productcatalogue.cases.dao.BusinessCaseDAO;
import za.co.nb.productcatalogue.dao.ArrangementMetricsDAO;
import za.co.nb.productcatalogue.ejb.substitution.Banker;
import za.co.nb.productcatalogue.ejb.substitution.Channel;
import za.co.nb.productcatalogue.ejb.substitution.Subnet;
import za.co.nb.productcatalogue.ejb.substitution.Substitution;
import za.co.nb.productcatalogue.ejb.util.ProductTypeLoader;
import za.co.nb.productcatalogue.ejb.util.RawSpecString;
import za.co.nb.productcatalogue.exception.InvalidAttributeException;
import za.co.nb.productcatalogue.exception.InvalidAttributeGroupException;
import za.co.nb.productcatalogue.util.ProductSpecificationSubstitutionUtil;
import za.co.nb.productcatalogue.util.ProductSpecificationUtil;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductAttributeGroupType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductattributesType;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@LocalBean
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ProductSpecificationsEJB implements ProductSpecificationsServiceRemoteInterface {

    private final Log mLog = LogFactory.getLog(getClass());

    private static final boolean ENABLE_XSD_VALIDATION = false;
    private static final String DYNAMIC_STAFF_MARkER = "${{dynamicStaffList}}";

    private IJuristicProductSpecifications juristicProductSpecificationsRemote;
    private ProductTypeLoader productTypeInheritanceLoader = new ProductTypeLoader();
    private final ProductSpecificationUtil specUtil = new ProductSpecificationUtil();

    @EJB
    ProductTypeCacheEJB productTypeCacheEJB;

    @EJB
    DynamicWhitelistBean dynamicWhitelistBean;

    @EJB
    DynamicPropertyBean dynamicPropertyBean;

    private String environment;

    @PostConstruct
    public void init(){
        environment = CachedNameSpaceBindingHelper.getNameSpaceBinding("ENVIRONMENT","ETE");
    }

    public String getProductSpecificationXMLStringByID(String pProductSpecificationID) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");
        RawSpecString rawSpecString = readProductSpecificationFromResourceFile(pProductSpecificationID);
        return rawSpecString.getXmlString();
    }

    
    public ProductType getProductSpecificationByIDAndArrangementID(String productSpecificationID, String arrangementID) throws Exception {
        mLog.debug("Trace 1 >>" + productSpecificationID + "<<,>>" + arrangementID + "<<");


        // First check whether there are business rules that need to be run to switch out the product ID to a specific on.
        ProductSpecificationSubstitutionUtil util = new ProductSpecificationSubstitutionUtil();
        productSpecificationID = util.substituteArrangementProductIDBasedOnBusinessRules(productSpecificationID, arrangementID);
        
        if (specHasSubstitutionRules(productSpecificationID)) {
            // Next get the case ID based on the arrangement ID.
        	// These are the pilot substitution rules
            mLog.debug("Trace 2");

            // Must check for case specific substitutions.
            ArrangementMetricsDAO dao = new ArrangementMetricsDAO();

            String caseID = dao.retrieveCaseIDByArrangementID(arrangementID);

            if (caseID == null) {

                mLog.debug("Trace 3");
                // No case ID so we can only return the normal spec.
                return getProductSpecificationXMLByID(productSpecificationID);

            } else {
                mLog.debug("Trace 4 >>" + caseID + "<<");

                return getProductSpecificationByIDAndCaseID(productSpecificationID, caseID);
            }
        } else {
        	// Just return the normal spec.
            mLog.debug("Trace 5");
            return getProductSpecificationXMLByID(productSpecificationID);
        }
    }

    private boolean specHasSubstitutionRules(String productID) throws Exception {
        mLog.debug("Trace 1");

        // Get the product spec.
        ProductType productSpec = getProductSpecificationXMLByID(productID);

        mLog.debug("Trace 2");

        // What environment are we running in?
        Object objref = lookupObject("ENVIRONMENT");
        String environment = (String) PortableRemoteObject.narrow(objref, String.class);

        // Now check if there are substitution rules.
        for (ProductAttributeGroupType attributeGroup : productSpec.getProductAttributeGroup()) {
            mLog.debug("Trace 3");

            // Is this the substitution group.
            if (attributeGroup.getAttributeGroupName().equalsIgnoreCase("SubstitutionRules" + environment)) {
                // We've found a substitution group.
                mLog.debug("Trace 4");

                return true;
            }
        }

        mLog.debug("Trace 5");

        return false;
    }

    public ProductType getProductSpecificationByIDAndCaseID(String productSpecificationID, String caseID) throws Exception {
        mLog.debug("Trace 1 >>" + productSpecificationID + "<<,>>" + caseID + "<<");
        BusinessCaseDAO dao = new BusinessCaseDAO();
        BusinessCaseHeader caseHeader = dao.retrieveBusinessCase(caseID);
        // Get the product spec.
        if(caseID != null){
            ProductSpecificationSubstitutionUtil util = new ProductSpecificationSubstitutionUtil();
            productSpecificationID = util.substituteBusinessCaseProductIDBasedOnBusinessRules(productSpecificationID, caseID);
            mLog.debug("Trace 1.1 : substituteProductIDBasedOnBusinessRules >>" + productSpecificationID + "<<,>>" + caseID + "<<");
        }

        ProductType productSpec = getProductSpecificationXMLByID(productSpecificationID);

        String environment = CachedNameSpaceBindingHelper.getNameSpaceBinding("ENVIRONMENT", "ETE");

        mLog.debug("Trace 2 >>" + environment + "<<");

        // Now check if there are substitution rules.

        if(!isSubstitutionEnabled(productSpec))
            return productSpec;

        //RUN GNBA 1.0
        if(!isSubstitutionRulesProductAttributesEmpty(productSpec)) {
            mLog.debug("Running OLD Substitution RULES:"+productSpec);
            Substitution substitutionRule = getSubstitutionRules(productSpec, environment);
            return processSubstitution(productSpecificationID, caseHeader, productSpec, substitutionRule);
        }else{
            mLog.debug("Running MULTI Substitution RULES:"+productSpec);
            List<Substitution> substitutionRules = getMultiSubstitutionRules(productSpec);
            return processMultiSubstitution(caseHeader, productSpec, substitutionRules);
        }

    }

    private boolean isSubstitutionRulesProductAttributesEmpty(ProductType productSpec){
        mLog.debug("pre-isSubstitutionRulesProductAttributesEmpty");
        try {
            ProductAttributeGroupType productAttributeGroup= specUtil.getProductAttributeGroupValues(productSpec, "SubstitutionRules" + environment);
            if(productAttributeGroup.getProductAttributes().isEmpty())
                return true;

            return false;
        }catch (InvalidAttributeGroupException iae){ }

        return false;
    }

    private ProductType processMultiSubstitution(BusinessCaseHeader caseHeader, ProductType productSpec, List<Substitution> substitutionRules) {
        mLog.debug("pre-processMultiSubstitution");
        try {
            for (Substitution substitutionRule : substitutionRules) {

                if (substitutionRule instanceof Channel) {
                    if (isChannelSubstitution(caseHeader, productSpec, (Channel) substitutionRule))
                        return getProductSpecificationXMLByID(substitutionRule.getProductId());
                } else if (substitutionRule instanceof Banker) {
                    if (isBankerSubstitution(caseHeader, productSpec, (Banker) substitutionRule))
                        return getProductSpecificationXMLByID(substitutionRule.getProductId());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to execute MultiSubstitution rules, reason:"+e.getMessage(), e);
        }

        return productSpec;
    }

    private String processMultiSubstitution(String initiatingStaffNBNumber, ProductType productSpec, List<Banker> bankers){
        try{
            for (Banker banker : bankers) {
                if(initiatingStaffNBNumber != null && banker.getType().toLowerCase().contains(initiatingStaffNBNumber.toLowerCase())){
                    mLog.debug("substituting product:"+banker.getProductId());
                    return banker.getProductId();
                }
            }
            mLog.debug("returning default product:"+productSpec.getProductIdentifier());
            return String.valueOf(productSpec.getProductIdentifier());

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to execute MultiSubstitution rules, reason:"+e.getMessage(), e);
        }

    }

    private boolean isChannelSubstitution(BusinessCaseHeader caseHeader, ProductType productSpec, Channel channel) {
        mLog.debug("ChannelRule:>>" + channel + "<<");

        if ((caseHeader.getInitiatingChannelID() != null
                && !caseHeader.getInitiatingChannelID().trim().isEmpty()
                && !channel.getChannelIDWhitelist().isEmpty())
                && channel.getChannelIDWhitelist().contains(caseHeader.getInitiatingChannelID().toLowerCase())) {
            // We must substitute.
            mLog.debug("PRODUCT_ID >>" + productSpec.getProductIdentifier() + "<< SUBSTITUTED_TO >>" + channel.getProductId()+ "<< CHANNEL >>" + caseHeader.getInitiatingChannelID() + "<<");

            return true;
        }
        return false;
    }

    private boolean isBankerSubstitution(BusinessCaseHeader caseHeader, ProductType productSpec, Banker banker) {

        mLog.debug("BankerRule:"+banker);

        if(caseHeader != null){

            if ((caseHeader.getInitiatingStaffNBNumber() != null
                    && !caseHeader.getInitiatingStaffNBNumber().trim().isEmpty())
                    && banker.getType().toLowerCase().contains(caseHeader.getInitiatingStaffNBNumber().toLowerCase())) {

                mLog.debug("PRODUCT_ID >>" + productSpec.getProductIdentifier() + "<< SUBSTITUTED_TO >>" + banker.getProductId() + "<< BANKER >>" + caseHeader.getInitiatingStaffNBNumber() + "<<");

                return true;
            }
        }

        return false;
    }

    private ProductType processSubstitution(String productSpecificationID, BusinessCaseHeader caseHeader, ProductType productSpec, Substitution substitutionRule) throws Exception {
        if(substitutionRule == null)
            return productSpec;

        // Must we substitute the product spec?
        if (substitutionRule instanceof Channel) {// subs Channel
            mLog.debug("Trace 8 >>" + substitutionRule + "<<");
            Channel channel = (Channel) substitutionRule;
            // Get the business case details.
            mLog.debug("Trace 9 >>" + caseHeader.getInitiatingChannelID() + "<<");

            if ((caseHeader.getInitiatingChannelID() != null
                    && !caseHeader.getInitiatingChannelID().trim().isEmpty()
                    && channel.getChannelIDWhitelist() != null
                    && !channel.getChannelIDWhitelist().isEmpty())
                    && channel.getChannelIDWhitelist().contains(caseHeader.getInitiatingChannelID().toLowerCase())) {
                // We must substitute.
                mLog.debug("Trace 10 Substituting product ID >>" + productSpecificationID + "<< for product ID >>" + channel.getProductId() + "<< for channel >>" + caseHeader.getInitiatingChannelID() + "<<");

                return getProductSpecificationXMLByID(channel.getProductId());
            }
        }else if (substitutionRule instanceof Banker) {
            Banker banker = (Banker)substitutionRule;

            mLog.debug("Trace 12 >>" + banker + "<<");
            mLog.debug("Trace 13 >>" + caseHeader.getInitiatingStaffNBNumber() + "<<");

            if ((caseHeader.getInitiatingStaffNBNumber() != null
                    && !caseHeader.getInitiatingStaffNBNumber().trim().isEmpty())
                    && banker.getType().toLowerCase().contains(caseHeader.getInitiatingStaffNBNumber().toLowerCase())) {
                // We must substitute.
                mLog.debug("Trace 14 Substituting product ID >>" + productSpecificationID + "<< for product ID >>" + banker.getProductId() + "<< for banker >>" + caseHeader.getInitiatingStaffNBNumber() + "<<");

                return getProductSpecificationXMLByID(banker.getProductId());
            }
        }

        return productSpec;
    }

    private boolean isSubstitutionEnabled(ProductType productSpec){
        mLog.debug("pre-isSubstitutionEnabled:"+productSpec);
        return specUtil.isAttributeGroupNameExist(productSpec, "SubstitutionRules" + environment);
    }


    private List<Substitution> getMultiSubstitutionRules(ProductType productSpec){
        mLog.debug("pre-getMultiSubstitutionRules");
        List<Substitution> substitutions = new ArrayList<>();

        try {
            List<ProductAttributeGroupType> multiProductAttributeGroupValues = specUtil.getMultiProductAttributeGroupValues(productSpec, "InitialisationSubstitutionRules" + environment);

            multiProductAttributeGroupValues.forEach(productAttributeGroup -> {

                Substitution substitution = null;
                for(ProductattributesType productAttribute :productAttributeGroup.getProductAttributes()) {

                    if (productAttribute.getAttributeName().equalsIgnoreCase("SubstituteForWhiteListedNBNumbers")) {
                         substitution = new Banker(productAttribute.getValue());
                    } else if (productAttribute.getAttributeName().equalsIgnoreCase("SubstituteForChannelIDs")) {
                         substitution = new Channel(productAttribute.getValue());
                        String[] channelID = substitution.getType().split("\\|");
                        ((Channel) substitution).getChannelIDWhitelist().addAll(Arrays.asList(channelID));
                    }else if(productAttribute.getAttributeName().equalsIgnoreCase("SubstituteForProductID")){
                        substitution.setProductId(productAttribute.getValue());
                        break;
                    }
                }
                substitutions.add(substitution);
            });

        }catch (InvalidAttributeGroupException iae){}

        return substitutions;
    }

    private List<Banker> getMultiSubstitutionRules(ProductType productSpec, String substitutionRulesKey) throws InvalidAttributeGroupException {
        mLog.debug("pre-getMultiSubstitutionRules"+productSpec+" substitutionRulesKey:"+substitutionRulesKey);
        List<Banker> substitutions = new ArrayList<>();

        List<ProductAttributeGroupType> multiProductAttributeGroupValues = specUtil.getMultiProductAttributeGroupValues(productSpec, substitutionRulesKey + environment);

        multiProductAttributeGroupValues.forEach(productAttributeGroup -> {

            Banker substitution = null;
            for(ProductattributesType productAttribute :productAttributeGroup.getProductAttributes()) {

                if (productAttribute.getAttributeName().equalsIgnoreCase("SubstituteForWhiteListedNBNumbers")) {
                    substitution = new Banker(productAttribute.getValue());
                }else if(productAttribute.getAttributeName().equalsIgnoreCase("SubstituteForProductID")){
                    substitution.setProductId(productAttribute.getValue());
                    break;
                }
            }
            substitutions.add(substitution);
        });

        return substitutions;
    }


    private Substitution getSubstitutionRules(ProductType productSpec, String environment){
        mLog.debug("pre-getSubstitutionRules");
        Substitution substitution= null;

        for (ProductAttributeGroupType attributeGroup : productSpec.getProductAttributeGroup()) {
            mLog.debug("Trace 3");

            // Is this the substitution group.
            if (attributeGroup.getAttributeGroupName().equalsIgnoreCase("SubstitutionRules" + environment)) {
                // We've found a substitution group.
                mLog.debug("Trace 4");

                // Must the substitution be done for ALL users or the specific banker that started this case? Or must it be done for a specific channel
                for (ProductattributesType attribute : attributeGroup.getProductAttributes()) {
                    mLog.debug("Trace 5");

                    if (attribute.getAttributeName().equalsIgnoreCase("SubstituteForWhiteListedNBNumbers")) {
                        mLog.debug("Trace 6 >>SubstituteForWhiteListedNBNumbers<<,>>" + attribute.getValue() + "<<");
                        substitution = new Banker(attribute.getValue());
                    } else if (attribute.getAttributeName().equalsIgnoreCase("SubstituteForChannelIDs")) {
                        mLog.debug("Trace 6.1 >>SubstituteForChannelIDs<<,>>" + attribute.getValue() + "<<");
                        if(substitution != null && substitution instanceof Banker)
                            continue;

                        substitution = new Channel(attribute.getValue());
                        String[] channelID = substitution.getType().split("\\|");
                        ((Channel)substitution).getChannelIDWhitelist().addAll(Arrays.asList(channelID));
                    } else if (attribute.getAttributeName().equalsIgnoreCase("SubstituteForProductID")) {
                        mLog.debug("Trace 6.2 >>SubstituteForProductID<<,>>" + attribute.getValue() + "<<");
                        substitution.setProductId(attribute.getValue());
                        return substitution;
                    } else if (attribute.getAttributeName().equalsIgnoreCase("SubstituteForIPSubnets")) {
                        mLog.debug("Trace 6.3 >>SubstituteForIPSubnets<<,>>" + attribute.getValue() + "<<");
                        if(substitution != null && (substitution instanceof Banker || substitution instanceof Channel))
                            continue;

                        substitution = new Subnet(attribute.getValue());
                    }
                }
            }
        }

       return null;
    }


    public ProductType getProductSpecificationXMLByID(String pProductSpecificationID) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

        List<String> productIDs = new ArrayList<String>();
        productIDs.add(pProductSpecificationID);

        List<ProductType> productSpecifications = getProductSpecificationXMLByID(productIDs);

        return productSpecifications.get(0);
    }

    public ProductType getProductSpecificationXMLByID(int pProductSpecificationID) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

        List<Integer> productIDs = new ArrayList<Integer>();
        productIDs.add(new Integer(pProductSpecificationID));

        List<ProductType> productSpecifications = getProductSpecificationXMLByID(productIDs);

        return productSpecifications.get(0);
    }

	private static JAXBContext jaxbContext;
	
	private JAXBContext getJAXBContext() throws JAXBException {
		if(jaxbContext == null) {
			jaxbContext = JAXBContext.newInstance(ProductType.class);
		}
		
		return jaxbContext;
	}

    public List<ProductType> getProductSpecificationXMLByID(List pProductSpecificationID) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

    	List<String> productIDs = new ArrayList<String>();
    	
    	for(Object object: pProductSpecificationID) {
    		productIDs.add(object.toString());
    	}

        mLog.debug("Trace 2 >>" + productIDs + "<<");
    	
    	return getProductSpecificationXMLsByStringIDs(productIDs);
    }
    
    public List<ProductType> getProductSpecificationXMLsByStringIDs(List<String> pProductSpecificationID) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

        List<ProductType> products = new ArrayList<ProductType>();

        for (String productId : pProductSpecificationID) {

            mLog.debug("Trace 2 >> productId:" + productId + "<<");

            if(productTypeCacheEJB.contains(productId)){
                ProductType productType = productTypeCacheEJB.get(productId);
                mLog.debug("## CACHE ## productType:"+productType);
                products.add(productType);
                continue;
            }


//			mLog.debug("Trace 2.1 >>" + xmlString + "<<");

            JAXBContext jaxbContext = getJAXBContext();
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            mLog.debug("Trace 3");

            try {
                mLog.debug("Trace 3.1");

                //Setup schema validator
                if (ENABLE_XSD_VALIDATION) {
                    mLog.debug("Trace 3.2");
                    SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                    Source schemaFile = new StreamSource(getClass().getClassLoader().getResourceAsStream("/za/co/nb/productcatalogue/ejb/ProductTypeSchema.xsd"));

                    mLog.debug("Trace 3.3");

                    Schema schema = sf.newSchema(schemaFile);
                    jaxbUnmarshaller.setSchema(schema);
                }

                mLog.debug("Trace 3.4");
                // We now only read from files.
                RawSpecString rawSpecString = readProductSpecificationFromResourceFile(productId);

                if(!rawSpecString.isJuristic()){
                    cacheRetailProductType(products, productId, rawSpecString);
                    continue;
                }else {
                    ProductType productType = (ProductType) JAXBIntrospector.getValue(jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(rawSpecString.getXmlString().getBytes())));
                    products.add(productType);
                }

                mLog.debug("Trace 4.1");
            } catch (Exception e) {
                // Schema validator is a mess. It returns no stack trace on the exception. Need to specifically handle it.
                mLog.warn("ProductId >>" +productId+" failure, reason:"+ e.getMessage() + "<<");
                throw new Exception("ProductSpec lookup failure: product: " + productId + ", reason:" + e.getMessage());
            }

            mLog.debug("Trace 5");
        }

        mLog.debug("Trace 6");

        return products;
    }

    private void cacheRetailProductType(List<ProductType> products, String productId, RawSpecString rawSpecString) {
        ProductType productType = productTypeInheritanceLoader.load(rawSpecString.getXmlString(), true);
        injectDynamicStaffList(productType, "InitialisationSubstitutionRules" + environment, productId);
        injectDynamicStaffList(productType,"OfferCrossSellSubstitutionRules" + environment, productId);
        injectDynamicProperty(productType, rawSpecString);

        productTypeCacheEJB.put(productId, productType);
        products.add(productType);
    }

    private void injectDynamicStaffList(ProductType productType, String rule, String productId){
        try {
            ProductattributesType productAttributes = specUtil.getProductAttributes(productType, rule, "SubstituteForWhiteListedNBNumbers");
            if(productAttributes.getValue().contains(DYNAMIC_STAFF_MARkER)){
                String staffList = dynamicWhitelistBean.getStaffList(productId);
                mLog.debug("staffList:" + staffList);
                productAttributes.setValue(staffList);
            }

        }catch (InvalidAttributeException e){}
    }

    private void injectDynamicProperty(ProductType productType, RawSpecString rawSpecString){

	    if(!rawSpecString.getXmlString().contains("${{"))
	        return;

        productType.getProductAttributeGroup().forEach(productAttributeGroupType ->
            productAttributeGroupType.getProductAttributes().forEach(productAttributesType -> {
                if(productAttributesType.getValue() != null && !productAttributesType.getValue().contains(DYNAMIC_STAFF_MARkER)) {
                    if (productAttributesType.getValue().contains("${{")) {

                        mLog.debug("find dynamic value:" + productAttributesType.getValue());
                        String propertyValue = dynamicPropertyBean.getProperty(productAttributesType.getValue());
                        mLog.debug("found dynamic value:" + propertyValue);
                        productAttributesType.setValue(propertyValue);
                    }
                }
            })
        );

    }


    private Object lookupObject(String pJNDI) throws NamingException {
        mLog.debug("Trace 1");

        Object objref = null;
        Context vInitialContext = new InitialContext();
        try {
            mLog.debug("Trace 2");

            objref = vInitialContext.lookup("cell/persistent/" + pJNDI);
        } catch (Exception e) {
            mLog.debug("Trace 3");

            try {
                mLog.debug("Trace 4");

                objref = vInitialContext.lookup("node/persistent/" + pJNDI);
            } catch (Exception e2) {
                mLog.debug("Trace 5");

                objref = vInitialContext.lookup(pJNDI);
            }
        }

        mLog.debug("Trace 6");

        return objref;
    }

    private String retrieveProductIDSubstitution(String productID) {
        mLog.debug("Trace 1");

        try {
            Object objref = lookupObject("PC_" + productID + "Substitution");
            String value = (String) PortableRemoteObject.narrow(objref, String.class);

            mLog.debug("Trace 2 >>" + value + "<<");

            if (value != null) {
                mLog.debug("Trace 3 >>" + value + "<<");
                return value;
            } else {
                mLog.debug("Trace 4");

                return productID;
            }
        } catch (Exception e) {
            mLog.debug("Trace 5");
            return productID;
        }
    }

    private RawSpecString readProductSpecificationFromResourceFile(String productID) throws Exception {
        mLog.debug("Trace 1 >>" + productID + "<<");

        // Look for a string binding that switches this product spec out for another.
        productID = retrieveProductIDSubstitution(productID);

        mLog.debug("Trace 1.1 >>" + productID + "<<");

        try {
            /*
            if (cache.containsKey(productID)){
                return (String) cache.get(productID);
            }*/
            InputStream inputStream = ProductSpecificationsEJB.class.getResourceAsStream("/productspecs/" + productID + ".xml");

            if (inputStream == null) {

                String productSpecificationXMLByID = getJuristicProductSpecificationsRemote().getProductSpecificationsXML(productID);
                if(productSpecificationXMLByID != null)
                    return new RawSpecString(true, productSpecificationXMLByID);

                mLog.debug("Trace 2");
                throw new Exception("Unable to find specification XML file for product ID " + productID);

            }

            mLog.debug("Trace 3");
            String XMLSpec = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());

           // cache.putIfAbsent(productID, XMLSpec);

            return new RawSpecString(false, XMLSpec);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Unable to find specification XML file for product ID " + productID);
        }
    }


    private IJuristicProductSpecifications getJuristicProductSpecificationsRemote(){

        if(juristicProductSpecificationsRemote != null)
            return juristicProductSpecificationsRemote;

        try {
            InitialContext context = new InitialContext();
            return (IJuristicProductSpecifications)context.lookup("java:global/SysJuristicProductCatalogue/WebJuristicProductCatalogue/JuristicProductSpecifications!za.co.nb.juristic.productcatalogue.remoteejb.IJuristicProductSpecifications");


        } catch(Exception e) {
            throw new RuntimeException("Juristic EJB jndi lookup failed, reason:"+e.getMessage());
        }
    }




    public static void main(String[] args) {

        try {
            ProductSpecificationsEJB dao = new ProductSpecificationsEJB();

            List<Integer> productIDs = new ArrayList<Integer>();
            productIDs.add(new Integer(1019));

            try {
                dao.getProductSpecificationXMLByID(productIDs);
                dao.getProductSpecificationXMLByID(productIDs);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String crossSellProductSubstitution(ProductType productSpec, String initiatingStaffNBNumber) throws InvalidAttributeGroupException {

        List<Banker> bankers = getMultiSubstitutionRules(productSpec, "OfferCrossSellSubstitutionRules");
        return processMultiSubstitution(initiatingStaffNBNumber, productSpec, bankers);
    }


    public String initialiseBankerProductSubstitution(ProductType productSpec, String initiatingStaffNBNumber) throws InvalidAttributeGroupException {

        List<Banker> bankers = getMultiSubstitutionRules(productSpec, "InitialisationSubstitutionRules");
        return processMultiSubstitution(initiatingStaffNBNumber, productSpec, bankers);
    }

}
