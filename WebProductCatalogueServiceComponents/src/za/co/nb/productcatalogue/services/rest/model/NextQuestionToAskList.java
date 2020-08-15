
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NextQuestionToAskList implements Serializable
{

    @JsonProperty("questionID")
    private List<String> questionID = null;
    private static final long serialVersionUID = -6726064017386571487L;

    @JsonProperty("questionID")
    public List<String> getQuestionID() {
        if (questionID == null)
            questionID = new ArrayList<>();
        return questionID;
    }

    @JsonProperty("questionID")
    public void setQuestionID(List<String> questionID) {
        this.questionID = questionID;
    }

}
