package za.co.nb.productcatalogue.rules.handlers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;

import za.co.nb.common.htpp.client.HttpClientUtil;
import za.co.nb.onboarding.casemanagement.BusinessCaseManagementDAO;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseHeader;
import za.co.nb.productcatalogue.exceptions.BusinessRuleExecutionException;
import za.co.nb.system.config.dao.SystemConfiguratorDAO;
import za.co.nb.system.config.environment.Environment;

public class RuleHandler1176ETE extends BaseProductSpecificationRuleHandler {

    private final Log mLog = LogFactory.getLog(getClass());

    @Override
    public String executeBusinessRules(String productIDToSubstitute, String caseID) throws BusinessRuleExecutionException {
        mLog.debug("Trace 1 >>" + productIDToSubstitute + "<<,>>" + caseID + "<<");

        // First get the list of arracgements allocated to the case.
        BusinessCaseManagementDAO dao = new BusinessCaseManagementDAO();

        BusinessCaseHeader businessCase = dao.retrieveBusinessCase(caseID);

        boolean isRRBClient = false;
        if(businessCase != null && businessCase.getClientInContextECN() != null){

            mLog.debug("Trace 2");
            SystemConfiguratorDAO systemConfiguratorDAO = new SystemConfiguratorDAO();
            try {

                mLog.debug("Trace 2.1");
                Environment environment = systemConfiguratorDAO.getEnvironment();
                String serviceUrl = environment.PARTY_MANAGEMENT_CLIENT_CHECK_URL.toString();
                //String serviceUrl ="https://zeb1swn1.it.nednet.co.za:9443/WebPartyManagement/branchmanagement/v1";
                StringBuilder builder = new StringBuilder();
                builder.append(serviceUrl);
                builder.append("/rrbclient/");
                builder.append(businessCase.getClientInContextECN());
                serviceUrl = builder.toString();

                mLog.debug("Trace 2.2 Service URL : "+serviceUrl);
                HttpClientUtil httpUtils = new HttpClientUtil();
                JSONObject response=httpUtils.sendGET(serviceUrl,null);

                if(response != null && response.get("resultSet") != null ){
                    String resultCode = (String)((JSONObject)response.get("resultSet")).get("resultCode");

                    mLog.debug("Trace 2.3");
                    if(resultCode.equalsIgnoreCase("R00")){
                        mLog.debug("Trace 2.4 : Is RRB Client :"+(boolean)response.get("rrbclient"));
                        isRRBClient = (boolean)response.get("rrbclient");
                    }
                }
            } catch (Exception e) {
                mLog.debug("Trace 2.4");
                e.printStackTrace();
            }

            if(isRRBClient){

                mLog.debug("Trace 3");
                return "2176";
            }
            else {
                mLog.debug("Trace 4");
                return productIDToSubstitute;
            }
        }
        else {
            mLog.debug("Trace 5");
            return productIDToSubstitute;
        }
    }

}
