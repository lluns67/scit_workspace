package net.datasa.ex_javaexam.domain.entity;



import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "student_responses",
		indexes = {
				@Index(name = "ux_student_email_once", columnList = "email, submitted_at")
		}
)
public class StudentResponse {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false) private String name;
	@Column(nullable = false) private String email;
	@Column(nullable = false) private String password;
	
	@Column(nullable = false) private String answer1;
	@Column(nullable = false) private String answer2;
	@Column(nullable = false) private String answer3;
	@Column(nullable = false) private String answer4;
	@Column(nullable = false) private String answer5;
	
	private Integer score = 0;
	private Instant submittedAt = Instant.now();
	
	// getters/setters
}
