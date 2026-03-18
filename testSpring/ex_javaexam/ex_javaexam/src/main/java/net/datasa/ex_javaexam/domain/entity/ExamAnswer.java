package net.datasa.ex_javaexam.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter

@Table(name = "exam_answers")
public class ExamAnswer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "question_no", nullable = false, unique = true)
	private Integer questionNo;
	
	@Column(name = "correct_answer", nullable = false)
	private String correctAnswer;
	
	@Column(name = "created_at")
	private Instant createdAt = Instant.now();
	
	// getters/setters
	
	
}
