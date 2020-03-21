package za.co.nb.productcatalogue.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.MaintainCatalogueRequestType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

public class ProductSpecificationsServiceDAO {

	private final Log mLog = LogFactory.getLog(getClass());
	private static Map<String, ProductType> ptCache = new HashMap<String, ProductType>();
	private static Map<String, String> ptXMLStringCache = new HashMap<String, String>();

	public String createProductSpecificationJSON(String pCustomerXML, String pName, String pLastName, Calendar pDateOfBirth, String pIDType, String pIDNumber, String pCustomerType, String pRequiredCustomerUID) throws Exception {
		throw new Exception("The use of the DB2 database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
	}

	public String getProductSpecificationXMLStringByID(String pProductSpecificationID) throws Exception {
		mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

		if (ptXMLStringCache.containsKey(pProductSpecificationID)) {
			mLog.debug("Trace 2 >>Using Cache<<");
			return ptXMLStringCache.get(pProductSpecificationID);
		} 
		else {
			mLog.debug("Trace 3 >>Loading from Resource File<<,>>" + ptCache.keySet().size() + "<<");

			String xmlString = readProductSpecificationFromResourceFile(pProductSpecificationID);
			
			ptXMLStringCache.put(pProductSpecificationID, xmlString);
			
			return xmlString;
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
			
			// TODO: Switch out the product ID if there is a string binding
			// substitution.
			
			/*
			 * if (CachedNameSpaceBindingHelper.getNameSpaceBinding(
			 * "PC_1019Substitution", "3019").equalsIgnoreCase("true")) {
			 * pProductSpecificationID.add(3019); }
			 */
			
			if (ptCache.containsKey(id.toString())) {
				mLog.debug("Trace 3 >>Using Cache<<");
				products.add(ptCache.get(id.toString()));
			} 
			else {
				mLog.debug("Trace 4 >>Loading from Resource File<<,>>" + ptCache.keySet().size() + "<<");
				za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ObjectFactory objectFactory = new za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ObjectFactory();
				ProductType prdType = objectFactory.createProductType();

				// We now only read from files.
				String xmlString = readProductSpecificationFromResourceFile(id);

				JAXBContext jaxbContext = JAXBContext.newInstance("za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1");
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				Object schemaObject = JAXBIntrospector.getValue(unmarshaller.unmarshal(new ByteArrayInputStream(xmlString.getBytes())));

				prdType = (ProductType) schemaObject;
				products.add(prdType);

				// Put the product spec in the cache.
				ptCache.put(id.toString(), prdType);
			}
		}

		mLog.debug("Trace 5");
		
		return products;
	}

	public String maintainCatalogueOperations(MaintainCatalogueRequestType maintainCatalogueRequest) throws Exception {
		throw new Exception("The use of the database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
	}

	private String readProductSpecificationFromResourceFile(Integer productID) throws Exception {
		return readProductSpecificationFromResourceFile(productID.toString());
	}

	private Object lookupObject(String pJNDI) throws NamingException {
		mLog.debug("Trace 1");

		Object objref = null;
		Context vInitialContext = new InitialContext();
		try {
			mLog.debug("Trace 2");

			objref = vInitialContext.lookup("cell/persistent/" + pJNDI);
		}
		catch(Exception e) {
			mLog.debug("Trace 3");

			try {
				mLog.debug("Trace 4");

				objref = vInitialContext.lookup("node/persistent/" + pJNDI);
			}
			catch(Exception e2) {
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
			String value = (String)PortableRemoteObject.narrow(objref, String.class);
			
	    	mLog.debug("Trace 2 >>" + value + "<<");
			
			if(value != null) {
				mLog.debug("Trace 3 >>" + value + "<<");
				return value;
			}
			else {
		    	mLog.debug("Trace 4");

		    	return productID;
			}
		}
		catch(Exception e) {
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
			InputStream inputStream = ProductSpecificationsServiceDAO.class.getResourceAsStream("/productspecs/" + productID + ".xml");
			
			if(inputStream == null) {
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
			ProductSpecificationsServiceDAO dao = new ProductSpecificationsServiceDAO();
			
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
