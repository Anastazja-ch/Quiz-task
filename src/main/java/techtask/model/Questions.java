package techtask.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_id;
    private String question_txt;
    private Long api_id;


    @OneToMany
    private List<Answers> answers;

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public void setQuestion_txt(String question_txt) {
        this.question_txt = question_txt;
    }

    public void setApi_id(Long api_id) {
        this.api_id = api_id;
    }
}
