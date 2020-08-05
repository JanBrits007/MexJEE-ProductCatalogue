
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "productRecommendationSet"
})
public class ProductRecommendationSetList implements Serializable
{

    @JsonProperty("productRecommendationSet")
    private List<ProductRecommendationSet> productRecommendationSet = null;
    private final static long serialVersionUID = -1410331397741103233L;

    @JsonProperty("productRecommendationSet")
    public List<ProductRecommendationSet> getProductRecommendationSet() {
        return productRecommendationSet;
    }

    @JsonProperty("productRecommendationSet")
    public void setProductRecommendationSet(List<ProductRecommendationSet> productRecommendationSet) {
        this.productRecommendationSet = productRecommendationSet;
    }

    @Override
    public String toString() {
        return "ProductRecommendationSetList{" +
                "productRecommendationSet=" + productRecommendationSet +
                '}';
    }
}
