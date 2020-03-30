// IBM Confidential OCO Source Material
// 5725-F81 (C) COPYRIGHT International Business Machines Corp. 2011,2013
// The source code for this program is not published or otherwise divested
// of its trade secrets, irrespective of what has been deposited with the
// U.S. Copyright Office.

package za.co.nb.productcatalogue.services.rest.resources;

import java.util.HashMap;
import java.util.Map;

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

import com.github.underscore.lodash.L;

import za.co.nb.productcatalogue.dao.ProductCataloguesDAO;
import za.co.nb.productcatalogue.dto.ProductIdentifiers;
import za.co.nedbank.cr1.common.helper.mLog;
import za.co.nedbank.cr1.common.helper.Strings;

@Path( "/producthierarchy" )
@Stateless
public class ProductCatalogue {

    /**
     * The name of this class
     */
    public static final String className = ProductCatalogue.class.getName();

    private ProductCataloguesDAO mProductCataloguesDAO;
    
    private ProductCataloguesDAO getProductCataloguesDAO() {
    	if(mProductCataloguesDAO == null) {
    		mProductCataloguesDAO = new ProductCataloguesDAO();
    	}
    	
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
    	
    	try {
	        String vProductCatalogueJSON = getProductCataloguesDAO().getProductCatalogueJSONByID(id);

	        if(vProductCatalogueJSON != null) {
		        return Response.ok(vProductCatalogueJSON).build();
	        }
	        else {
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
    	Map<String,Object> result = new HashMap<String,Object>();
		for(String id: identifiers.getIdentifiers()){
			mLog.infoln("Retrieving producid",id);
			
			String json = getProductCataloguesDAO().findProductDetailsJSONByID(id.toString());
			if(!Strings.isEmpty(json)) {
				result.put(id, L.fromJson(json));
			}
		}
        
    	return Response.ok(L.toJson(result)).build();
    }
}
