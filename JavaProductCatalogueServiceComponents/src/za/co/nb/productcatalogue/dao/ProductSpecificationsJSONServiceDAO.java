package za.co.nb.productcatalogue.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.productcatalogue.dto.ProductSpecificationJSON;
import za.co.nb.juristic.productcatalogue.remoteejb.IJuristicProductSpecifications;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

import javax.naming.InitialContext;

public class ProductSpecificationsJSONServiceDAO {

	private final Log mLog = LogFactory.getLog(getClass());
	private ProductSpecificationsServiceDAO mProductSpecificationsDAO;
	private static Map<String, String> ptJSONStringCache = new HashMap<String, String>();
	private IJuristicProductSpecifications juristicProductSpecificationsRemote;

	private ProductSpecificationsServiceDAO getProductSpecificationsDAO() {
    	mLog.debug("Trace 1");

    	if (mProductSpecificationsDAO == null) {
        	mLog.debug("Trace 2");
			mProductSpecificationsDAO = new ProductSpecificationsServiceDAO();
		}

    	mLog.debug("Trace 3");
    	
		return mProductSpecificationsDAO;
	}

	private String readProductSpecificationFromResourceFile(String productID) throws Exception {
    	mLog.debug("Trace 1 >>" + productID + "<<");

		if (ptJSONStringCache.containsKey(productID)) {
			mLog.debug("Trace 2 >>Using Cache<<");
			return ptJSONStringCache.get(productID);
		} 
		else {
			mLog.debug("Trace 3 >>Loading from resource file<<");
			try {
				InputStream inputStream = ProductSpecificationsServiceDAO.class.getResourceAsStream("/productspecs/" + productID + ".json");
				mLog.debug("Trace 4a");
				inputStream = null;
				if(inputStream == null) {
					String productSpecificationJSON = getJuristicProductSpecificationsRemote().getProductSpecificationsJSON(productID);
					if(productSpecificationJSON != null) {
						ptJSONStringCache.put(productID, productSpecificationJSON);
                        mLog.debug("Trace 4 JU");
                        //mLog.debug("Trace 4 JU" + productSpecificationJSON);
						return productSpecificationJSON;
					}

					// load parent spec if not found
					ProductType product = getProductSpecificationsDAO().getProductSpecificationXMLByID(productID);
					mLog.debug("Trace 4b" + product);
					Integer parentProduct = product.getProductIdentifier();
					mLog.debug("Trace 4c" + parentProduct);
					String productIdentifier = Integer.toString(parentProduct);
					mLog.debug("Trace 4d" + productIdentifier);
                    InputStream inputStream2 = ProductSpecificationsServiceDAO.class.getResourceAsStream("/productspecs/" + productIdentifier + ".json");

					mLog.debug("Trace 4e");
                    if(inputStream2 != null) {
                        String JSONParentSpec = IOUtils.toString(inputStream2, StandardCharsets.UTF_8.name());
                        mLog.debug("Trace 4f using parent: " + productIdentifier);
                        //mLog.debug("Trace 4f" + JSONParentSpec);
                        ptJSONStringCache.put(productID, JSONParentSpec);

                        return JSONParentSpec;
                    }
					throw new Exception("Unable to find specification JSON file for product ID " + productID);
				}

				String JSONSpec = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
                mLog.debug("Trace 4g using product: " + productID);
                //mLog.debug("Trace 4g" + JSONSpec);
				ptJSONStringCache.put(productID, JSONSpec);
				
				return JSONSpec;
			} catch (IOException e) {
				e.printStackTrace();
				throw new Exception("Unable to find specification JSON file for product ID " + productID);
			}
		}
	}

	private IJuristicProductSpecifications getJuristicProductSpecificationsRemote(){

		if(juristicProductSpecificationsRemote != null)
			return juristicProductSpecificationsRemote;

		try {
			InitialContext context = new InitialContext();
			return (IJuristicProductSpecifications)context.lookup("java:global/SysJuristicProductCatalogue/EJBJuristicProductCatalogue/JuristicProductSpecificationsEJB!za.co.nb.productcatalogue.ejb.JuristicProductSpecificationsRemote");


		} catch(Exception e) {
			throw new RuntimeException("Juristic EJB jndi lookup failed, reason:"+e.getMessage());
		}
	}
	
	public String getProductSpecificationJSONByID(String pProductSpecificationID) throws Exception {
		mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

		String vProductSpecificationHeaderJSON = "";
		String vProductSpecificationDetailsJSON = "";

		if (pProductSpecificationID.equalsIgnoreCase("all")) {
	    	mLog.debug("Trace 2");
			String result = getProductSpecAllJson(pProductSpecificationID);
			return result;

		}
		else if (pProductSpecificationID.equalsIgnoreCase("allxml")) {
	    	mLog.debug("Trace 3");
			String result = getProductSpecAllXml(pProductSpecificationID);
			return result;
		}
		else if (pProductSpecificationID.contains("xmlid"))
		{
	    	mLog.debug("Trace 4");
	    	
			String id = pProductSpecificationID.replaceAll("xmlid", "").trim();

			return getProductSpecificationsDAO().getProductSpecificationXMLStringByID(id);
		} else {
			mLog.debug("Trace 5");
			
			vProductSpecificationDetailsJSON = readProductSpecificationFromResourceFile(pProductSpecificationID);
			
			mLog.debug("Trace 6 >>" + vProductSpecificationDetailsJSON.length() + "<<");
			mLog.debug("Trace 7 >>" + vProductSpecificationDetailsJSON + "<<");

			ProductSpecificationJSON vProductSpecificationJSON = new ProductSpecificationJSON();
			vProductSpecificationJSON.setHeader(vProductSpecificationHeaderJSON);
			vProductSpecificationJSON.setmDetails(vProductSpecificationDetailsJSON);

			return vProductSpecificationDetailsJSON;
		}
	}

	public void maintainProductSpecificationJSON(String pCustomerUID, String pCustomerXML, String pName, String pLastName, Calendar pDateOfBirth, String pIDType, String pIDNumber, String pCustomerType) throws Exception, Throwable {
		throw new Exception("The use of the database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
	}

	private String getProductSpecAllJson(String id) throws Exception, FileNotFoundException {
		throw new Exception("The use of the database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
	}

	private String getProductSpecAllXml(String id) throws Exception, FileNotFoundException {
		throw new Exception("The use of the database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
	}
}
