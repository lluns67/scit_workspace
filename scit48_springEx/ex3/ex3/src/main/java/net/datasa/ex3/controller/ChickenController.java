package net.datasa.ex3.controller;

import lombok.extern.slf4j.Slf4j;
import net.datasa.ex3.domain.dto.ChickenDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ChickenController {
	@GetMapping("modaltest")
	public String modaltest(){
		return "modaltest";
	}
	@GetMapping("order")
	public String order(){
		return  "order";
	}
	@PostMapping("order")
	public String order(ChickenDTO dto){
		log.debug(dto.toString());
		
		return "redirect:/";
	}
}
