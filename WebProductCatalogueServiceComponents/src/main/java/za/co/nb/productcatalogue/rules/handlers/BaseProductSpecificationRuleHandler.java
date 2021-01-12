package za.co.nb.productcatalogue.rules.handlers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseHeader;
import za.co.nb.onboarding.product.services.businessexceptions.ServiceIntegrationException;
import za.co.nb.productcatalogue.exceptions.BusinessRuleExecutionException;
import za.co.nb.services.clients.client360.Client360InformationServiceClient;
import za.co.nednet.it.contracts.data.ent.party.v3.ArrangementDetailBObjType;
import za.co.nednet.it.contracts.data.ent.party.v3.Client360ViewResBObjType;
import za.co.nednet.it.contracts.data.ent.party.v3.PersonDetailBObjType;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public abstract class BaseProductSpecificationRuleHandler {

	private static final String MAIN_APPLICANT_ROLE_TYPE = "1041";
	private final Log mLog = LogFactory.getLog(getClass());
	
	protected Client360ViewResBObjType retrieveBasicNCMClient360ByArrangementIDs(List<String> arrangementIDs) throws ServiceIntegrationException {
		mLog.debug("Trace 1");
		
		// Retrieve the 360 of this case.
		Client360InformationServiceClient client360Client = new Client360InformationServiceClient();
		Client360ViewResBObjType client360DTO;
		
		try {
			client360DTO =  client360Client.retrieveBasicNCMClient360ByArrangementIDs(arrangementIDs);
		}
		catch(Exception e) {
			e.printStackTrace();
			
			throw new ServiceIntegrationException("Unable to retrieve client 360 for arrangement IDs " + arrangementIDs);
		}

		return client360DTO;
	}	

	protected String getArrangementID(ArrangementDetailBObjType arrangement) throws Exception {
		mLog.debug("Trace 1");

		for (int i = 0; i < arrangement.getTCRMContractBObj().getTCRMAdminNativeKeyBObj().size(); i++) {
			mLog.debug("Trace 2");

			if(arrangement.getTCRMContractBObj().getTCRMAdminNativeKeyBObj().get(i).getAdminFieldNameType().equalsIgnoreCase("1455")) {
				mLog.debug("Trace 3");

				// This is the correct ID.
				return arrangement.getTCRMContractBObj().getTCRMAdminNativeKeyBObj().get(i).getAdminContractId();
			}
		}

		throw new Exception("Unable to determine arrangement ID with AdminFieldNameType value equal to 1455");
	}
	
	private String getMainApplicantPartyID(ArrangementDetailBObjType arrangement) throws Exception {
		mLog.info("Trace 1");

		for (int i = 0; i < arrangement.getTCRMContractBObj().getTCRMContractComponentBObj().size(); i++) {
			mLog.info("Trace 2");

			if (arrangement.getTCRMContractBObj().getTCRMContractComponentBObj().get(i).getBaseIndicator().equalsIgnoreCase("Y")) {
				mLog.info("Trace 3");

				for (int j = 0; j < arrangement.getTCRMContractBObj().getTCRMContractComponentBObj().get(i).getTCRMContractPartyRoleBObj().size(); j++) {
					mLog.info("Trace 4");

					if (arrangement.getTCRMContractBObj().getTCRMContractComponentBObj().get(i).getTCRMContractPartyRoleBObj().get(j).getRoleType().equalsIgnoreCase(MAIN_APPLICANT_ROLE_TYPE)) {
						mLog.info("Trace 5");

						if (arrangement.getTCRMContractBObj().getTCRMContractComponentBObj().get(i).getTCRMContractPartyRoleBObj().get(j).getTCRMPersonBObj() != null) {
							// It's a person
							return arrangement.getTCRMContractBObj().getTCRMContractComponentBObj().get(i).getTCRMContractPartyRoleBObj().get(j).getTCRMPersonBObj().getPartyId();
						} else if (arrangement.getTCRMContractBObj().getTCRMContractComponentBObj().get(i).getTCRMContractPartyRoleBObj().get(j).getTCRMOrganizationBObj() != null) {
							// It's an organisation
							return arrangement.getTCRMContractBObj().getTCRMContractComponentBObj().get(i).getTCRMContractPartyRoleBObj().get(j).getTCRMOrganizationBObj().getPartyId();
						} else {
							// It's a party
							return arrangement.getTCRMContractBObj().getTCRMContractComponentBObj().get(i).getTCRMContractPartyRoleBObj().get(j).getTCRMPartyBObj().getPartyId();
						}
					}
				}
			}
		}

		mLog.info("Trace 8");

		// Shouldn't get here.
		throw new Exception("Unable to determine main applicant Party Number");
	}
	
	protected PersonDetailBObjType getMainApplicantPersonDetailBObj(ArrangementDetailBObjType arrangement, List<PersonDetailBObjType> relatedPersons) throws Exception {
		mLog.info("Trace 1");

		String vMainApplicantPartyID = getMainApplicantPartyID(arrangement);

		mLog.info("Trace 1.1 >>" + vMainApplicantPartyID + "<<");

		// Look for the PersonDetailBOb for the main applicant
		if (relatedPersons != null && relatedPersons.size() > 0) {
			for (int i = 0; i < relatedPersons.size(); i++) {
				mLog.info("Trace 2 >>" + relatedPersons.get(i).getTCRMPersonBObj().getPartyId() + "<<,>>" + vMainApplicantPartyID + "<<");

				mLog.info("Trace 2.1 >>" + (relatedPersons.get(i).getTCRMPersonBObj().getPartyId() == vMainApplicantPartyID) + "<<");

				if (relatedPersons.get(i).getTCRMPersonBObj().getPartyId().toString().equalsIgnoreCase(vMainApplicantPartyID.toString())) {
					mLog.info("Trace 5");
					// Found the correct person.
					return relatedPersons.get(i);
				}
			}

			mLog.info("Trace 6");

			// Shouldn't get here. Just return the first one.
			if (relatedPersons != null && relatedPersons.size() > 0) {
				return relatedPersons.get(0);
			}
		}

		mLog.info("Trace 7 >>Unable to determine main applicant PersonDetailBObj<<");

		return null;
	}

	protected boolean checkIfTagPresent(String xml, String tagName) throws IOException, SAXException, ParserConfigurationException {
		Document doc = convertXmlStringToDocument(xml);

		NodeList nodeList = doc.getElementsByTagName(tagName);
		mLog.debug(tagName + " TagCount ::" + nodeList.getLength() + " and TagIsPresent ::" + (nodeList.getLength() > 0));
		return nodeList.getLength() > 0;
	}

	protected String fetchValueByTagName(Document document, String tagName) {
		mLog.debug(document.getElementsByTagName(tagName).item(0).getTextContent());
		return document.getElementsByTagName(tagName).item(0).getTextContent();
	}

	protected Document convertXmlStringToDocument(String xml) throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
		return doc;
	}
	
	public abstract String executeBusinessRules(String productIDToSubstitute, String caseID) throws BusinessRuleExecutionException;

}
