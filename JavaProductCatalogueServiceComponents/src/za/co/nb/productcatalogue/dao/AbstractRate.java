package za.co.nb.productcatalogue.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.system.config.dao.SystemConfiguratorDAO;
import za.co.nb.system.config.environment.Environment;
import za.co.nb.system.pml.service.client.ProductOfferInformationServiceClient;
import za.co.nedbank.cr1.common.helper.mLog;

import javax.xml.ws.Holder;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractRate {

    private final Log mLog = LogFactory.getLog(getClass());

    private static List<String> productIDs = new ArrayList<String>();

    static {
        productIDs.add("1126");
        productIDs.add("1127");
        productIDs.add("1128");
        productIDs.add("1130");
        productIDs.add("1133");
        productIDs.add("1134");
        productIDs.add("1136");
        productIDs.add("1139");
        productIDs.add("1199");
        productIDs.add("1360");
        productIDs.add("1391");
        productIDs.add("1392");
        productIDs.add("1405");
        productIDs.add("1406");
        productIDs.add("1473");
        productIDs.add("1482");
    }

    protected String injectUpperAndLowerRatesAsString(String hierarchyJSONString) {
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

    private double getProductSpecificLowerRate(String productID) throws Exception {
        mLog.debug("Trace 1");

        SystemConfiguratorDAO dao = new SystemConfiguratorDAO();
        Environment.InvestmentsRatesMap investmentRatesMap =  dao.getEnvironment().INVESTMENTS_RATES_TABLES;

        mLog.debug("Trace 2");

        return investmentRatesMap.getValue().get(productID).getLowerLimitRate();
    }

    protected String injectUpperAndLowerRatesAsDecimal(String hierarchyJSONString) {
        mLog.debug("Trace 1");

        // In case it goes pear shaped, we will return this,
        String originalHierarchyJSONString = new String(hierarchyJSONString);

        // Scan the whole string for base rate markers.
        try {
            mLog.debug("Trace 2 >>" + hierarchyJSONString + "<<");

            // Handle upper rates.
            // Find the upper rate markers.
            // Check whether there are any resource file references to replace.
            Pattern pattern = Pattern.compile("\\%upperRateDec.*?\\%");
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
                hierarchyJSONString = matcher.replaceFirst("%Dec%" + rate + "%Dec%");

                mLog.debug("Trace 11 >>" + hierarchyJSONString + "<<");

                // Now replace the string terminators
                hierarchyJSONString = hierarchyJSONString.replaceAll("\"\\%Dec\\%", "");

                mLog.debug("Trace 12 >>" + hierarchyJSONString + "<<");

                hierarchyJSONString = hierarchyJSONString.replaceAll("\\%Dec\\%\"", "");

                mLog.debug("Trace 13 >>" + hierarchyJSONString + "<<");

                // Reset the matcher on the updated data.
                matcher = pattern.matcher(hierarchyJSONString);
            }

            // Handle lower rates.
            // Find the lower rate markers.
            // Check whether there are any resource file references to replace.
            pattern = Pattern.compile("\\%lowerRateDec.*?\\%");
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
                mLog.debug("Trace 10 >>" + productID + "<<");

                // Get the lower rate for this product ID.
                rate = getProductSpecificLowerRate(productID);

                // Replace the variable rate in the matched pattern entry.
                hierarchyJSONString = matcher.replaceFirst("%Dec%" + rate + "%Dec%");

                mLog.debug("Trace 11 >>" + hierarchyJSONString + "<<");

                // Now replace the string terminators
                hierarchyJSONString = hierarchyJSONString.replaceAll("\"\\%Dec\\%", "");

                mLog.debug("Trace 12 >>" + hierarchyJSONString + "<<");

                hierarchyJSONString = hierarchyJSONString.replaceAll("\\%Dec\\%\"", "");

                mLog.debug("Trace 13 >>" + hierarchyJSONString + "<<");

                // Reset the matcher on the updated data.
                matcher = pattern.matcher(hierarchyJSONString);
            }

            mLog.debug("Trace 14 >>" + hierarchyJSONString + "<<");

            return hierarchyJSONString;
        }
        catch(Exception e) {
            e.printStackTrace();

            // It's gone pear shaped.
            return originalHierarchyJSONString;
        }
    }


    private double getProductSpecificUpperRate(String productID) throws Exception {
        mLog.debug("Trace 1");
        mLog.debug(">> productID << " + productID);

        try{

            ProductOfferInformationServiceClient service = new ProductOfferInformationServiceClient();
            double investmentRatesMap = 0;

            //replace this line with my service.
            //Environment.InvestmentsRatesMap investmentRatesMap =  dao.getEnvironment().INVESTMENTS_RATES_TABLES;
            if(productIDs.contains(productID)){
                Long investmentRates = Long.valueOf(productID);
                BigInteger convertedProductID = BigInteger.valueOf(investmentRates);
                Holder<BigInteger> productIdentifier = new Holder<BigInteger>();
                productIdentifier.value = convertedProductID;

                investmentRatesMap = service.retrieveProductInterestRates(productIdentifier);

                mLog.debug("Trace 2");
            }


            if(investmentRatesMap == 0) {
                return 0.00;
            }
            return investmentRatesMap;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Service to Retrieve Product Interest Rates Failed.");
        }
    }

    protected String injectVariableRates(String hierarchyJSONString) {
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

    protected double getBaseRate() throws Exception {
        mLog.debug("Trace 1");

        SystemConfiguratorDAO dao = new SystemConfiguratorDAO();
        Environment.BaseRate baseRateConfig = dao.getEnvironment().BASE_RATE;

        double baseRate = Double.parseDouble(baseRateConfig.getValue());

        mLog.debug("Trace 2 >>" + baseRate + "<<");

        return baseRate;
    }
}
