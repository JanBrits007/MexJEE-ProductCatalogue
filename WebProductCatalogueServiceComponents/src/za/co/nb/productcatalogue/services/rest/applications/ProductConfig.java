package za.co.nb.productcatalogue.services.rest.applications;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
public class ProductConfig extends Application {
	  @Override
	  	   public Set<Class<?>> getClasses() {
	        Set<Class<?>> classes = new HashSet<Class<?>>();
	        classes.add(za.co.nb.productcatalogue.services.rest.resources.ProductCatalogue.class);
	        classes.add(za.co.nb.productcatalogue.services.rest.resources.ProductSpecifications.class);
	        return classes;
	    }
}
