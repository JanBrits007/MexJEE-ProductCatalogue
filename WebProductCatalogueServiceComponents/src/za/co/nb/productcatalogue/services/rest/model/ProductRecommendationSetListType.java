
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "productRecommendationSetList"
})
public class ProductRecommendationSetListType implements Serializable
{

    @JsonProperty("productRecommendationSetList")
    private ProductRecommendationSetList productRecommendationSetList;
    private static final long serialVersionUID = -6352215004529310890L;

    @JsonProperty("productRecommendationSetList")
    public ProductRecommendationSetList getProductRecommendationSetList() {
        return productRecommendationSetList;
    }

    @JsonProperty("productRecommendationSetList")
    public void setProductRecommendationSetList(ProductRecommendationSetList productRecommendationSetList) {
        this.productRecommendationSetList = productRecommendationSetList;
    }

    @Override
    public String toString() {
        return "ProductRecommendationSetListType{" +
                "productRecommendationSetList=" + productRecommendationSetList +
                '}';
    }
}
