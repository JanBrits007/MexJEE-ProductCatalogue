package za.co.nb.productcatlogue.XMLValidator;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import za.co.nedbank.cr1.common.helper.mLog;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.MaintainCatalogueRequestType;

public class XMLValidation {

	MaintainCatalogueRequestType maintainCatalogueRequest = new MaintainCatalogueRequestType();

	public boolean validateMethod(
			MaintainCatalogueRequestType maintainCatalogueRequest)
			throws SAXException, IOException {

		String xmlData = maintainCatalogueRequest.getXmlData();

		boolean isValid = validateXMLSchema(xmlData);
		mLog.debug("xml is validated " + isValid);

		return isValid;

	}

	public boolean validateXMLSchema(String xmlString) {

		try {
			String schemaDir = "/WEB-INF/xsd/MySchema.xsd";
			SchemaFactory factory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory
					.newSchema(getClass().getResource(schemaDir));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new StringReader(xmlString)));

		} catch (IOException e) {
			mLog.debug("IO Exception: " + e.getMessage());
			return false;
		} catch (SAXException sax) {
			mLog.debug("Sax Exception: " + sax.getMessage());
			return false;
		}
		return true;
	}
}
