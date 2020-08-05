package za.co.nb.productcatalogue.services.rest.model;


public class ProductRecommendationResponse {

    private RecommendedProductList recommendedProductList;
    private QuestionList questionList;

    public RecommendedProductList getRecommendedProductList() {
        if (recommendedProductList == null)
            recommendedProductList = new RecommendedProductList();
        return recommendedProductList;
    }

    public void setRecommendedProductList(RecommendedProductList recommendedProductList) {
        this.recommendedProductList = recommendedProductList;
    }

    public QuestionList getQuestionList() {
        if (questionList == null)
            questionList = new QuestionList();
        return questionList;
    }

    public void setQuestionList(QuestionList questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        if (recommendedProductList == null) {
            this.getRecommendedProductList();
        }
        if (questionList == null) {
            this.getQuestionList();
        }

        return "{" + recommendedProductList +
                "," + questionList +
                '}';

    }
}
