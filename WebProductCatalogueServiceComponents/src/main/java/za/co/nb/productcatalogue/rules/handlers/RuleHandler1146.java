package za.co.nb.productcatalogue.rules.handlers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.onboarding.casemanagement.BusinessCaseManagementDAO;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseHeader;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseSegment;
import za.co.nb.productcatalogue.exceptions.BusinessRuleExecutionException;

public class RuleHandler1146 extends BaseProductSpecificationRuleHandler {

    private static final Log mLog = LogFactory.getLog(BaseProductSpecificationRuleHandler.class);

    @Override
    public String executeBusinessRules(String productIDToSubstitute, String caseID) throws BusinessRuleExecutionException {
        mLog.debug("Trace 1 >>" + productIDToSubstitute + "<<,>>" + caseID + "<<");

        // First get the list of arracgements allocated to the case.
        BusinessCaseManagementDAO dao = new BusinessCaseManagementDAO();

        BusinessCaseHeader businessCase = dao.retrieveBusinessCase(caseID);

        if(businessCase != null && businessCase.getClientInContextECN() != null && businessCase.getInitiatingChannelID() != null
                && "397".equalsIgnoreCase(businessCase.getInitiatingChannelID())) {
            mLog.debug("Trace 2");
            BusinessCaseSegment businessCaseSegment = businessCase.getBusinessCaseSegment();
            if(businessCaseSegment != null && businessCaseSegment.getCluster() != null && businessCaseSegment.getDivision() != null){
                if(businessCaseSegment.getCluster().equalsIgnoreCase("200") &&
                    businessCaseSegment.getDivision().equalsIgnoreCase("201")){
                    mLog.debug("Trace 3.0>>");
                    businessCase.setCodHandlerRRB("true");
                    mLog.debug("Trace 3.1>> Setting CodHandlerRRB");
                    dao.cacheBusinessCaseDetailInDB(businessCase);
                }
            }
        }
        mLog.debug("Trace 4");
        return productIDToSubstitute;
    }
}
