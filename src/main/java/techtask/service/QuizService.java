package techtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import techtask.DTO.AnswersDTO;
import techtask.DTO.QuestionsDTO;
import techtask.model.Answers;
import techtask.model.Questions;
import techtask.repository.QuestionsRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuestionsRepository questionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${quizapi.key}")
    private String apiKey;

    String apiUrl = "https://quizapi.io/api/v1/questions";

    private Answers mapAnswerDtoToEntity(AnswersDTO answerDTO) {
        Answers answer = new Answers();
        answer.setAnswer_txt(answerDTO.getAnswer_txt());
        answer.setAnswer_isCorrect(answerDTO.getAnswer_isCorrect());
        return answer;
    }

    private Questions mapToEntity(QuestionsDTO questionsDTO) {
        Questions questions = new Questions();
        questions.setQuestion_txt(questionsDTO.getQuestion_txt());


        if (questionsDTO.getAnswersList() != null) {
            List<Answers> answersList = questionsDTO.getAnswersList().stream()
                    .map(this::mapAnswerDtoToEntity)
                    .toList();

            questions.setAnswers(answersList);

            for (Answers answers : answersList) {
                answers.setQuestions(questions);
            }
        } else {
            System.out.println("Brak odpowiedzi dla pytania: " + questionsDTO.getQuestion_txt());
        }

        return questions;
    }


    public void collectAndSaveQuestions() {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Api-Key", apiKey);


            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<QuestionsDTO[]> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, QuestionsDTO[].class);
            QuestionsDTO[] questionsDTOS = response.getBody();

            if (questionsDTOS != null) {
                List<Questions> questionsList = Arrays.stream(questionsDTOS)
                        .map(this::mapToEntity)
                        .toList();

                questionRepository.saveAll(questionsList);
                System.out.println("Zapisano pytania do bazy danych.");
            } else {
                System.out.println("Brak pytań");
            }
        } catch (Exception e) {
            System.out.println("Błąd podczas pobierania pytań z API: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
