// IBM Confidential OCO Source Material
// 5725-F81 (C) COPYRIGHT International Business Machines Corp. 2011,2013
// The source code for this program is not published or otherwise divested
// of its trade secrets, irrespective of what has been deposited with the
// U.S. Copyright Office.

package za.co.nb.productcatalogue.services.rest.resources;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import za.co.nb.productcatalogue.dao.ProductSpecificationsDAO;


@Path( "/productSpecifications" )
@Stateless
public class ProductSpecifications {

//    @EJB
//    IEntitlementsApproval entitlementsApprovalService;

    /**
     * The name of this class
     */
    public static final String className = ProductSpecifications.class.getName();

    private ProductSpecificationsDAO mProductSpecificationsDAO;
    
    private ProductSpecificationsDAO getProductSpecificationsDAO() {
    	if(mProductSpecificationsDAO == null) {
    		mProductSpecificationsDAO = new ProductSpecificationsDAO();
    	}
    	
    	return mProductSpecificationsDAO;
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
    public Response getProductSpecificationByID( @PathParam( "id" ) String id ) {
    	
    	try {
	        String vProductSpecificationJSON = getProductSpecificationsDAO().getProductSpecificationJSONByID(id);

	        if(vProductSpecificationJSON != null) {
		        return Response.ok(vProductSpecificationJSON).build();
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

}
