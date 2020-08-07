
package za.co.nb.productcatalogue.services.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerOptionsList implements Serializable
{

    @JsonProperty("answerOption")
    private List<AnswerOption> answerOption = null;
    private static final long serialVersionUID = -8552752394050633594L;

    @JsonProperty("answerOption")
    public List<AnswerOption> getAnswerOption() {
        if (answerOption == null)
            answerOption = new ArrayList<>();
        return answerOption;
    }

    @JsonProperty("answerOption")
    public void setAnswerOption(List<AnswerOption> answerOption) {
        this.answerOption = answerOption;
    }

}
