package techtask.model;

import jakarta.persistence.*;
import lombok.Getter;
import techtask.DTO.AnswersDTO;

@Getter
@Entity
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;

    private String answer_txt;
    private Boolean answer_isCorrect;

    @ManyToOne
    private Questions question_id;

    @ManyToOne
    private Questions questions;


    public void setQuestions(Questions questions) {
        this.questions = questions;
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

    public void setQuestion_id(Questions question_id) {
        this.question_id = question_id;
    }
}
