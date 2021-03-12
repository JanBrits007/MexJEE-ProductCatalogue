
package za.co.nb.productcatalogue.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
}
