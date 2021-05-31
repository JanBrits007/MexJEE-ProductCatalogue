package za.co.nb.juristic.productcatalogue.remoteejb;

import javax.ejb.Remote;
import java.io.InputStream;

@Remote
public interface IJuristicProductSpecifications {

	String getProductSpecificationsXML(String pProductSpecificationID);

	String getProductSpecificationsJSON(String pProductSpecificationID);

}
