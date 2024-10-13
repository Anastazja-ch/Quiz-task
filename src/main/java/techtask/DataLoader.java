package techtask;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import techtask.service.QuizService;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private QuizService quizService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Pobieranie i zapisywanie pytań z API...");
        quizService.collectAndSaveQuestions();
        System.out.println("Zakończono pobieranie pytań.");
    }
}
