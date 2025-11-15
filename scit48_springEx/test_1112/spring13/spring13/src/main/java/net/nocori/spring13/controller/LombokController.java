package net.nocori.spring13.controller;


import net.nocori.spring13.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LombokController {
	
	@GetMapping("lom/lombok")
	public String lombok(){
		
		Person p = new Person();
		p.setId("abcd");
		p.setId("홍길동");
		System.out.println(p);
		
		Person p3 = Person.builder()
				.id("dragon")
				.name("홍길순")
				.password("123")
				.build();
		System.out.println(p3);
		return "redirect:/";
		
		
	}
}
