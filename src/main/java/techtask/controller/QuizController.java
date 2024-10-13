package techtask.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techtask.DTO.AnswersDTO;
import techtask.model.Answers;
import techtask.model.Questions;
import techtask.repository.QuestionsRepository;
import techtask.service.QuizService;

import java.util.List;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionsRepository questionsRepository;


    @GetMapping("/questions")
    public ResponseEntity<Questions> getRandomQuestion() {
        List<Questions> allQuestions = questionsRepository.findAll();

        if (allQuestions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        Random random = new Random();
        Questions randomQuestion = allQuestions.get(random.nextInt(allQuestions.size()));
        return new ResponseEntity<>(randomQuestion, HttpStatus.OK);
    }

    @PostMapping("/answers")
    public ResponseEntity<Questions> getQuestionAndAnswers(@RequestBody AnswersDTO answersDTO) {

        Long question_id = answersDTO.getQuestion_id();
        Questions question = questionsRepository.findById(question_id).orElse(null);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

}