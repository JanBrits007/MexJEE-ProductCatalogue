package za.co.nb.productcatalogue.ejb;

import javax.ejb.Remote;
import java.io.InputStream;

@Remote
public interface JuristicProductSpecificationsRemote {

	String getProductSpecificationXMLByID(String pProductSpecificationID);

	String getProductSpecificationJSONByID(String pProductSpecificationID);

}
