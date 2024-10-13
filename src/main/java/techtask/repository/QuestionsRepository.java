package techtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techtask.model.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
}
