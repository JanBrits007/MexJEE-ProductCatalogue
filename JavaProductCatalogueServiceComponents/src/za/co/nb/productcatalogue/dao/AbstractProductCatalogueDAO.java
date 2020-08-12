package za.co.nb.productcatalogue.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import za.co.nb.productcatalogue.dao.dto.CachedCatalogueDetails;
import za.co.nb.productcatalogue.dao.dto.CatalogueCache;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractProductCatalogueDAO extends AbstractRate {

    private final Log mLog = LogFactory.getLog(getClass());

    @Inject
    @CatalogueCache
    protected Map<String, CachedCatalogueDetails> catalogueCache;

    protected String retrieveRatesInjectedProductCatalog(String productId){
        mLog.debug("retrieve cache productCatalogue:"+productId);

        String catalogueString = readProductHierarchyFromResourceFile(productId);

        // Post process the catalogue to inject all base rate linked variable rate references.
        catalogueString = injectVariableRates(catalogueString);

        // Post process the catalogue to inject all the upper and lower rates as decimals.
        catalogueString = injectUpperAndLowerRatesAsDecimal(catalogueString);

        // Post process the catalogue to inject all the upper and lower rates.
        catalogueString = injectUpperAndLowerRatesAsString(catalogueString);


        return catalogueString;
    }

    protected String readProductHierarchyFromResourceFile(String productCatalogueID) {
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

    private String extractFilenameFromFileReference(String fileReference) {
        mLog.debug("Trace 1");

        String filename = fileReference.replaceAll("\\{\\s*\"fileReference\"\\s*\\:\\s*\"", "");

        mLog.debug("Trace 2 >>" + filename + "<<");

        filename = filename.replaceAll("\\s*\".*", "");

        mLog.debug("Trace 3 >>" + filename + "<<");

        return filename;
    }


    protected void putToCache(String productId, String catalogueString){

        CachedCatalogueDetails cachedCatalogue = new CachedCatalogueDetails();
        cachedCatalogue.setCacheDateTime(new Date());
        cachedCatalogue.setCatalogueContent(catalogueString);
        catalogueCache.put(productId, cachedCatalogue);
    }

}
