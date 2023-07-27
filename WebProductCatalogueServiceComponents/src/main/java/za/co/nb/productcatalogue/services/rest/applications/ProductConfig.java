package za.co.nb.productcatalogue.services.rest.applications;

import za.co.nb.productcatalogue.services.rest.resources.ProductCatalogueResource;
import za.co.nb.productcatalogue.services.rest.resources.ProductRecommendationResource;
import za.co.nb.productcatalogue.services.rest.resources.ProductSpecificationsResource;
import za.co.nb.ws.soap.handler.EntitlementsLoader;
import za.co.nedbank.entitlement.transport.EntitlementsAuthenticationPathFilter;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
public class ProductConfig extends Application {
	@Override
	public Set<Object> getSingletons()
	{
		Set<Object> singletons = new HashSet<>();
		singletons.add(new EntitlementsAuthenticationPathFilter());
		// register others, if any
		return singletons;
	}
	  @Override
	  	   public Set<Class<?>> getClasses() {
	        Set<Class<?>> classes = new HashSet<Class<?>>();
	        classes.add(ProductCatalogueResource.class);
	        classes.add(ProductSpecificationsResource.class);
		  	classes.add(ProductRecommendationResource.class);
		  	classes.add(JacksonJaxbJsonProvider.class);
	        return classes;
	    }
}
