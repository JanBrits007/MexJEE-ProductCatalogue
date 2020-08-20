package za.co.nb.productcatalogue.services.rest.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import za.co.nb.productcatalogue.dao.ProductCataloguesDAO;
import za.co.nb.productcatalogue.dao.dto.CachedCatalogueDetails;
import za.co.nb.productcatalogue.services.rest.model.AnsweredQuestion;
import za.co.nb.productcatalogue.services.rest.model.AnsweredQuestionList;
import za.co.nb.productcatalogue.services.rest.model.NextQuestionToAskList;
import za.co.nb.productcatalogue.services.rest.model.ProductRecommendationResponse;
import za.co.nb.productcatalogue.services.rest.model.ProductRecommendationSet;
import za.co.nb.productcatalogue.services.rest.model.ProductRecommendationSetListType;
import za.co.nb.productcatalogue.services.rest.model.Question;
import za.co.nb.productcatalogue.services.rest.model.QuestionList;
import za.co.nb.productcatalogue.services.rest.model.QuestionListType;
import za.co.nb.productcatalogue.services.rest.model.RecommendedProduct;
import za.co.nb.productcatalogue.services.rest.resources.cache.ProductCatalogueCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * service implementation
 */

@RequestScoped
public class ProductRecommendationService {

    private ProductRecommendationSetListType recommendationSetList;

    private ProductCataloguesDAO mProductCataloguesDAO;
    private final Log mLog = LogFactory.getLog(getClass());

    @Inject
    ProductCatalogueCache productCatalogueCache;

    //This sets up access to the function to retrieve JSON string from actual .JSON file
    private ProductCataloguesDAO getProductCataloguesDAO() {
        mLog.debug("Trace 1");

        if (mProductCataloguesDAO == null) {
            mLog.debug("Trace 2");
            mProductCataloguesDAO = new ProductCataloguesDAO();
        }

        mLog.debug("Trace 3");

        return mProductCataloguesDAO;
    }

    /**
     * @param pJsonFile File name containing product specifications
     * @return String
     */
    private String findProductsFile(String pJsonFile) {

        try {
            mLog.debug("Trace 1: Loading JSON spec file >>" + pJsonFile);
            CachedCatalogueDetails cachedCatalogue = productCatalogueCache.getCatalogueCache().get(pJsonFile);

            if (cachedCatalogue == null) {
                String productJSONData =  getProductCataloguesDAO().getProductCatalogueJSONByID(pJsonFile);
                productCatalogueCache.putToCache(pJsonFile, productJSONData);
                return productJSONData;
            }else{
                return cachedCatalogue.getCatalogueContent();
            }


        } catch (Exception e) {
            mLog.debug("Error: Could not load spec file");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param productSetFile      Spec file with product set and recommendations
     * @param questionSetFile     Spec file with questions list
     * @param answeredQuestionReq Request with list of answered questions
     * @return Recommendation response with next questions
     */
    public ProductRecommendationResponse getRecommendations(String productSetFile, String questionSetFile, AnsweredQuestionList answeredQuestionReq) {
        mLog.debug("Trace 1: Locate Product recommendation file");
        String recommendationFile = findProductsFile(productSetFile);
        ProductRecommendationResponse productRecommendationResponse = new ProductRecommendationResponse();
        if (recommendationFile != null) {
            ProductRecommendationSet productRecommendationSet;
            try {
                mLog.debug("Trace 2: Read recommendations set from file");
                recommendationSetList = new ObjectMapper().readValue(recommendationFile, ProductRecommendationSetListType.class);
                mLog.debug("Trace 3: Find product recommendation(s)");
                productRecommendationSet = findProduct(answeredQuestionReq);
                List<RecommendedProduct> recommendedProducts = productRecommendationSet.getRecommendedProductList().getRecommendedProduct();
                productRecommendationResponse.setRecommendedProducts(recommendedProducts);

                mLog.debug("Trace 4: Load questions");
                QuestionList questionList = getQuestion(questionSetFile, productRecommendationSet);
                productRecommendationResponse.setQuestions(questionList.getQuestion());


                return productRecommendationResponse;
            } catch (Exception e) {
                mLog.debug("Error: Could not get product recommendations");
                e.printStackTrace();
            }
        }
        return new ProductRecommendationResponse();
    }

    /**
     * @param questionFile             Spec file ID for question list
     * @param productRecommendationSet Contains questionID from matched answered questions
     * @return List of questions from spec file
     */
    private QuestionList getQuestion(String questionFile, ProductRecommendationSet productRecommendationSet) {
        mLog.debug("Trace 1: Locate Product questions file");
        String questionsFile = findProductsFile(questionFile);

        try {
            QuestionList questionList = new QuestionList();
            NextQuestionToAskList nextQuestionToAskList = productRecommendationSet.getNextQuestionToAskList();
            AnsweredQuestionList answeredQuestions = productRecommendationSet.getAnsweredQuestionList();

            mLog.debug("Trace 2: Read spec file");
            QuestionListType questionListType = new ObjectMapper().readValue(questionsFile, QuestionListType.class);

            mLog.debug("Trace 3: Find next best question(s)");
            List<Question> questionList1 = new ArrayList<>();
            //Loop through the file containing all the questions
            for (Question question : questionListType.getQuestionList().getQuestion()) {

                Question question1 = addPrevQuestion(question, answeredQuestions);
                if (question1.getQuestionID() != null)
                    questionList1.add(question1);

                if (!nextQuestionToAskList.getQuestionID().isEmpty()) {
                    for (String qID : nextQuestionToAskList.getQuestionID()) {
                        if (question.getQuestionID().equals(qID)) {
                            questionList1.add(question);
                            break; // get out of loop if match is found
                        }
                    }
                }

            }
            questionList.setQuestion(questionList1);
            return questionList;
        } catch (Exception e) {
            mLog.debug("Error: Could not get next list of questions");
            e.printStackTrace();
        }

        return new QuestionList();
    }

    /**
     * @param answeredQuestionReq incoming list of Answered questions
     * @return Product set containing answers, recommendation and next question(s)
     */
    private ProductRecommendationSet findProduct(AnsweredQuestionList answeredQuestionReq) {
        mLog.debug("Trace 1: Search product set with answered questions" + answeredQuestionReq);
        for (ProductRecommendationSet productRecommendationSetItem : recommendationSetList.getProductRecommendationSetList().getProductRecommendationSet()) {
            if (compareAnswerQuestion(productRecommendationSetItem.getAnsweredQuestionList(), answeredQuestionReq)) { //compare individual values
                return productRecommendationSetItem;
            }
        }
        return new ProductRecommendationSet();
    }

    /**
     * @param answeredQuestionList1 the question & answer list from specifications
     * @param answeredQuestionList2 the question & answer list from the request
     * @return boolean
     */
    private boolean compareAnswerQuestion(AnsweredQuestionList answeredQuestionList1, AnsweredQuestionList answeredQuestionList2) {
        boolean foundMatch = false;

        try {
            if (answeredQuestionList1.getAnsweredQuestion().size() == answeredQuestionList2.getAnsweredQuestion().size()) {
                mLog.debug("Trace 1: Compare answer question lists");

                AnsweredQuestion answeredQuestion1;
                AnsweredQuestion answeredQuestion2;
                for (int i = 0; i < answeredQuestionList2.getAnsweredQuestion().size(); i++) {
                    foundMatch = false;
                    answeredQuestion1 = answeredQuestionList1.getAnsweredQuestion().get(i);
                    answeredQuestion2 = answeredQuestionList2.getAnsweredQuestion().get(i);

                    if ((answeredQuestion1.getQuestionID().equals(answeredQuestion2.getQuestionID())) &&
                            (answeredQuestion1.getAnswer().equals(answeredQuestion2.getAnswer()))) {
                        mLog.debug("Trace 2: Compare individual values");
                        foundMatch = true;
                    } else //If there are answers that do not match, no need to check next question/answer pair
                        break;
                }
            }
        } catch (Exception e) {
            mLog.debug("Error: Could not compare answered question list from request");
            e.printStackTrace();
        }
        return foundMatch;
    }

    private Question addPrevQuestion(Question question, AnsweredQuestionList answeredQuestions){

        for (AnsweredQuestion answeredQuestion : answeredQuestions.getAnsweredQuestion()) {
            if (question.getQuestionID().equals(answeredQuestion.getQuestionID())) {
                question.setAnswer(answeredQuestion.getAnswer());
                return question;
            }
        }
        return new Question();
    }
}
