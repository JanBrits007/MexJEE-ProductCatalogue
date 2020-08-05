
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "recommendationReason"
})
public class RecommendationReasons implements Serializable
{

    @JsonProperty("recommendationReason")
    private String recommendationReason;
    private final static long serialVersionUID = -1035926861039831479L;

    @JsonProperty("recommendationReason")
    public String getRecommendationReason() {
        return recommendationReason;
    }

    @JsonProperty("recommendationReason")
    public void setRecommendationReason(String recommendationReason) {
        this.recommendationReason = recommendationReason;
    }

    @Override
    public String toString() {
        return "\"" + recommendationReason + "\"";
    }
}
