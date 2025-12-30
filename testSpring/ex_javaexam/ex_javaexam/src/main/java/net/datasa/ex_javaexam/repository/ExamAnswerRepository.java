package net.datasa.ex_javaexam.repository;

// ExamAnswerRepository.java


import net.datasa.ex_javaexam.domain.entity.ExamAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamAnswerRepository extends JpaRepository<ExamAnswer, Long> {
	Optional<ExamAnswer> findByQuestionNo(Integer questionNo);
}

