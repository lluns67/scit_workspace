package net.datasa.spring3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring3.domain.dto.PersonDTO;
import net.datasa.spring3.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PersonController {
	
	
	private final PersonService ps;
	
	@GetMapping("test")
	public String test() {
		ps.test();
		
		return "redirect:/";
	}
	@GetMapping("insert")
	public String insert(){
		return "insertForm";
	}
	@PostMapping("insert")
	public String insert(
			PersonDTO dto
	) {
		log.debug("전달된 데이터: {}",dto);
		
		ps.insert(dto);
		
		return "redirect:/";
	}
	
	@GetMapping("select")
	public String select(){
		return "selectForm";
	}
	@PostMapping("select")
	public String select(
			@RequestParam("id") String id,
			Model model
	){
		log.debug("조회할 아이디: {}",id);
		
		PersonDTO dto = ps.select(id);
		model.addAttribute("id",id);
		model.addAttribute("person", dto);
		
		
		return "select";
	}
}
