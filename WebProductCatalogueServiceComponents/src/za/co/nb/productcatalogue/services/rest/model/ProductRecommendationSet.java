
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "answeredQuestionList",
    "recommendedProductList",
    "nextQuestionToAskList"
})
public class ProductRecommendationSet implements Serializable
{

    @JsonProperty("answeredQuestionList")
    private AnsweredQuestionList answeredQuestionList;
    @JsonProperty("recommendedProductList")
    private RecommendedProductList recommendedProductList;
    @JsonProperty("nextQuestionToAskList")
    private NextQuestionToAskList nextQuestionToAskList;
    private static final long serialVersionUID = 3516452773068833309L;

    @JsonProperty("answeredQuestionList")
    public AnsweredQuestionList getAnsweredQuestionList() {
        if (answeredQuestionList == null)
            answeredQuestionList = new AnsweredQuestionList();
        return answeredQuestionList;
    }

    @JsonProperty("answeredQuestionList")
    public void setAnsweredQuestionList(AnsweredQuestionList answeredQuestionList) {
        this.answeredQuestionList = answeredQuestionList;
    }

    @JsonProperty("recommendedProductList")
    public RecommendedProductList getRecommendedProductList() {
        if (recommendedProductList == null)
            recommendedProductList = new RecommendedProductList();
        return recommendedProductList;
    }

    @JsonProperty("recommendedProductList")
    public void setRecommendedProductList(RecommendedProductList recommendedProductList) {
        this.recommendedProductList = recommendedProductList;
    }

    @JsonProperty("nextQuestionToAskList")
    public NextQuestionToAskList getNextQuestionToAskList() {
        if (nextQuestionToAskList == null)
            nextQuestionToAskList = new NextQuestionToAskList();
        return nextQuestionToAskList;
    }

    @JsonProperty("nextQuestionToAskList")
    public void setNextQuestionToAskList(NextQuestionToAskList nextQuestionToAskList) {
        this.nextQuestionToAskList = nextQuestionToAskList;
    }

    @Override
    public String toString() {
        return "ProductRecommendationSet{" +
                "answeredQuestionList=" + answeredQuestionList +
                ", recommendedProductList=" + recommendedProductList +
                ", nextQuestionToAskList=" + nextQuestionToAskList +
                '}';
    }
}
