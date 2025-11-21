package net.datasa.spring3.controller;


import lombok.extern.slf4j.Slf4j;
import net.datasa.spring3.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Homecontroller {
	
	@Qualifier("impl2")
	@Autowired
	TestService ts;
	
	@GetMapping({"", "/"})
	public String home() {
		ts.testLog();
		return "home";
	}
}
