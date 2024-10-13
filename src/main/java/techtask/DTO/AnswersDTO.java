package techtask.DTO;

import lombok.Getter;
import techtask.model.Questions;

@Getter
public class AnswersDTO {

    private Long answer_id;

    private String answer_txt;
    private Boolean answer_isCorrect;
    private Long question_id;

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }

    public void setAnswer_txt(String answer_txt) {
        this.answer_txt = answer_txt;
    }

    public void setAnswer_isCorrect(Boolean answer_isCorrect) {
        this.answer_isCorrect = answer_isCorrect;
    }
}
