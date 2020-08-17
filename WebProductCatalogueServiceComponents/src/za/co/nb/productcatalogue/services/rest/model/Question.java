
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "questionID",
        "questionDisplayName",
        "answerType",
        "answerOptions",
        "answer"
})
public class Question implements Serializable {

    @JsonProperty("questionID")
    private String questionID;
    @JsonProperty("questionDisplayName")
    private String questionDisplayName;
    @JsonProperty("answerType")
    private String answerType;
    @JsonProperty("answerOptions")
    private List<AnswerOption> answerOptions;
    @JsonProperty("answer")
    private String answer;
    private static final long serialVersionUID = 5252313354711233249L;

    @JsonProperty("questionID")
    public String getQuestionID() {
        return questionID;
    }

    @JsonProperty("questionID")
    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    @JsonProperty("questionDisplayName")
    public String getQuestionDisplayName() {
        return questionDisplayName;
    }

    @JsonProperty("questionDisplayName")
    public void setQuestionDisplayName(String questionDisplayName) {
        this.questionDisplayName = questionDisplayName;
    }

    @JsonProperty("answerType")
    public String getAnswerType() {
        return answerType;
    }

    @JsonProperty("answerType")
    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    @JsonProperty("answerOptions")
    public List<AnswerOption> getAnswerOptions() {
        if (answerOptions == null)
            answerOptions = new ArrayList<>();
        return answerOptions;
    }

    @JsonProperty("answerOptions")
    public void setAnswerOptions(List<AnswerOption> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
