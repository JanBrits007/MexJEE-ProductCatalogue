
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "productID",
    "recommendationReasons"
})
public class RecommendedProduct implements Serializable
{

    @JsonProperty("productID")
    private String productID;
    @JsonProperty("recommendationReasons")
    private RecommendationReasons recommendationReasons;
    private final static long serialVersionUID = 7484557766753622146L;

    @JsonProperty("productID")
    public String getProductID() {
        return productID;
    }

    @JsonProperty("productID")
    public void setProductID(String productID) {
        this.productID = productID;
    }

    @JsonProperty("recommendationReasons")
    public RecommendationReasons getRecommendationReasons() {
        return recommendationReasons;
    }

    @JsonProperty("recommendationReasons")
    public void setRecommendationReasons(RecommendationReasons recommendationReasons) {
        this.recommendationReasons = recommendationReasons;
    }

    @Override
    public String toString() {
        return "{" +
                "\"productID\":\"" + productID + "\"" +
                ",\"recommendationReasons\":" + recommendationReasons +
                '}';
    }
}
