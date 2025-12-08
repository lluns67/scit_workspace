package net.datasa.spring5.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Homecontroller {
	
	@GetMapping({"","/"})
	public String home(){
		return "home";
	}
}
