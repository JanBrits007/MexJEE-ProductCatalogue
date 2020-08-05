package za.co.nb.productcatalogue.services.rest.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import za.co.nb.productcatalogue.dao.ProductCataloguesDAO;
import za.co.nb.productcatalogue.services.rest.model.AnsweredQuestion;
import za.co.nb.productcatalogue.services.rest.model.AnsweredQuestionList;
import za.co.nb.productcatalogue.services.rest.model.NextQuestionToAskList;
import za.co.nb.productcatalogue.services.rest.model.ProductRecommendationResponse;
import za.co.nb.productcatalogue.services.rest.model.ProductRecommendationSet;
import za.co.nb.productcatalogue.services.rest.model.ProductRecommendationSetListType;
import za.co.nb.productcatalogue.services.rest.model.Question;
import za.co.nb.productcatalogue.services.rest.model.QuestionList;
import za.co.nb.productcatalogue.services.rest.model.QuestionListType;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * service implementation
 */

@Stateless
public class ProductRecommendationService {


    private ProductRecommendationSetListType recommendationSetList;

    private ProductCataloguesDAO mProductCataloguesDAO;
    private final Log mLog = LogFactory.getLog(getClass());

    //This sets up the function to retrieve JSON responses from actual JSON files
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
            return getProductCataloguesDAO().getProductCatalogueJSONByID(pJsonFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

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
                productRecommendationResponse.setRecommendedProductList(productRecommendationSet.getRecommendedProductList());

                if (productRecommendationSet.getNextQuestionToAskList().getQuestionID() != null && !productRecommendationSet.getNextQuestionToAskList().getQuestionID().isEmpty()) {
                    mLog.debug("Trace 4: Load next question list");
                    QuestionList questionList = getQuestion(questionSetFile, productRecommendationSet.getNextQuestionToAskList());

                    productRecommendationResponse.setQuestionList(questionList);
                }

                return productRecommendationResponse;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ProductRecommendationResponse();
    }

    private QuestionList getQuestion(String questionFile, NextQuestionToAskList nextQuestionToAskList) {
        mLog.debug("Trace 1: Locate Product questions file");
        String questionsFile = findProductsFile(questionFile);
        if (questionsFile != null) {
            try {
                QuestionList questionList = new QuestionList();
                mLog.debug("Trace 2: Read spec file");
                QuestionListType questionListType = new ObjectMapper().readValue(questionsFile, QuestionListType.class);

                mLog.debug("Trace 3: Find next best question(s)");
                if (!nextQuestionToAskList.getQuestionID().isEmpty()) {
                    List<Question> questionList1 = new ArrayList<>();
                    for (Question question : questionListType.getQuestionList().getQuestion()) {
                        if (question.getQuestionID().equals(nextQuestionToAskList.getQuestionID())) {
                            mLog.debug("Trace 4: Found matching questions");
                            questionList1.add(question);
                        }
                    }
                    questionList.setQuestion(questionList1);
                    return questionList;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new QuestionList();
    }

    /**
     * @param answeredQuestionReq incoming list of Answered questions
     * @return List of recommended products
     */
    private ProductRecommendationSet findProduct(AnsweredQuestionList answeredQuestionReq) {

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
                    mLog.debug("Trace 2: Compare individual values" + answeredQuestion1.getAnswer() + " == " + answeredQuestion2.getAnswer());
                    foundMatch = true;
                } else //If there are answers that do not match, no need to check next question/answer pair
                    break;
            }
        }

        return foundMatch;
    }

}
