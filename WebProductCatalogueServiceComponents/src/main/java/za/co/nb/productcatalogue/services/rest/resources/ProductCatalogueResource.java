package za.co.nb.productcatalogue.services.rest.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.productcatalogue.dao.ProductCataloguesDAO;
import za.co.nb.productcatalogue.dao.dto.CachedCatalogueDetails;
import za.co.nb.productcatalogue.dto.ProductIdentifiers;
import za.co.nb.productcatalogue.services.rest.resources.cache.ProductCatalogueCache;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Calendar;
import java.util.Date;

@Path( "/producthierarchy" )
@Stateless
public class ProductCatalogueResource {

	private final Log mLog = LogFactory.getLog(getClass());

	@Inject
    ProductCatalogueCache productCatalogueCache;

    private ProductCataloguesDAO productCataloguesDAO;


    @PostConstruct
    public void init(){
        productCataloguesDAO = new ProductCataloguesDAO();
    }
    
    @OPTIONS
    @PermitAll
    public Response optionsById() {
        return Response.status(Response.Status.NO_CONTENT).build();
    }
        
    @GET
    @Path( "/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response getProductCatalogueByID( @PathParam( "id" ) String id ) {
    	mLog.debug("Trace 1");
    	
    	try {

            CachedCatalogueDetails cachedCatalogue = productCatalogueCache.getCatalogueCache().get(id);

            if(cachedCatalogue == null || isGreaterThan24Hours(cachedCatalogue.getCacheDateTime())) {
                mLog.debug("Trace 2");

                if (id.equalsIgnoreCase("all")) {
                    mLog.debug("Trace 3");
                    String vProductCatalogueJSON  = productCataloguesDAO.getProductCatalogAllJson(id);
                    return Response.ok(vProductCatalogueJSON).build();
                } else {
                    mLog.debug("Trace 4");
                    String catalogueString = productCataloguesDAO.retrieveRatesInjectedProductCatalog(id);

                    if(catalogueString != null) {
                        productCatalogueCache.putToCache(id, catalogueString);
                        mLog.debug("added to cache:"+id);
                        return Response.ok(catalogueString).build();
                    } else {
                        mLog.debug("Trace 6");
                        return Response.ok(Status.NOT_FOUND).build();
                    }
                }
            } else {
                mLog.debug("retrieved from cache, product:"+id);
                return Response.ok(cachedCatalogue.getCatalogueContent()).build();
            }

    	}
    	catch(Exception e) {
    		e.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    	}
    }


    private boolean isGreaterThan24Hours(Date cacheDate){
        Calendar twentyFourHoursEarlier = Calendar.getInstance();
        twentyFourHoursEarlier.add(Calendar.HOUR, -24);

        return cacheDate.before(twentyFourHoursEarlier.getTime());
    }

    @GET
    @Path( "/invalidate" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response invalidateCache( ) {
        mLog.debug("Trace 1");

        try {
            productCatalogueCache.invalidate();
            return Response.ok(Status.OK).build();

        } catch(Exception e) {
           mLog.error("could not invalidate cache", e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path( "/reload" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response reloadCache( ) {
        mLog.debug("Trace 1");

        try {
            productCatalogueCache.reload();
            return Response.ok(Status.OK).build();

        } catch(Exception e) {
            mLog.error("could not reload cache", e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @POST
    @Path( "/selection" )
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( "application/json" )
    public Response getProductCatalogueBySelection( ProductIdentifiers identifiers ) throws Exception {
    	throw new Exception("This API has been deprecated");

    }
}
