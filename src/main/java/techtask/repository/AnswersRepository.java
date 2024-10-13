package techtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techtask.model.Answers;

public interface AnswersRepository extends JpaRepository<Answers, Long> {

}

