package net.datasa.ex_javaexam.controller;

import net.datasa.ex_javaexam.domain.entity.StudentResponse;
import net.datasa.ex_javaexam.repository.StudentResponseRepository;
import net.datasa.ex_javaexam.service.ExamService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ExamController {
	private final ExamService examService;
	private final StudentResponseRepository responseRepo;
	
	public ExamController(ExamService s, StudentResponseRepository r) {
		this.examService = s; this.responseRepo = r;
	}
	
	// 시험 응시 화면
	@GetMapping("/exam")
	public String examPage() {
		return "exam"; // src/main/resources/templates/exam.html
	}
	
	// 제출 처리: 채점 + 저장, 중복 이메일은 반환
	@PostMapping(value = "/exam/submit", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String submit(StudentResponse req, Model model) {
		try {
			StudentResponse saved = examService.submit(req);
			model.addAttribute("message", "제출 완료: 점수 " + saved.getScore());
			return "redirect:/results";
		} catch (IllegalStateException dup) {
			String error = String.format("이미 응시한 이메일입니다. %s",req.getEmail());
			model.addAttribute("error", error);
			model.addAttribute("prefill", req);
			return "exam";
		}
	}
	
	// 결과 보기: 기본은 날짜 내림차순
	@GetMapping("/results")
	public String results(@RequestParam(name = "sort", required = false, defaultValue = "date") String sort,
						  Model model) {
		List<StudentResponse> list;
		switch (sort) {
			case "name": list = responseRepo.findAllByOrderByNameAsc(); break;
			case "score": list = responseRepo.findAllByOrderByScoreDesc(); break;
			default: list = responseRepo.findAllByOrderBySubmittedAtDesc();
		}
		model.addAttribute("responses", list);
		model.addAttribute("sort", sort);
		return "results"; // src/main/resources/templates/results.html
	}
	
	// 삭제 확인 페이지로 이동
	@GetMapping("/results/delete")
	public String deletePage(@RequestParam Long id, Model model) {
		// ID로 해당 응시 정보를 찾아 모델에 담음
		StudentResponse response = responseRepo.findById(id).orElse(null);
		model.addAttribute("response", response);
		return "delete"; // delete.html 호출
	}
	
	// 응시 기록 삭제(비밀번호 확인)
	@PostMapping("/results/delete")
	public String delete(@RequestParam Long id, @RequestParam String password, Model model) {
		try {
			examService.deleteByIdWithPassword(id, password);
			return "redirect:/results";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect:/results";
		}
	}
}

