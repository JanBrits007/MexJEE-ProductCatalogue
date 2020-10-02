package za.co.nb.productcatalogue.rules.handlers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.arrangementmanagement.analysis.rrb.PersonDataCaptured;
import za.co.nb.onboarding.casemanagement.BusinessCaseManagementDAO;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseHeader;
import za.co.nb.productcatalogue.exceptions.BusinessRuleExecutionException;
import za.co.nednet.it.contracts.data.ent.party.v3.ArrangementDetailBObjType;
import za.co.nednet.it.contracts.data.ent.party.v3.Client360ViewResBObjType;
import za.co.nednet.it.contracts.data.ent.party.v3.PersonDetailBObjType;

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
            PersonDataCaptured personDataCaptured = new PersonDataCaptured();
            isRRBClient = personDataCaptured.isRRBClient(businessCase.getClientInContextECN());
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
