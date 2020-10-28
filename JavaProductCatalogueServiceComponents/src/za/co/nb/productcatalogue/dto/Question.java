
package za.co.nb.productcatalogue.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "questionID",
        "questionDisplayName",
        "questionName",
        "answerType",
        "answerOptions",
        "answer"
})
public class Question implements Serializable {

    @JsonProperty("questionID")
    private String questionID;
    @JsonProperty("questionDisplayName")
    private String questionDisplayName;
    @JsonProperty("questionName")
    private String questionName;
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

    @JsonProperty("questionName")
    public String getQuestionName() {
        return questionName;
    }
    @JsonProperty("questionName")
    public void setQuestionName(String questionName) {
        this.questionName = questionName;
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
