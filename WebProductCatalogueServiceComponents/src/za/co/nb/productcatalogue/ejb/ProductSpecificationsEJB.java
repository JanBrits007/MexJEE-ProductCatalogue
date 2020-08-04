package za.co.nb.productcatalogue.ejb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseHeader;
import za.co.nb.productcatalogue.cases.dao.BusinessCaseDAO;
import za.co.nb.productcatalogue.dao.ArrangementMetricsDAO;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.MaintainCatalogueRequestType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductAttributeGroupType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductattributesType;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Stateless
public class ProductSpecificationsEJB implements ProductSpecificationsServiceRemoteInterface {

    private final Log mLog = LogFactory.getLog(getClass());

    private static final boolean ENABLE_XSD_VALIDATION = false;

    public String createProductSpecificationJSON(String pCustomerXML, String pName, String pLastName, Calendar pDateOfBirth, String pIDType, String pIDNumber, String pCustomerType, String pRequiredCustomerUID) throws Exception {
        throw new Exception("The use of the DB2 database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
    }

    public String getProductSpecificationXMLStringByID(String pProductSpecificationID) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

        String xmlString = readProductSpecificationFromResourceFile(pProductSpecificationID);

        return xmlString;
    }

    public ProductType getProductSpecificationByIDAndArrangementID(String productSpecificationID, String arrangementID) throws Exception {
        mLog.debug("Trace 1 >>" + productSpecificationID + "<<,>>" + arrangementID + "<<");

        // First get the case ID based on the arrangement ID.
        if (specHasSubstitutionRules(productSpecificationID)) {
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

        // Get the product spec.
        ProductType productSpec = getProductSpecificationXMLByID(productSpecificationID);

        // What environment are we running in?
        Object objref = null;

        try {
            objref = lookupObject("ENVIRONMENT");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Environment string namespace binding not defined in server");
        }

        String environment = (String) PortableRemoteObject.narrow(objref, String.class);

        mLog.debug("Trace 2 >>" + environment + "<<");

        String substitutedProductID = null;
        String bankerWhitelist = null;
        String channelWhitelist = null;
        String substituteForIPSubnets = null;


        // Now check if there are substitution rules.
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

                        bankerWhitelist = attribute.getValue();
                    } else if (attribute.getAttributeName().equalsIgnoreCase("SubstituteForChannelIDs")) {
                        mLog.debug("Trace 6.1 >>SubstituteForChannelIDs<<,>>" + attribute.getValue() + "<<");

                        channelWhitelist = attribute.getValue();
                    } else if (attribute.getAttributeName().equalsIgnoreCase("SubstituteForProductID")) {
                        mLog.debug("Trace 6.2 >>SubstituteForProductID<<,>>" + attribute.getValue() + "<<");

                        substitutedProductID = attribute.getValue();
                    }
                    else if (attribute.getAttributeName().equalsIgnoreCase("SubstituteForIPSubnets")) {
                        mLog.debug("Trace 6.3 >>SubstituteForIPSubnets<<,>>" + attribute.getValue() + "<<");

                        substituteForIPSubnets = attribute.getValue();
                    }
                }

                try {
                    mLog.debug("Trace 6.2");

                    // Now check if there is a string binding override for the whitelist.
                    objref = lookupObject(substitutedProductID + "BankerWhitelist");
                    String namespaceBindingWhiteList = (String) PortableRemoteObject.narrow(objref, String.class);

                    mLog.debug("Trace 7 >>" + namespaceBindingWhiteList + "<<");

                    bankerWhitelist = namespaceBindingWhiteList;
                } catch (Exception e) {
                    // Do nothing
                }
            }
        }

        // Must we substitute the product spec?
        if (channelWhitelist != null) {
            mLog.debug("Trace 8 >>" + channelWhitelist + "<<");

            // Get the business case details.
            BusinessCaseDAO dao = new BusinessCaseDAO();
            BusinessCaseHeader caseHeader = dao.retrieveBusinessCase(caseID);

            mLog.debug("Trace 9 >>" + caseHeader.getInitiatingChannelID().toLowerCase() + "<<");

            if ((caseHeader.getInitiatingChannelID() != null &&
                    !caseHeader.getInitiatingChannelID().trim().isEmpty()) &&
                    channelWhitelist.toLowerCase().contains(caseHeader.getInitiatingChannelID().toLowerCase())) {
                // We must substitute.
                mLog.debug("Trace 10 Substituting product ID >>" + productSpecificationID + "<< for product ID >>" + substitutedProductID + "<< for channel >>" + caseHeader.getInitiatingChannelID() + "<<");

                return getProductSpecificationXMLByID(substitutedProductID);
            }
        }
        
        if (substituteForIPSubnets != null) {
            mLog.debug("Trace 8 >>" + substituteForIPSubnets + "<<");

            // Get the business case details.
            BusinessCaseDAO dao = new BusinessCaseDAO();
            BusinessCaseHeader caseHeader = dao.retrieveBusinessCase(caseID);

            mLog.debug("Trace 9 >>" + caseHeader.getInitiatingChannelID().toLowerCase() + "<<");

            if (substituteForIPSubnets.toLowerCase().contains(caseHeader.getInitiatingChannelID().toLowerCase())) {
                // We must substitute.
                mLog.debug("Trace 10 Substituting product ID >>" + productSpecificationID + "<< for product ID >>" + substitutedProductID + "<< for channel >>" + caseHeader.getInitiatingChannelID() + "<<");

                return getProductSpecificationXMLByID(substitutedProductID);
            }
        }

        if (bankerWhitelist != null) {
            mLog.debug("Trace 12 >>" + bankerWhitelist + "<<");

            // Get the business case details.
            BusinessCaseDAO dao = new BusinessCaseDAO();
            BusinessCaseHeader caseHeader = dao.retrieveBusinessCase(caseID);

            mLog.debug("Trace 13 >>" + caseHeader.getInitiatingStaffNBNumber().toLowerCase() + "<<");

            if ((caseHeader.getInitiatingStaffNBNumber() != null &&
                    !caseHeader.getInitiatingStaffNBNumber().trim().isEmpty()) &&
                    bankerWhitelist.toLowerCase().contains(caseHeader.getInitiatingStaffNBNumber().toLowerCase())) {
                // We must substitute.
                mLog.debug("Trace 14 Substituting product ID >>" + productSpecificationID + "<< for product ID >>" + substitutedProductID + "<< for banker >>" + caseHeader.getInitiatingStaffNBNumber() + "<<");

                return getProductSpecificationXMLByID(substitutedProductID);
            } else {
                // We mustn't substitute
                mLog.debug("Trace 15");
                return getProductSpecificationXMLByID(productSpecificationID);
            }
        } else {
            mLog.debug("Trace 16");

            return getProductSpecificationXMLByID(productSpecificationID);
        }
    }

    public ProductType getProductSpecificationXMLByID(String pProductSpecificationID) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

        List<Integer> productIDs = new ArrayList<Integer>();
        productIDs.add(new Integer(pProductSpecificationID));

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

    public List<ProductType> getProductSpecificationXMLByID(List<Integer> pProductSpecificationID) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

        ArrayList<ProductType> products = new ArrayList<ProductType>();

        for (Integer id : pProductSpecificationID) {
            mLog.debug("Trace 2 >>" + id + "<<");

            za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ObjectFactory objectFactory = new za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ObjectFactory();
            ProductType prdType = objectFactory.createProductType();

            // We now only read from files.
            String xmlString = readProductSpecificationFromResourceFile(id);

//			mLog.debug("Trace 2.1 >>" + xmlString + "<<");

            JAXBContext jaxbContext = JAXBContext.newInstance(ProductType.class);
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

                Object schemaObject = JAXBIntrospector.getValue(jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(xmlString.getBytes())));

                mLog.debug("Trace 4");

                prdType = (ProductType) schemaObject;
                products.add(prdType);

                mLog.debug("Trace 4.1");
            } catch (Exception e) {
                mLog.debug("Trace 4.2");
                e.printStackTrace();

                // Schema validator is a mess. It returns no stack trace on the exception. Need to specifically handle it.
                if (e != null && e.getCause() != null) {
                    mLog.debug("Trace 4.3 >>" + e.getCause().getMessage() + "<<");
                    throw new Exception("Schema validation failure for spec " + id + ". " + e.getCause().getMessage());
                }

                mLog.debug("Trace 4.4");

                throw e;
            } catch (Throwable t) {
                mLog.debug("Trace 4.3");
                t.printStackTrace();
                throw new Exception(t);
            }

            mLog.debug("Trace 5");
        }

        mLog.debug("Trace 6");

        return products;
    }

    public String maintainCatalogueOperations(MaintainCatalogueRequestType maintainCatalogueRequest) throws Exception {
        throw new Exception("The use of the database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
    }

    private String readProductSpecificationFromResourceFile(Integer productID) throws Exception {
        mLog.debug("Trace 1");
        return readProductSpecificationFromResourceFile(productID.toString());
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

    private String readProductSpecificationFromResourceFile(String productID) throws Exception {
        mLog.debug("Trace 1 >>" + productID + "<<");

        // Look for a string binding that switches this product spec out for another.
        productID = retrieveProductIDSubstitution(productID);

        mLog.debug("Trace 1.1 >>" + productID + "<<");

        try {
            InputStream inputStream = ProductSpecificationsEJB.class.getResourceAsStream("/productspecs/" + productID + ".xml");

            if (inputStream == null) {
                mLog.debug("Trace 2");
                throw new Exception("Unable to find specification XML file for product ID " + productID);
            }

            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }

            mLog.debug("Trace 3");

            String XMLSpec = result.toString(StandardCharsets.UTF_8.name());

            return XMLSpec;
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Unable to find specification XML file for product ID " + productID);
        }
    }

    public static void main(String[] args) {
        System.out.println("Trace 1");

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

}
