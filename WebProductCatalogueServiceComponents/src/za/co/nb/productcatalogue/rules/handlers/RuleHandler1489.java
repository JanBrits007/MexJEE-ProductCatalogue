package za.co.nb.productcatalogue.rules.handlers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import za.co.nb.onboarding.casemanagement.BusinessCaseManagementDAO;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseHeader;
import za.co.nb.productcatalogue.exceptions.BusinessRuleExecutionException;
import za.co.nb.services.clients.arrangementinformationservice.ArrangementPartyInformationServiceClient;
import za.co.nednet.it.arrangement.helper.ArrangementUtil;
import za.co.nednet.it.contracts.data.ent.party.v3.ArrangementDetailBObjType;

import java.util.List;

public class RuleHandler1489 extends BaseProductSpecificationRuleHandler {

    private final Log mLog = LogFactory.getLog(getClass());

    @Override
    public String executeBusinessRules(String productIDToSubstitute, String caseID) throws BusinessRuleExecutionException {
        mLog.debug("Trace 1 >>" + productIDToSubstitute + "<<,>>" + caseID + "<<");

        try {
            // with caseID retrieve businesscaseheader
            BusinessCaseManagementDAO dao = new BusinessCaseManagementDAO();
            BusinessCaseHeader businessCaseHeader = dao.retrieveBusinessCase(caseID);
            mLog.debug("Trace 2");

            List<String> arrangementIDs = businessCaseHeader.getArrangementIDs();
            mLog.debug("Trace 3 >>"+arrangementIDs+"<<");
            ArrangementPartyInformationServiceClient partyInformationServiceClient = new ArrangementPartyInformationServiceClient();
            for (String arrangementID : arrangementIDs) {
                String[] arrangementBusinessContexts = new String[]{"Basic Details"};
                ArrangementDetailBObjType arrangementDetailBObjType = partyInformationServiceClient.retrieveArrangement(arrangementID, arrangementBusinessContexts);

                mLog.debug("Trace 4");

                if (arrangementDetailBObjType != null) {
                    ArrangementUtil arrangementUtil = new ArrangementUtil();
                    String xValueXML = arrangementUtil.getArrangementBaseContractComponentXValueXML(arrangementDetailBObjType);
                    mLog.debug("Trace 5 XValueXML value >>" + xValueXML + "<<");

                    Document doc = convertXmlStringToDocument(xValueXML);
                    if (checkIfTagPresent(xValueXML, "facilityInstruction")) {
                        String value = fetchValueByTagName(doc, "facilityInstruction");
                        mLog.debug("Trace 6 facilityInstruction value>>" + value + "<<");

                        if (value.equalsIgnoreCase("LimitIncrease")) {
                            mLog.debug("Trace 7 Found LimitIncrease then send 5489");
                            return "5489";
                        }
                    }
                }

            }
        } catch(Exception e) {
            // Got a problem.
            mLog.debug("Trace 8 >>"+productIDToSubstitute+"<<");
            e.printStackTrace();
            return productIDToSubstitute;
        }

        mLog.debug("Trace 9 >>"+productIDToSubstitute+"<<");
        return productIDToSubstitute;
    }

}
