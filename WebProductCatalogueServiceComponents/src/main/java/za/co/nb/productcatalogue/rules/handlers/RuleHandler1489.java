package za.co.nb.productcatalogue.rules.handlers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import za.co.nb.onboarding.casemanagement.BusinessCaseManagementDAO;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseHeader;
import za.co.nb.productcatalogue.exceptions.BusinessRuleExecutionException;
import za.co.nb.services.clients.arrangementinformationservice.ArrangementPartyInformationServiceClient;
import za.co.nednet.it.contracts.data.ent.party.v3.ArrangementDetailBObjType;
import za.co.nednet.it.contracts.data.ent.party.v3.TCRMContractComponentBObjType;

import java.util.List;

public class RuleHandler1489 extends BaseProductSpecificationRuleHandler {

    private final Log mLog = LogFactory.getLog(getClass());
    private static final  ArrangementPartyInformationServiceClient partyInformationServiceClient = new ArrangementPartyInformationServiceClient();

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

            for (String arrangementID : arrangementIDs) {
                String[] arrangementBusinessContexts = new String[]{"Basic Details"};
                ArrangementDetailBObjType arrangementDetailBObjType = partyInformationServiceClient.retrieveArrangement(arrangementID, arrangementBusinessContexts);

                mLog.debug("Trace 4");

                if (arrangementDetailBObjType != null) {

                    String xValueXML = getArrangementBaseContractComponentXValueXML(arrangementDetailBObjType);
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

    public String getArrangementBaseContractComponentXValueXML(ArrangementDetailBObjType pArrangement) throws Exception {
        mLog.debug("Trace 1");

        TCRMContractComponentBObjType baseContractComponent = getBaseContractComponent(pArrangement);

        return getComponentXValueXML(baseContractComponent);
    }

    public TCRMContractComponentBObjType getBaseContractComponent(ArrangementDetailBObjType pArrangementDetailBObjType) {
        mLog.debug("Trace 1");

        for(TCRMContractComponentBObjType contractComponent : pArrangementDetailBObjType.getTCRMContractBObj().getTCRMContractComponentBObj()) {
            mLog.debug("Trace 2");

            if(contractComponent.getBaseIndicator().equalsIgnoreCase("Y")) {
                return contractComponent;
            }
        }

        mLog.debug("Trace 3");

        // Problem
        return null;
    }

    public String getComponentXValueXML(TCRMContractComponentBObjType component) {
        mLog.debug("Trace 1");

        return component.getTCRMExtension().getXCONTRACTCOMPONENTBObjExt().get(0).getXValueXML();
    }

}
