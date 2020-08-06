
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "questionID",
    "answer"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnsweredQuestion implements Serializable
{

    @JsonProperty("questionID")
    private String questionID;
    @JsonProperty("answer")
    private String answer;
    private static final long serialVersionUID = 6905059975993663449L;

    @JsonProperty("questionID")
    public String getQuestionID() {
        return questionID;
    }

    @JsonProperty("questionID")
    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    @JsonProperty("answer")
    public String getAnswer() {
        return answer;
    }

    @JsonProperty("answer")
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "AnsweredQuestion{" +
                "questionID='" + questionID + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
