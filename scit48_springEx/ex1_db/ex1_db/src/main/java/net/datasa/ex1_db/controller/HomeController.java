package net.datasa.ex1_db.controller;

import lombok.extern.slf4j.Slf4j;
import net.datasa.ex1_db.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {
	
	@Qualifier("impl1")
	// 어떤거 주입할지 고를때 @autowire랑 주로 같이 씀
	@Autowired TestService ts;
	
	@GetMapping({"/",""})
	public String home(){
		ts.testlog();
		return "home";
	}
}
