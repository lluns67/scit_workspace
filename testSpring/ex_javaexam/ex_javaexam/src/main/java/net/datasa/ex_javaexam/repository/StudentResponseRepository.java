package net.datasa.ex_javaexam.repository;

import net.datasa.ex_javaexam.domain.entity.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface StudentResponseRepository extends JpaRepository<StudentResponse, Long> {
	List<StudentResponse> findAllByOrderBySubmittedAtDesc();
	List<StudentResponse> findAllByOrderByNameAsc();
	List<StudentResponse> findAllByOrderByScoreDesc();
	boolean existsByEmailAndSubmittedAtBetween(String email, Instant start, Instant end); }
