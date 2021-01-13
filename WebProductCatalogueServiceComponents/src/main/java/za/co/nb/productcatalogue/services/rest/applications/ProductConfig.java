package za.co.nb.productcatalogue.services.rest.applications;

import za.co.nb.productcatalogue.services.rest.resources.ProductCatalogueResource;
import za.co.nb.productcatalogue.services.rest.resources.ProductRecommendationResource;
import za.co.nb.productcatalogue.services.rest.resources.ProductSpecificationsResource;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
public class ProductConfig extends Application {
	  @Override
	  	   public Set<Class<?>> getClasses() {
	        Set<Class<?>> classes = new HashSet<Class<?>>();
	        classes.add(ProductCatalogueResource.class);
	        classes.add(ProductSpecificationsResource.class);
		  	classes.add(ProductRecommendationResource.class);
	        return classes;
	    }
}
