package za.co.nb.productcatalogue.services.rest.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.productcatalogue.dao.ProductCataloguesDAO;
import za.co.nb.productcatalogue.services.rest.model.AnsweredQuestionList;
import za.co.nb.productcatalogue.services.rest.model.ProductRecommendationResponse;
import za.co.nb.productcatalogue.services.rest.model.RecommendedProductList;
import za.co.nb.productcatalogue.services.rest.service.ProductRecommendationService;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/productandservicedevelopment/productrecommendations/v1")
@Stateless
public class ProductRecommendation {
    private final Log mLog = LogFactory.getLog(getClass());
    @Context
    javax.ws.rs.core.Application app;

    /**
     *
     * @param answeredQuestionList
     * @return JSON Response
     */
    @POST
    @Path("/productrecommendations")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postProducts(AnsweredQuestionList answeredQuestionList) {

        if (answeredQuestionList != null && !answeredQuestionList.getAnsweredQuestion().isEmpty()) {
            try {
                mLog.debug("Trace 1: request >> " + answeredQuestionList.getAnsweredQuestion().size());
                System.out.println("Main method working");

                ProductRecommendationService productRecommendationService = new ProductRecommendationService();

                String productFile = "7777";
                String questionFile = "7778";
                ProductRecommendationResponse productRecommendationResponse = productRecommendationService.getRecommendations(productFile, questionFile, answeredQuestionList);
                System.out.println("Created recommendations");
                return Response.ok(productRecommendationResponse.toString()).build();

            } catch (Exception e) {
                e.printStackTrace();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }


}
