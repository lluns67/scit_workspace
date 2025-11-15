package net.nocori.spring13.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class log {
	
	
	
	@GetMapping("lom/logger")
	public String logger(){
		
		log.error("error 출력");
		log.warn("warn 출력");
		log.info("info 출력");
		log.debug("debug 출력");
		log.trace("trace 출력");
		
		return "redirect:/";
		
	}
}
