package za.co.nb.productcatalogue.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileNotFoundException;


public class ProductCataloguesDAO extends AbstractProductCatalogueDAO {

	private static final Log mLog = LogFactory.getLog(ProductCataloguesDAO.class);

	public String getProductCatalogueJSONByID(String pProductCatalogueID) throws Exception {
		mLog.debug("Trace 1 >>" + pProductCatalogueID + "<<");
		
		// First check whether the catalogue is in the cache.

			if (pProductCatalogueID.equalsIgnoreCase("all")) {
				mLog.debug("Trace 3");

				String result = getProductCatalogAllJson(pProductCatalogueID);
				return result;
			} else {
				mLog.debug("Trace 4");
				String catalogueString = retrieveRatesInjectedProductCatalog(pProductCatalogueID);

				return catalogueString;
			}
	}

	@Deprecated
	public String getProductCatalogAllJson(String id) throws Exception, FileNotFoundException {
		throw new Exception("The use of the database for product specifications has been deprecated. Please maintain product specifications in the relevant GIT repo.");
	}


	

		
    public static void main(String...args) {
    	ProductCataloguesDAO dao = new ProductCataloguesDAO();

    	try {
    		String hierarchyJSONString = "\"%Dec%4.95%Dec%\"";

    		
			hierarchyJSONString = hierarchyJSONString.replaceAll("\"\\%Dec\\%", "");

			hierarchyJSONString = hierarchyJSONString.replaceAll("\\%Dec\\%\"", "");

/*    		
			String hierarchyData = dao.readProductHierarchyFromResourceFile("SALESCAT1BaseRateTest");


			hierarchyData = dao.injectUpperAndLowerRatesAsString(hierarchyData);
			hierarchyData = dao.injectUpperAndLowerRatesAsDecimal(hierarchyData);;
*/	        
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
    			resourceData = matcher.replaceFirst("" + counter++);
        		matcher = pattern.matcher(resourceData);
    		}

*/    		
		} catch (Exception e) {
			mLog.error("", e);
		}        
    
    }
    
	
}
