package za.co.nb.productcatalogue.services.rest.model;

import za.co.nb.dto.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class ProductRecommendationResponse {

    private List<RecommendedProduct> recommendedProducts;
    private List<Question> questions;
    private ResultSet resultSet;

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public List<RecommendedProduct>  getRecommendedProducts() {
        if (recommendedProducts == null)
            recommendedProducts = new ArrayList<>();
        return recommendedProducts;
    }

    public void setRecommendedProducts(List<RecommendedProduct>  recommendedProducts) {
        this.recommendedProducts = recommendedProducts;
    }

    public List<Question> getQuestions() {
        if (questions == null)
            questions = new ArrayList<>();
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
