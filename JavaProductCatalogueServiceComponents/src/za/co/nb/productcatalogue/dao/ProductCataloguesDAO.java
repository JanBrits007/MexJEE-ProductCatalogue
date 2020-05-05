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

import za.co.nb.system.config.dao.SystemConfiguratorDAO;
import za.co.nb.system.config.environment.Environment;

public class ProductCataloguesDAO {

	private final Log mLog = LogFactory.getLog(getClass());

	private static Map<String, String> mCatalogueCache = new HashMap<String, String>();
	
	public String readProductHierarchyFromResourceFile(String productCatalogueID) throws Exception {
    	mLog.debug("Trace 1 >>" + productCatalogueID + "<<");

		try {
			return readDataFromJSONResourceFile("/productcatalogue/" + productCatalogueID + ".json");
		} catch(Exception e) {
			e.printStackTrace();
			return "Unable to compose hierarchy for catalogue ID " + productCatalogueID + ". Please check the log file for detailed exception message";
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

	    	mLog.debug("Trace 2.1");
			
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

	private double getProductSpecificUpperRate(String productID) throws Exception {
    	mLog.debug("Trace 1");

    	SystemConfiguratorDAO dao = new SystemConfiguratorDAO();
    	Environment.InvestmentsRatesMap investmentRatesMap =  dao.getEnvironment().INVESTMENTS_RATES_TABLES;

    	mLog.debug("Trace 2");
    	
    	if(investmentRatesMap == null || investmentRatesMap.getValue() == null || investmentRatesMap.getValue().get(productID) == null) {
    		return 0.00;
    	}
    	
    	return investmentRatesMap.getValue().get(productID).getUpperLimitRate();
	}

	private double getProductSpecificLowerRate(String productID) throws Exception {
    	mLog.debug("Trace 1");

    	SystemConfiguratorDAO dao = new SystemConfiguratorDAO();
    	Environment.InvestmentsRatesMap investmentRatesMap =  dao.getEnvironment().INVESTMENTS_RATES_TABLES;

    	mLog.debug("Trace 2");
    	
    	return investmentRatesMap.getValue().get(productID).getLowerLimitRate();
	}
	
	private double getBaseRate() throws Exception {
    	mLog.debug("Trace 1");

    	SystemConfiguratorDAO dao = new SystemConfiguratorDAO();
    	Environment.BaseRate baseRateConfig = dao.getEnvironment().BASE_RATE;
    	
		double baseRate = Double.parseDouble(baseRateConfig.getValue());
		
    	mLog.debug("Trace 2 >>" + baseRate + "<<");
		
		return baseRate;
	}
	
	private String injectVariableRates(String hierarchyJSONString) {
    	mLog.debug("Trace 1");
		
    	// In case it goes pear shaped, we will return this,
    	String originalHierarchyJSONString = new String(hierarchyJSONString);
    	
    	// Scan the whole string for base rate markers.
    	try {
			mLog.debug("Trace 1 >>" + hierarchyJSONString + "<<");
			
			// Find the baseRate markers.
			// Check whether there are any resource file references to replace.
			// %baseRate + 2.3%
			Pattern pattern = Pattern.compile("\\%baseRate.*?\\%");
	        Matcher matcher = pattern.matcher(hierarchyJSONString);
	        
	        String variableRate = "N/A";
	        double rate = 0.0;
	        
	        while (matcher.find()) {
				mLog.debug("Trace 2");

	        	// Process the next reference to a file.
		    	String baseRateMarker = matcher.group(0);
		    	
				mLog.debug("Trace 3 >>" + baseRateMarker + "<<");
		    	
				// Look for any +/- in the base rate
				if(baseRateMarker.contains("-")) {
					mLog.debug("Trace 4");

					// Split out the variable rate party.
					variableRate = baseRateMarker.replaceAll(".*\\-", "").trim();
					variableRate = variableRate.replaceAll("\\%", "").trim();
					mLog.debug("Trace 4.1 >>" + variableRate + "<<");
					
					rate = getBaseRate() - new Double(variableRate).doubleValue();
					
					mLog.debug("Trace 4.2 >>" + rate + "<<");
				}
				else if(baseRateMarker.contains("+")) {
					mLog.debug("Trace 5");

					// Split out the variable rate party.
					variableRate = baseRateMarker.replaceAll(".*\\+", "").trim();
					variableRate = variableRate.replaceAll("\\%", "").trim();
					mLog.debug("Trace 5.1 >>" + variableRate + "<<");
					
					rate = getBaseRate() + new Double(variableRate).doubleValue();
					
					mLog.debug("Trace 5.2 >>" + rate + "<<");
				}
				else {
					mLog.debug("Trace 6");

					// Split out the variable rate party.
					variableRate = baseRateMarker.replaceAll(".*\\+", "").trim();
					variableRate = variableRate.replaceAll("\\%", "").trim();
					mLog.debug("Trace 6.1 >>" + variableRate + "<<");
					
					rate = getBaseRate();
					
					mLog.debug("Trace 6.2 >>" + rate + "<<");
				}

		    	mLog.debug("Trace 7 >>" + rate + "<<");
				
		    	// Replace the variable rate in the matched pattern entry.
				hierarchyJSONString = matcher.replaceFirst("" + rate);

		    	mLog.debug("Trace 8 >>" + hierarchyJSONString + "<<");
				
		    	// Reset the matcher on the updated data.
        		matcher = pattern.matcher(hierarchyJSONString);
	        }

	        mLog.debug("Trace 9 >>" + hierarchyJSONString + "<<");

	    	return hierarchyJSONString;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		
    		// It's gone pear shaped.
    		return originalHierarchyJSONString;
    	}
	}

	private String injectUpperAndLowerRates(String hierarchyJSONString) {
    	mLog.debug("Trace 1");
		
    	// In case it goes pear shaped, we will return this,
    	String originalHierarchyJSONString = new String(hierarchyJSONString);
    	
    	// Scan the whole string for base rate markers.
    	try {
			mLog.debug("Trace 2 >>" + hierarchyJSONString + "<<");
			
	        // Handle upper rates.
			// Find the upper rate markers.
			// Check whether there are any resource file references to replace.
			Pattern pattern = Pattern.compile("\\%upperRate.*?\\%");
	        Matcher matcher = pattern.matcher(hierarchyJSONString);
	        
	        double rate = 0.0;

	        while (matcher.find()) {
				mLog.debug("Trace 3");

	        	// Process the next reference to a file.
		    	String upperRateMarker = matcher.group(0);
		    	
				mLog.debug("Trace 4 >>" + upperRateMarker + "<<");
		    	
				mLog.debug("Trace 5");

				// Split out the variable rate party.
				String productID = upperRateMarker.replaceAll(".*\\-", "").trim();
				productID = productID.replaceAll("\\%", "").trim();
				mLog.debug("Trace 5.1 >>" + productID + "<<");

				// Get the upper rate for this product ID.
				rate = getProductSpecificUpperRate(productID);
				
		    	// Replace the variable rate in the matched pattern entry.
				hierarchyJSONString = matcher.replaceFirst("" + rate);

		    	mLog.debug("Trace 6 >>" + hierarchyJSONString + "<<");
				
		    	// Reset the matcher on the updated data.
        		matcher = pattern.matcher(hierarchyJSONString);
	        }

	        // Handle lower rates.
			// Find the lower rate markers.
			// Check whether there are any resource file references to replace.
			pattern = Pattern.compile("\\%lowerRate.*?\\%");
	        matcher = pattern.matcher(hierarchyJSONString);
	        
	        rate = 0.0;

	        while (matcher.find()) {
				mLog.debug("Trace 7");

	        	// Process the next reference to a file.
		    	String lowerRateMarker = matcher.group(0);
		    	
				mLog.debug("Trace 8 >>" + lowerRateMarker + "<<");
		    	
				mLog.debug("Trace 9");

				// Split out the variable rate party.
				String productID = lowerRateMarker.replaceAll(".*\\-", "").trim();
				productID = productID.replaceAll("\\%", "").trim();
				mLog.debug("Trace 9.1 >>" + productID + "<<");

				// Get the lower rate for this product ID.
				rate = getProductSpecificLowerRate(productID);
				
		    	// Replace the variable rate in the matched pattern entry.
				hierarchyJSONString = matcher.replaceFirst("" + rate);

		    	mLog.debug("Trace 8 >>" + hierarchyJSONString + "<<");
				
		    	// Reset the matcher on the updated data.
        		matcher = pattern.matcher(hierarchyJSONString);
	        }
	        
	        mLog.debug("Trace 9 >>" + hierarchyJSONString + "<<");

	    	return hierarchyJSONString;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		
    		// It's gone pear shaped.
    		return originalHierarchyJSONString;
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
		    	
		    	// Post process the catalogue to inject all base rate linked variable rate references.
		    	catalogueString = injectVariableRates(catalogueString);
		    	
		    	// Post process the catalogue to inject all the upper and lower rates.
		    	catalogueString = injectUpperAndLowerRates(catalogueString);
		    	
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
			String hierarchyData = dao.readProductHierarchyFromResourceFile("SALESCAT1BaseRateTest");
			
			System.out.println("Trace 1 >>" + hierarchyData + "<<");

			hierarchyData = dao.injectUpperAndLowerRates(hierarchyData);

			System.out.println("Trace 2 >>" + hierarchyData + "<<");

//	        System.out.println("Trace 9 >>" + hierarchyData + "<<");
	        
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
