
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "questionID"
})
public class NextQuestionToAskList implements Serializable
{

    @JsonProperty("questionID")
    private String questionID;
    private static final long serialVersionUID = -6726064017386571487L;

    @JsonProperty("questionID")
    public String getQuestionID() {
        return questionID;
    }

    @JsonProperty("questionID")
    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    @Override
    public String toString() {
        return "NextQuestionToAskList{" +
                "questionID='" + questionID + '\'' +
                '}';
    }
}
