package za.co.nb.productcatlogue.JSONValidator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
//import com.github.fge.jsonschema.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.MaintainCatalogueRequestType;

public class JSONValidation {

	MaintainCatalogueRequestType maintainCatalogueRequest = new MaintainCatalogueRequestType();
	private final Log mLog = LogFactory.getLog(getClass());

	public boolean jsonValidateMethod(
			MaintainCatalogueRequestType maintainCatalogueRequest)
			throws JsonParseException {
		String jsonData = maintainCatalogueRequest.getJsonData();

		boolean isValid = false;
		try {
			isValid = validateJSONSchema(jsonData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;

	}

	public boolean validateJSONSchema(String jonString) throws Exception {

		ProcessingReport report = null;
		boolean isvalid = false;
		try {

			String jsonSchema = "/META-INF/json-schema/JSON-Schema.json";
			InputStream jsonobj = JSONObject.class.getResourceAsStream(jsonSchema);
			
			
			
		    String jsonString = readString(jsonobj);
		    JsonNode jsonNode = JsonLoader.fromString(jsonString);
		  //  JsonNode node=map.readTree(jsonString);
		   // JsonNode schemaNode = JsonLoader.fromString(jsonobj.toString());
		   // JSONObject rawSchema = new JSONObject(new JSONTokener(jsonString));
		   // Schema schema = SchemaLoader.load(rawSchema);
		  //  schema.validate(jonString);

			JsonNode data = JsonLoader.fromString(jonString);
			JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
			
		JsonSchema schema = factory.getJsonSchema(jsonNode);
			
			schema.validate(data);
			report = schema.validate(data);
			isvalid = true;
			

		} catch (IOException e) {
			mLog.debug("IO Exception: " + e.getMessage());
			e.printStackTrace();

		}
		return isvalid;
	}
	public static String readString(InputStream inputStream) throws IOException {

	    ByteArrayOutputStream into = new ByteArrayOutputStream();
	    byte[] buf = new byte[4096];
	    for (int n; 0 < (n = inputStream.read(buf));) {
	        into.write(buf, 0, n);
	    }
	    into.close();
	    return new String(into.toByteArray(), "UTF-8");// Or whatever encoding
	}

}
