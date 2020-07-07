package za.co.nb.productcatalogue.services.rest.resources;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.productcatalogue.dao.ProductCataloguesDAO;
import za.co.nb.productcatalogue.dto.ProductIdentifiers;

@Path( "/producthierarchy" )
@Stateless
public class ProductCatalogue {

	private final Log mLog = LogFactory.getLog(getClass());
    private ProductCataloguesDAO mProductCataloguesDAO;
    
    private ProductCataloguesDAO getProductCataloguesDAO() {
    	mLog.debug("Trace 1");

    	if(mProductCataloguesDAO == null) {
        	mLog.debug("Trace 2");
    		mProductCataloguesDAO = new ProductCataloguesDAO();
    	}
    	
    	mLog.debug("Trace 3");
    	
    	return mProductCataloguesDAO;
    }
    
    @Context
    javax.ws.rs.core.Application app;
    
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
	        String vProductCatalogueJSON = getProductCataloguesDAO().getProductCatalogueJSONByID(id);

	        if(vProductCatalogueJSON != null) {
	        	mLog.debug("Trace 2");
		        return Response.ok(vProductCatalogueJSON).build();
	        }
	        else {
	        	mLog.debug("Trace 3");
	        	return Response.ok(Status.NOT_FOUND).build();
	        }
    	}
    	catch(Exception e) {
    		e.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    	}
    }
    
    @POST
    @Path( "/selection" )
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( "application/json" )
    public Response getProductCatalogueBySelection( ProductIdentifiers identifiers ) throws Exception {
    	throw new Exception("This API has been deprecated");

/*    	
    	mLog.debug("Trace 1");
    	
    	Map<String,Object> result = new HashMap<String,Object>();

    	for(String id: identifiers.getIdentifiers()){
			mLog.debug("Retrieving productID >>" + id + "<<");
			
			String json = getProductCataloguesDAO().findProductDetailsJSONByID(id.toString());
			if(!Strings.isEmpty(json)) {
		    	mLog.debug("Trace 2");
		    	
				result.put(id, L.fromJson(json));
			}
		}
        
    	return Response.ok(L.toJson(result)).build();
*/    	
    }
}
