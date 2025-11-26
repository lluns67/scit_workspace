package net.nocori.spring21.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nocori.spring21.domain.dto.PersonDTO;
import net.nocori.spring21.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
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
	public String insert(PersonDTO personDTO){
		log.debug("전달 값 {}", personDTO);
		ps.insert(personDTO);
		
		return "redirect:/";
		
		
	}
	@GetMapping("select")
	public String select(){
		return "selectForm";
	}
	
	@PostMapping("select")
	public String select(@RequestParam String id, Model model){
		PersonDTO dto = ps.select(id);
		
		model.addAttribute("id", id);
		model.addAttribute("person", dto);
		
		return "select";
	}
	@GetMapping("delete")
	public String delete() {
		return "deleteForm";
	}
	@PostMapping("delete")
	public String delete(
			@RequestParam String id, Model model){
		log.debug("삭제할 아이디 {}", id);
		
		boolean result = true;
		
		try {
			ps.delete(id);
		} catch (Exception e) {
			result = false;
			log.debug("삭제실패");
		}
		
		
		model.addAttribute("id", id);
		model.addAttribute("result", result);
		
		return "delete";
	}
	
	
	@GetMapping("selectAll")
	public String selectAll(Model model){
		List<PersonDTO> personlist = ps.selectAll();
		model.addAttribute("personList",personlist);
		
		return "selectAll";
	}
	
	@GetMapping("selectAll2")
	public String selectAll2(Model model){
		List<PersonDTO> personlist = ps.selectAll();
		model.addAttribute("personList",personlist);
		
		return "selectAll2";
	}
}
