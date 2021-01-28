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
		BaseProductSpecificationRuleHandler ruleHandler;
		
		try {
		    mLog.debug("Trace 1");
			Class theClass = Class.forName("za.co.nb.productcatalogue.rules.handlers.RuleHandler" + productSpecificationID);

			ruleHandler = (BaseProductSpecificationRuleHandler)theClass.newInstance();
			
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
    	// First check whether this product ID has a handler defined for it.
        BaseProductSpecificationRuleHandler ruleHandler = getProductSubstitutionRuleHandler(productSpecificationID);
        
        if(ruleHandler == null) {
        	// There's no rule handler to switch out the product ID.
        	return productSpecificationID;
        }

        // We have a handler. Need to determine whether it has already been run and the results have been cached in case DB.
        ArrangementMetricsDAO dao = new ArrangementMetricsDAO();
        
        String caseID;
        
        try {
        	caseID = dao.retrieveCaseIDByArrangementID(arrangementID);
        }
        catch(Exception e) {
        	e.printStackTrace();
        	
        	// Got a problem. Fallback to no substitution.
			return productSpecificationID;
        }

        return substituteBusinessCaseProductIDBasedOnBusinessRules(productSpecificationID, caseID, ruleHandler);
    }

    private String substituteBusinessCaseProductIDBasedOnBusinessRules(String productSpecificationID, String caseID, BaseProductSpecificationRuleHandler ruleHandler) {
        // Get the case details via DAO.
        BusinessCaseManagementDAO caseDAO = new BusinessCaseManagementDAO();
        
        BusinessCaseHeader businessCase = caseDAO.retrieveBusinessCase(caseID);

        if(businessCase == null) {
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
