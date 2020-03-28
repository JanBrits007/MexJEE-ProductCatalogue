package za.co.nb.productcatalogue.dao;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class ProductCataloguesDAO {

	private final Log mLog = LogFactory.getLog(getClass());

	private static Map<String, String> mCatalogueCache = new HashMap<String, String>();
	
	public String readProductHierarchyFromResourceFile(String productCatalogueID) throws Exception {
    	mLog.debug("Trace 1 >>" + productCatalogueID + "<<");

		try {
			return readDataFromJSONResourceFile("/productcatalogue/" + productCatalogueID + ".json");
/*			
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
*/			
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Unable to find product hierarchy for catalogue ID " + productCatalogueID);
		}
	}

	private String readDataFromJSONResourceFile(String resourceFilename) throws Exception {
    	mLog.debug("Trace 1 >>" + resourceFilename + "<<");

		try {
			InputStream inputStream = ProductSpecificationsServiceDAO.class.getResourceAsStream(resourceFilename);
			
			if(inputStream == null) {
		    	mLog.debug("Trace 2");
				throw new Exception("Unable to find resource with filename " + resourceFilename);
			}
			
			ByteArrayOutputStream result = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length;
			
			while ((length = inputStream.read(buffer)) != -1) {
			    result.write(buffer, 0, length);
			}

	    	mLog.debug("Trace 3");
			
			String resourceData = result.toString(StandardCharsets.UTF_8.name());

			// Remove pretty printing from resource data.
		    ObjectMapper objectMapper = new ObjectMapper();
		    JsonNode jsonNode = objectMapper.readValue(resourceData, JsonNode.class);			
		    resourceData = jsonNode.toString();
			
			// Check whether there are any resource file references to replace.
	        Pattern pattern = Pattern.compile("\\{\\s*\"fileReference\"\\s*\\:\\s*.*?\\}");
	        Matcher matcher = pattern.matcher(resourceData);
	        while (matcher.find()) {
	        	// Process the next reference to a file.
		    	mLog.debug("Trace 4 >>" + resourceData + "<<");
		    	
		    	// Get the filename
		    	String nestedResourceFilename = extractFilenameFromFileReference(matcher.group(0));
		    	
		    	String nestedData = readDataFromJSONResourceFile(nestedResourceFilename);
		    	
		    	// inject the nestedData in place of the filename reference
		    	resourceData = matcher.replaceFirst(nestedData);

		    	// Reset the matcher on the updated data.
        		matcher = pattern.matcher(resourceData);
		    	
		    	mLog.debug("Trace 5 >>" + resourceData + "<<");
	        }

	    	mLog.debug("Trace 6 >>" + resourceData + "<<");
	        
			return resourceData;
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Unable to find resource with filename - " + resourceFilename);
		}
	}
	
	public String getProductCatalogueJSONByID(String pProductCatalogueID) throws Exception {
		mLog.debug("Trace 1 >>" + pProductCatalogueID + "<<");

		// First check whether the catalogue is in the cache.
		String cachedCatalogue = mCatalogueCache.get(pProductCatalogueID);

		if(cachedCatalogue == null) {
	    	mLog.debug("Trace 2");
	    	
			if (pProductCatalogueID.equalsIgnoreCase("all")) {
		    	mLog.debug("Trace 3");
		    	
				String result = getProductCatalogAllJson(pProductCatalogueID);
				return result;
			} else {
		    	mLog.debug("Trace 4");
				
		    	String catalogueString = readProductHierarchyFromResourceFile(pProductCatalogueID);
		    	
				mCatalogueCache.put(pProductCatalogueID, catalogueString);
		    	
				return catalogueString;
			}
		}
		else {
	    	mLog.debug("Trace 5");
			
	    	return cachedCatalogue;
		}
	}

	private String getProductCatalogAllJson(String id) throws Exception, FileNotFoundException {
		throw new Exception("The use of the database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
	}

	private String extractFilenameFromFileReference(String fileReference) {
    	mLog.debug("Trace 1");

		String filename = fileReference.replaceAll("\\{\\s*\"fileReference\"\\s*\\:\\s*\"", "");

		mLog.debug("Trace 2 >>" + filename + "<<");
		
		filename = filename.replaceAll("\\s*\".*", "");

		mLog.debug("Trace 3 >>" + filename + "<<");
		
		return filename;
	}
		
    public static void main(String...args) {
    	ProductCataloguesDAO dao = new ProductCataloguesDAO();

    	try {
			String data = dao.readProductHierarchyFromResourceFile("SALESCATSelfV2");
			
			System.out.println(data);

/*    		
			InputStream inputStream = ProductSpecificationsServiceDAO.class.getResourceAsStream("/productcatalogue/SALESCATSelfV2.json");
			
			if(inputStream == null) {
				throw new Exception();
			}
			
			ByteArrayOutputStream result = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length;
			
			while ((length = inputStream.read(buffer)) != -1) {
			    result.write(buffer, 0, length);
			}

			String resourceData = result.toString(StandardCharsets.UTF_8.name());

			// Remove pretty printing from resource data.
		    ObjectMapper objectMapper = new ObjectMapper();
		    JsonNode jsonNode = objectMapper.readValue(resourceData, JsonNode.class);			
		    resourceData = jsonNode.toString();
		    
//    		String line = "{\"name\":\"Personal\",\"description\":\"Products for Individuals\",\"productCategories\":[{\"fileReference\":\"/productcatalogue/SALESCATSelfV2_PersonalFamily_BankCategory.json\"},{\"fileReference\":\"/productcatalogue/SALESCATSelfV2_PersonalFamily_BorrowCategory.json\"},{\"fileReference\":\"/productcatalogue/SALESCATSelfV2_PersonalFamily_InvestCategory.json\"},{\"fileReference\":\"/productcatalogue/SALESCATSelfV2_PersonalFamily_ForexCategory.json\"},{\"fileReference\":\"/productcatalogue/SALESCATSelfV2_PersonalFamily_ProtectCategory.json\"}]}";
//			 String line = "{ \"fileReference\" : \"/productcatalogue/SALESCATSelfV2_PersonalFamily.json\"}abc{ \"fileReference\" : \"/productcatalogue/SALESCATSelfV2_PersonalFamily.json\"}";
			 //        Pattern pattern = Pattern.compile("\"fileReference\":\".*\"/}");
    		Pattern pattern = Pattern.compile("\\{\\s*\"fileReference\"\\s*\\:\\s*.*?\\}");
    		Matcher matcher = pattern.matcher(resourceData);
    		
    		int counter = 0;
    		
    		while (matcher.find()) {
    			System.out.println(matcher.group(0));
    			System.out.println(dao.extractFilenameFromFileReference(matcher.group(0)));
    			resourceData = matcher.replaceFirst("" + counter++);
        		System.out.println(">>" + resourceData + "<<");
        		matcher = pattern.matcher(resourceData);
    		}
    		
    		System.out.println(">>" + resourceData + "<<");
*/    		
		} catch (Exception e) {
			e.printStackTrace();
		}        
    }
	
}
