
package za.co.nb.productcatalogue.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "recommendedProduct"
})
public class RecommendedProductList implements Serializable
{

    @JsonProperty("recommendedProduct")
    private List<RecommendedProduct> recommendedProduct = null;
    private static final long serialVersionUID = 375970579252278051L;

    @JsonProperty("recommendedProduct")
    public List<RecommendedProduct> getRecommendedProduct() {
        if (recommendedProduct == null) {
            recommendedProduct = new ArrayList<>();
        }
        return recommendedProduct;
    }

    @JsonProperty("recommendedProduct")
    public void setRecommendedProduct(List<RecommendedProduct> recommendedProduct) {
        this.recommendedProduct = recommendedProduct;
    }

}
