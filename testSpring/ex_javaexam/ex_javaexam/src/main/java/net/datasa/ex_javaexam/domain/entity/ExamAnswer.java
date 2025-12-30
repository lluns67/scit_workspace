package net.datasa.ex_javaexam.domain.entity;



import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "exam_answers")
public class ExamAnswer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "question_no", nullable = false, unique = true)
	private Integer questionNo;
	
	@Column(name = "correct_answer", nullable = false)
	private String correctAnswer;
	
	@Column(name = "created_at")
	private Instant createdAt = Instant.now();
	
	// getters/setters
}
