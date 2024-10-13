package techtask.DTO;

import lombok.Getter;

import java.util.List;

@Getter
public class QuestionsDTO {
    private Long question_id;
    private String question_txt;
    private Long api_id;
    @Getter
    private List<AnswersDTO> answersList;

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public void setQuestion_txt(String question_txt) {
        this.question_txt = question_txt;
    }

    public void setApi_id(Long api_id) {
        this.api_id = api_id;
    }

    public void setAnswersList(List<AnswersDTO> answersList) {
        this.answersList = answersList;
    }
}
