package net.datasa.ex_javaexam.service;

// ExamService.java


import jakarta.transaction.Transactional;
import net.datasa.ex_javaexam.domain.entity.StudentResponse;
import net.datasa.ex_javaexam.repository.ExamAnswerRepository;
import net.datasa.ex_javaexam.repository.StudentResponseRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;

@Service
public class ExamService {
	private final ExamAnswerRepository answerRepo;
	private final StudentResponseRepository responseRepo;
	
	public ExamService(ExamAnswerRepository a, StudentResponseRepository r) {
		this.answerRepo = a; this.responseRepo = r;
	}
	
	// 5문항, 문항당 20점 = 100점
	private int score(Map<Integer, String> submitted) {
		int total = 0;
		for (int q = 1; q <= 5; q++) {
			String correct = answerRepo.findByQuestionNo(q)
					.map(e -> e.getCorrectAnswer()).orElse(null);
			if (correct != null && correct.equalsIgnoreCase(submitted.get(q))) {
				total += 20;
			}
		}
		return total;
	}
	
	// 동일 이메일 중복 응시 방지(당일 기준)
	private boolean isDuplicateToday(String email) {
		LocalDate today = LocalDate.now(ZoneId.of("Asia/Seoul"));
		Instant start = today.atStartOfDay(ZoneId.of("Asia/Seoul")).toInstant();
		Instant end = today.plusDays(1).atStartOfDay(ZoneId.of("Asia/Seoul")).toInstant();
		return responseRepo.existsByEmailAndSubmittedAtBetween(email, start, end);
	}
	
	@Transactional
	public StudentResponse submit(StudentResponse req) {
		if (isDuplicateToday(req.getEmail())) {
			throw new IllegalStateException("이미 오늘 응시 기록이 있습니다.");
		}
		int s = score(Map.of(
				1, req.getAnswer1(),
				2, req.getAnswer2(),
				3, req.getAnswer3(),
				4, req.getAnswer4(),
				5, req.getAnswer5()
		));
		req.setScore(s);
		return responseRepo.save(req);
	}
	
	@Transactional
	public void deleteByIdWithPassword(Long id, String password) {
		StudentResponse r = responseRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("응시 기록이 없습니다."));
		if (!r.getPassword().equals(password)) {
			throw new SecurityException("비밀번호가 일치하지 않습니다.");
		}
		responseRepo.deleteById(id);
	}
}

