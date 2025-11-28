package net.datasa.ex2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.ex2.domain.dto.StudentDTO;
import net.datasa.ex2.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
	
	private  final StudentService ss;
	
	@GetMapping({"","/"})
	public String home(Model model){
		
		List<StudentDTO> studentList = ss.selectAll();
		model.addAttribute("studentList", studentList);
		
		
		return "home";
	}
}
