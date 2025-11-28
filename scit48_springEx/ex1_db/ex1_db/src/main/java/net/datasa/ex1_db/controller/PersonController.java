package net.datasa.ex1_db.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.ex1_db.domain.dto.PersonDTO;
import net.datasa.ex1_db.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j


//자동 생성자 넣기
@RequiredArgsConstructor
public class PersonController {
	
	private final PersonService ps;
	
	@GetMapping("test")
	public String test(){
		
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
		log.debug("전달된 데이타 {}",dto.toString());
		ps.insert(dto);
		return "redirect:insert";
	}
}
