
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "questionList"
})
public class QuestionListType implements Serializable
{

    @JsonProperty("questionList")
    private QuestionList questionList;
    private static final long serialVersionUID = 8374756632291021616L;

    @JsonProperty("questionList")
    public QuestionList getQuestionList() {
        if (questionList == null)
            questionList = new QuestionList();
        return questionList;
    }

    @JsonProperty("questionList")
    public void setQuestionList(QuestionList questionList) {
        this.questionList = questionList;
    }

}
