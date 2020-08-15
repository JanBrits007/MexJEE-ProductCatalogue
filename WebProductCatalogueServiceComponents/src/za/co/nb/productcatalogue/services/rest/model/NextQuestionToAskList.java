
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NextQuestionToAskList implements Serializable
{

    @JsonProperty("questionID")
    private List<String> questionID = null;
    private static final long serialVersionUID = -6726064017386571487L;

    @JsonProperty("questionID")
    public List<String> getQuestionID() {
        return questionID;
    }

    @JsonProperty("questionID")
    public void setQuestionID(List<String> questionID) {
        this.questionID = questionID;
    }

}
