
package za.co.nb.productcatalogue.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

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

}
