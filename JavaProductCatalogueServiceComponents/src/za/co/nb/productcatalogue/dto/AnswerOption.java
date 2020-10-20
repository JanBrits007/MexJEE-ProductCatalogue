
package za.co.nb.productcatalogue.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "answerID",
    "answerDisplayValue"
})
public class AnswerOption implements Serializable
{

    @JsonProperty("answerID")
    private String answerID;
    @JsonProperty("answerDisplayValue")
    private String answerDisplayValue;
    private static final long serialVersionUID = -246073998327621727L;

    @JsonProperty("answerID")
    public String getAnswerID() {
        return answerID;
    }

    @JsonProperty("answerID")
    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    @JsonProperty("answerDisplayValue")
    public String getAnswerDisplayValue() {
        return answerDisplayValue;
    }

    @JsonProperty("answerDisplayValue")
    public void setAnswerDisplayValue(String answerDisplayValue) {
        this.answerDisplayValue = answerDisplayValue;
    }

}
