package za.co.nb.productcatalogue.rules.handlers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.onboarding.casemanagement.BusinessCaseManagementDAO;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseHeader;
import za.co.nb.productcatalogue.exceptions.BusinessRuleExecutionException;
import za.co.nednet.it.contracts.data.ent.party.v3.ArrangementDetailBObjType;
import za.co.nednet.it.contracts.data.ent.party.v3.Client360ViewResBObjType;
import za.co.nednet.it.contracts.data.ent.party.v3.PersonDetailBObjType;

public class RuleHandler1013 extends BaseProductSpecificationRuleHandler {

	private final Log mLog = LogFactory.getLog(getClass());
	
	private boolean isMainApplicantAPerson(Client360ViewResBObjType client360) {
		mLog.debug("Trace 1");
		
		try {
			// Find the correct arrangement.
			for(ArrangementDetailBObjType arrangement: client360.getArrangementDetailBObj()) {
				mLog.debug("Trace 2");
	
				// We just check the first arrangement. They are all for the same client.
				PersonDetailBObjType personDetails = super.getMainApplicantPersonDetailBObj(arrangement, client360.getPersonDetailBObj());
				
				return personDetails != null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
			// Can't break JO. Default to their scenario.
			return false;
		}
		
		// Didn't find an the arrangement being applied for by a person.
		return false;
	}
	
	@Override
	public String executeBusinessRules(String productIDToSubstitute, String caseID) throws BusinessRuleExecutionException {
		mLog.debug("Trace 1 >>" + productIDToSubstitute + "<<,>>" + caseID + "<<");

		// First get the list of arracgements allocated to the case.
		BusinessCaseManagementDAO dao = new BusinessCaseManagementDAO();
		
		BusinessCaseHeader businessCase = dao.retrieveBusinessCase(caseID);
		
		try {
			Client360ViewResBObjType client360 = super.retrieveBasicNCMClient360ByArrangementIDs(businessCase.getArrangementIDs());

			if(isMainApplicantAPerson(client360)) {
				// This is a retail application.
				return "5013";
			}
			else {
				return productIDToSubstitute;
			}
		}
		catch(Exception e) {
			// Got a problem.
			e.printStackTrace();
			
			return productIDToSubstitute;
		}
	}

}
