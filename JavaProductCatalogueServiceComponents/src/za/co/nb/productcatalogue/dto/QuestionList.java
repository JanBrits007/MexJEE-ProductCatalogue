
package za.co.nb.productcatalogue.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "question"
})
public class QuestionList implements Serializable
{

    @JsonProperty("question")
    private List<Question> question = null;
    private static final long serialVersionUID = 2237129463469316481L;

    @JsonProperty("question")
    public List<Question> getQuestion() {
        if (question == null)
            question = new ArrayList<>();
        return question;
    }

    @JsonProperty("question")
    public void setQuestion(List<Question> question) {
        this.question = question;
    }
}
