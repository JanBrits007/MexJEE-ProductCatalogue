
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "answeredQuestion"
})
public class AnsweredQuestionList implements Serializable
{

    @JsonProperty("answeredQuestion")
    private List<AnsweredQuestion> answeredQuestion = null;
    private static final long serialVersionUID = -5656995600717570480L;

    @JsonProperty("answeredQuestion")
    public List<AnsweredQuestion> getAnsweredQuestion() {
        return answeredQuestion;
    }

    @JsonProperty("answeredQuestion")
    public void setAnsweredQuestion(List<AnsweredQuestion> answeredQuestion) {
        this.answeredQuestion = answeredQuestion;
    }

    @Override
    public String toString() {
        return "AnsweredQuestionList{" +
                "answeredQuestion=" + answeredQuestion +
                '}';
    }
}
