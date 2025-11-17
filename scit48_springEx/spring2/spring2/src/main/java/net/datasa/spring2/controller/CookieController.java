package net.datasa.spring2.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("ck")

public class CookieController {
	
	@GetMapping("cookie1")
	public String cookie1(HttpServletResponse response){
		
		// 쿠키 생성 (이름, 값)
		Cookie c1 = new Cookie("str", "abcde");
		Cookie c2 = new Cookie("num", "1233");
		
		// 쿠키 종료 시점 지정
		// 쿠키 수명, setMaxAge(초)는 쿠키의 유효기간을 초 단위로 설정
		// 설정이 없으면 브라우저를 닫을때 쿠키가 삭제됨
		c1.setMaxAge(60*60*24);
		c2.setMaxAge(60*60*24);
		
		// 쿠키 경로 설정
		// 해당 도메인의 모든 경로에 대해 브라우저가 자동으로 쿠키를전송ㄷ
		c1.setPath("/");
		c2.setPath("/");
		
		// 클라이언트로 쿠키를 보내기
		response.addCookie(c1);
		response.addCookie(c2);
		
		return "redirect:/";
	}
	
	//쿠키 삭제
	@GetMapping("cookie2")
	public String cookie2(HttpServletResponse response){
		
		Cookie c1 = new Cookie("str",null);
		Cookie c2 = new Cookie("num",null);
		
		c1.setMaxAge(0);
		c2.setMaxAge(0);
		c1.setPath("/");
		c2.setPath("/");
		
		
		response.addCookie(c1);
		response.addCookie(c2);
		
		return "redirect:/";
	}
	
	@GetMapping("cookie3")
	public String cookie3(
			// springd이 적절히 매핑 해줌
			@CookieValue(name = "str", defaultValue = "없음") String str,
			@CookieValue(name = "num", defaultValue = "0") int num
	) {
		log.debug("쿠키 str: {}, num: {}", str, num);
		
		return "redirect:/";
	}
}
