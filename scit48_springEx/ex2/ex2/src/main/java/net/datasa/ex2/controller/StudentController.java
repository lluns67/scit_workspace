package net.datasa.ex2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.ex2.domain.dto.StudentDTO;
import net.datasa.ex2.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StudentController {
	
	private final StudentService ss;
	
	@GetMapping("join")
	public String join(){
		return "joinForm";
	}
	@PostMapping("join")
	public String join(StudentDTO dto){
		log.debug("전달  데이터 {}", dto);
		ss.insert(dto);
		return "redirect:/";
	}
	@GetMapping("select")
	public String select(@RequestParam("sid") String sid
						,Model model){
		log.debug(sid);
		StudentDTO dto = ss.select(sid);
		model.addAttribute("dto",dto);
		
		return "select";
	}
	@GetMapping("update")
	public String update(@RequestParam("sid") String sid
					,Model model){
		log.debug(sid);
		StudentDTO dto = ss.select(sid);
		model.addAttribute("dto",dto);
		
		return "update";
	}
	@PostMapping("update")
	public String update(StudentDTO dto){
		log.debug("전달  데이터 {}", dto);
		ss.insert(dto);
		return "redirect:/";
	}
	@GetMapping("delete")
	public String delete(String sid){
		log.debug(sid);
		ss.delete(sid);
		return "redirect:/";
	}
	
}
