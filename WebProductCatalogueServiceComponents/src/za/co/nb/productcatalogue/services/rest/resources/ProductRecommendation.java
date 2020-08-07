package za.co.nb.productcatalogue.services.rest.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.dto.ResultSet;
import za.co.nb.productcatalogue.services.rest.model.AnsweredQuestionList;
import za.co.nb.productcatalogue.services.rest.model.ProductRecommendationResponse;
import za.co.nb.productcatalogue.services.rest.service.ProductRecommendationService;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.PrintWriter;
import java.io.StringWriter;


@Path("/productandservicedevelopment/productrecommendations/v1")
@Stateless
public class ProductRecommendation {
    private final Log mLog = LogFactory.getLog(getClass());
    @Context
    javax.ws.rs.core.Application app;

    /**
     *
     * @param answeredQuestionList List of answered questions from request
     * @return JSON Response
     */
    @POST
    @Path("/productrecommendations")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductRecommendationResponse postProducts(AnsweredQuestionList answeredQuestionList) {
        mLog.debug("Trace 1: requested products");

        ResultSet resultSet = new ResultSet();
        resultSet.setResultCode("R00");
        resultSet.setResultDescription("SUCCESS");

        ProductRecommendationResponse productRecommendationResponse = new ProductRecommendationResponse();
        ProductRecommendationService productRecommendationService = new ProductRecommendationService();

        if (answeredQuestionList.getAnsweredQuestion() != null && !answeredQuestionList.getAnsweredQuestion().isEmpty()) {
            try {
                String productFile = "SalesBankCATRecommendations";
                String questionFile = "SalesBankCATQuestions";

                mLog.debug("Trace 2: Get product recommendations >> Product Set"+
                        productFile + " >> Question Set >> " + questionFile);

                productRecommendationResponse = productRecommendationService.getRecommendations(productFile, questionFile, answeredQuestionList);

                if(productRecommendationResponse.getRecommendedProducts().isEmpty() &&
                productRecommendationResponse.getQuestions().isEmpty()){
                    resultSet.setResultCode("R01");
                    resultSet.setResultDescription("NO MATCH FOUND");
                }

                productRecommendationResponse.setResultSet(resultSet);

            } catch (Exception e) {
                mLog.debug("Trace 16");
                e.printStackTrace();

                resultSet.setResultCode("R01");

                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                resultSet.setResultDescription(sw.toString());
            }
        }
        else{
            resultSet.setResultCode("R01");
            resultSet.setResultDescription("INVALID REQUEST");
            productRecommendationResponse.setResultSet(resultSet);
        }

        return productRecommendationResponse;
    }


}
