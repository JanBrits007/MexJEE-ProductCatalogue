package za.co.nb.productcatalogue.dao;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductCataloguesDAO {

	private final Log mLog = LogFactory.getLog(getClass());

	private String readProductHierarchyFromResourceFile(String productCatalogueID) throws Exception {
    	mLog.debug("Trace 1 >>" + productCatalogueID + "<<");

		try {
			InputStream inputStream = ProductSpecificationsServiceDAO.class.getResourceAsStream("/productcatalogue/" + productCatalogueID + ".json");
			
			if(inputStream == null) {
		    	mLog.debug("Trace 2");
				throw new Exception("Unable to find product hierarchy for catalogue ID " + productCatalogueID);
			}
			
			ByteArrayOutputStream result = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length;
			
			while ((length = inputStream.read(buffer)) != -1) {
			    result.write(buffer, 0, length);
			}

	    	mLog.debug("Trace 3");
			
			String JSONHierarchy = result.toString(StandardCharsets.UTF_8.name());
	
			return JSONHierarchy;
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Unable to find product hierarchy for catalogue ID " + productCatalogueID);
		}
	}
	
	public String getProductCatalogueJSONByID(String pProductCatalogueID) throws Exception {
		mLog.debug("Trace 1 >>" + pProductCatalogueID + "<<");

		if (pProductCatalogueID.equalsIgnoreCase("all")) {
	    	mLog.debug("Trace 2");
	    	
			String result = getProductCatalogAllJson(pProductCatalogueID);
			return result;
		} else {
	    	mLog.debug("Trace 3");
			
			return readProductHierarchyFromResourceFile(pProductCatalogueID);
		}
	}

	private String getProductCatalogAllJson(String id) throws Exception, FileNotFoundException {
		throw new Exception("The use of the database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
	}

	private String findProductDetailsJSONByID(String pProductCatalogueID) throws Exception {
		throw new Exception("The use of the database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
	}

	private String findProductDetaJSONByID(String pProductCatalogueID) throws Exception {
		throw new Exception("The use of the database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
	}
}
