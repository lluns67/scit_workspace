package net.nocori.spring13.controller;


import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j

public class sessionController {
	
	@GetMapping("ss/session1")
	public String session1(HttpSession session){
		session.setAttribute("name", "홍짜장");
		
		return "redirect:/";
	}
	@GetMapping("ss/session2")
	public String session2(HttpSession session){
		
		String name = (String) session.getAttribute("name");
		log.debug("세션 {}", name);
		return "redirect:/";
	}
	@GetMapping("ss/session3")
	public  String session3(HttpSession session){
		session.removeAttribute("name");
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("ss/login")
	public String login(){
		return "ssView/loginForm";
	}
	@PostMapping("ss/login")
	public String login(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			HttpSession session
	){
		log.debug("사용자가 입력한 값= id:{}, pw:{}",id,pw);
		
		// ID가 "abc"이고 , 비밀번호가 "123"인 경우에만로그인 처리
		if (id.equals("abc") && pw.equals("123")){
			session.setAttribute("loginId",id);
			log.debug("{}님 로그인", id);
			return "redirect:/";
		} else {
			log.debug("로그인 실패...");
			return "ssView/loginForm";
		}
	}
	@GetMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("loginId");
		session.invalidate();
		return "redirect:/";
	}
	// 로그인해야 볼 수 있는 페이지 이동
	@GetMapping("ss/loginTest")
	public String loginTest(HttpSession session){
		String id = (String) session.getAttribute("loginId");
		
		if (id == null || !id.equals("abc")){
			return "redirect:/ss/login";
		} else return "ssView/loginTest";
	}
}
