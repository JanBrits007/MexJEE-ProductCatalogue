
package za.co.nb.productcatalogue.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List<String> recommendationReasons;
    private static final long serialVersionUID = 7484557766753622146L;

    @JsonProperty("productID")
    public String getProductID() {
        return productID;
    }

    @JsonProperty("productID")
    public void setProductID(String productID) {
        this.productID = productID;
    }

    @JsonProperty("recommendationReasons")
    public List<String> getRecommendationReasons() {
        if (recommendationReasons == null)
            recommendationReasons = new ArrayList<>();
        return recommendationReasons;
    }

    @JsonProperty("recommendationReasons")
    public void setRecommendationReasons(List<String> recommendationReasons) {
        this.recommendationReasons = recommendationReasons;
    }

}
