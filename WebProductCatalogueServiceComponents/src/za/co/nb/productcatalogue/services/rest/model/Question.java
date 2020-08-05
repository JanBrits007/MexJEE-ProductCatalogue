
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "questionID",
    "questionDisplayName",
    "answerType",
    "answerOptionsList"
})
public class Question implements Serializable
{

    @JsonProperty("questionID")
    private String questionID;
    @JsonProperty("questionDisplayName")
    private String questionDisplayName;
    @JsonProperty("answerType")
    private String answerType;
    @JsonProperty("answerOptionsList")
    private AnswerOptionsList answerOptionsList;
    private final static long serialVersionUID = 5252313354711233249L;

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

    @JsonProperty("answerOptionsList")
    public AnswerOptionsList getAnswerOptionsList() {
        if (answerOptionsList == null)
            answerOptionsList = new AnswerOptionsList();
        return answerOptionsList;
    }

    @JsonProperty("answerOptionsList")
    public void setAnswerOptionsList(AnswerOptionsList answerOptionsList) {
        this.answerOptionsList = answerOptionsList;
    }

    @Override
    public String toString() {
        return "{" +
                "\"questionID\":\"" + questionID + "\"" +
                ", \"questionDisplayName\":\"" + questionDisplayName + "\"" +
                ", \"answerType\":\"" + answerType + "\"" +
                ", \"answerOptions\":" + answerOptionsList +
                '}';
    }
}
