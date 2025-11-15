package net.datasa.spring2.controller;

import lombok.extern.slf4j.Slf4j;
import net.datasa.spring2.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Log 사용 가능
@Slf4j
@Controller
public class LombokController {
	
		@GetMapping("lom/logger")
		public String logger() {
			
			log.error("error 출력");
			log.warn("warn 출력");
			log.info("info 출력");
			log.debug("debug 출력");
			log.trace("trace 출력");
			
			String str = "문자열";
			log.debug("값 확인 로그: {}", str);

//			this.id = id;
//			this.password = name;
//			....
//
//
		return "redirect:/";
		}
	
	@GetMapping("lom/lombok")
	public String lombok() {
		
		Person p = new Person();
		p.setId("aaa");
		p.setName("홍길동");
		System.out.println(p.getId());
		System.out.println(p.getPassword());
		System.out.println(p);
		
		Person p2 = new Person("abc", "123", "홍길동", "010-1111-1111", "KT");
		
		System.out.println(p2);
		
		Person p3 = Person.builder()
				.id("aaa")
				.name("홍길동")
				.password("123")
				.build();
		System.out.println(p3);
		return "redirect:/";
	}
}


