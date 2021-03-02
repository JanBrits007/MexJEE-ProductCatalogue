package za.co.nb.productcatalogue.util;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.configuration.environment.EnvironmentValue;
import za.co.nb.onboarding.casemanagement.BusinessCaseManagementDAO;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseHeader;
import za.co.nb.productcatalogue.dao.ArrangementMetricsDAO;
import za.co.nb.productcatalogue.rules.handlers.BaseProductSpecificationRuleHandler;

public class ProductSpecificationSubstitutionUtil {

    private final Log mLog = LogFactory.getLog(getClass());

    private BaseProductSpecificationRuleHandler getProductSubstitutionRuleHandler(String productSpecificationID) {
	    mLog.debug("Trace 1 >>" + productSpecificationID + "<<");

    	BaseProductSpecificationRuleHandler ruleHandler;
		
		try {
			Class theClass = Class.forName("za.co.nb.productcatalogue.rules.handlers.RuleHandler" + productSpecificationID);

			ruleHandler = (BaseProductSpecificationRuleHandler)theClass.newInstance();

		    mLog.debug("Trace 2 >>" + ruleHandler.getClass().getName() + "<<");
			
			return ruleHandler;
		} catch (ClassNotFoundException e1) {
			// There's no rule handler.
            // Now we have to check if there is an environment specific rule handler
            /*try {
                mLog.debug("Trace 2");
                String environment = EnvironmentValue.getInstance().getString("ENVIRONMENT");
                mLog.debug("Trace 2.1 : Environment :"+environment);
                Class theClass = Class.forName("za.co.nb.productcatalogue.rules.handlers.RuleHandler" + productSpecificationID+environment);

                ruleHandler = (BaseProductSpecificationRuleHandler)theClass.newInstance();

                return ruleHandler;
            } catch (Exception e) {
                // There's no rule handler. So do nothing.
                mLog.debug("Trace 3");
                return null;
            }*/
            // There's no rule handler. So do nothing.
            mLog.debug("Trace 3");
            return null;

		} catch (IllegalAccessException e) {
			// There's no rule handler. So do nothing.
            mLog.debug("Trace 4");
			return null;
		} catch (InstantiationException e) {
			// There's no rule handler. So do nothing.
            mLog.debug("Trace 5");
			return null;
		}
    	
    }
    
    public String substituteArrangementProductIDBasedOnBusinessRules(String productSpecificationID, String arrangementID) {
        mLog.debug("Trace 1 >>" + productSpecificationID + "<<,>>" + arrangementID + "<<");
        
    	// First check whether this product ID has a handler defined for it.
        BaseProductSpecificationRuleHandler ruleHandler = getProductSubstitutionRuleHandler(productSpecificationID);
        
        try {
            String caseID = new ArrangementMetricsDAO().retrieveCaseIDByArrangementID(arrangementID);

            BusinessCaseHeader businessCaseHeader = new BusinessCaseManagementDAO().retrieveBusinessCase(caseID);
            boolean subsMap = false;
            if(businessCaseHeader != null && businessCaseHeader.getProductIDSubstitutionMap().get(productSpecificationID) != null) {
                mLog.debug("Trace 2");
                subsMap = true;
            }

            if(!subsMap && ruleHandler == null) {
                mLog.debug("Trace 3");
            	
                // There's no rule handler to switch out the product ID.
                return productSpecificationID;
            }

            mLog.debug("Trace 4");
            
            String productIDToSubstitute = substituteBusinessCaseProductIDBasedOnBusinessRules(productSpecificationID, caseID, ruleHandler);

            mLog.debug("Trace 5 >>" + productIDToSubstitute + "<<");
            		
            return productIDToSubstitute;
        } catch(Exception e) {
            mLog.debug("Trace 6");
        	e.printStackTrace();

        	// Got a problem. Fallback to no substitution.
			return productSpecificationID;
        }
    }

    private String substituteBusinessCaseProductIDBasedOnBusinessRules(String productSpecificationID, String caseID, BaseProductSpecificationRuleHandler ruleHandler) {
        mLog.debug("Trace 1");

    	// Get the case details via DAO.
        BusinessCaseManagementDAO caseDAO = new BusinessCaseManagementDAO();
        
        BusinessCaseHeader businessCase = caseDAO.retrieveBusinessCase(caseID);

        if(businessCase == null) {
            mLog.debug("Trace 1.1");
            
        	// Fallback to no substitution.
        	return productSpecificationID;
        }
        
        // Get the cached list of product substitutions
        Map<String, String> productSubstitutionMap = businessCase.getProductIDSubstitutionMap();
        
        String productSubstitutionID = productSubstitutionMap.get(productSpecificationID);

        mLog.debug("Trace 2 >>" + productSubstitutionID + "<<");
        
        if(productSubstitutionID == null) {
        	// Cache hasn't yet been loaded up.
            mLog.debug("Trace 3");
            
            // Run the rule handler to work out what the product ID should be.
            try {
            	productSubstitutionID = ruleHandler.executeBusinessRules(productSpecificationID, caseID);
            }
            catch(Exception e) {
            	e.printStackTrace();
            	
            	// Something went wrong. Don't break JO. Fallback to their product ID.
            	productSubstitutionID = new String(productSpecificationID);
            }
            		
            // Cache the results.
            businessCase = caseDAO.retrieveBusinessCase(caseID);
            productSubstitutionMap.put(productSpecificationID, productSubstitutionID);
            businessCase.setProductIDSubstitutionMap(productSubstitutionMap);
            // Save back to database.
            caseDAO.cacheBusinessCaseDetailInDB(businessCase);
            
            return productSubstitutionID;
        }
        else {
        	// Cache has been loaded. Return results.
            mLog.debug("Trace 4");
        	return productSubstitutionID;
        }
    }

    public String substituteBusinessCaseProductIDBasedOnBusinessRules(String productSpecificationID, String caseID) {
        mLog.debug("Trace 1 >>" + productSpecificationID + "<<,>>" + caseID + "<<");

    	// First check whether this product ID has a handler defined for it.
        BaseProductSpecificationRuleHandler ruleHandler = getProductSubstitutionRuleHandler(productSpecificationID);

        BusinessCaseHeader businessCaseHeader = new BusinessCaseManagementDAO().retrieveBusinessCase(caseID);
        boolean subsMap = false;
        if(businessCaseHeader != null && businessCaseHeader.getProductIDSubstitutionMap().get(productSpecificationID) != null)
            subsMap = true;

        if(!subsMap && ruleHandler == null) {
        	// There's no rule handler to switch out the product ID.
        	return productSpecificationID;
        }

        return substituteBusinessCaseProductIDBasedOnBusinessRules(productSpecificationID, caseID, ruleHandler);
    }
	
}
