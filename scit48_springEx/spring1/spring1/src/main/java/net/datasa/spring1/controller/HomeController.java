package net.datasa.spring1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// spring에게 "이 클래스틑 http 요청을 ㅓ리하는 클래스입니다" 라고 명시
@Controller
public class HomeController {
	
	
	// http://localhost:9991/
	@GetMapping({"", "/"})
	public String home(){
		//resources/templates 패키지에서 해당 html 찾음
		return "home";
	}
	
}
