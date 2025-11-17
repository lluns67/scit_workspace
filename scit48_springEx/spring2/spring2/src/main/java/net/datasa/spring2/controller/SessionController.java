package net.datasa.spring2.controller;


import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("ss")
public class SessionController {
	
	//세샨에 값 저장
	@GetMapping("session1")
	public String session1(HttpSession session){
		
		session.setAttribute("name", "홍길동");
		
		return "redirect:/";
	}
	
	// 세션 값 일기
	@GetMapping("session2")
	public String session2(HttpSession session) {
		
		String name = (String) session.getAttribute("name");
		log.debug("세션 값: {}", name);
		
		return "redirect:/";
	}
	@GetMapping("session3")
	public String session3(HttpSession session){
		session.removeAttribute("name");
		session.invalidate();
			
			return "redirect:/";
		}
		
	@GetMapping("login")
	public String login(){
		log.debug("로그인페이지 이동");
		return "ssView/loginForm";
	}
	
	//로그인 처리 post라서 가능
	@PostMapping("login")
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
	@GetMapping("loginTest")
	public String loginTest(HttpSession session){
		
		//현재 세션에 loginId 하는 이름의 값이 존재하는지 읽어오기
		
		//조건문 비교( 그 값이 abc 같은지)
		// 같으면 loginTest.html 로 이동
		// 없거나 일치하지 않으면 loginForm.html 로 이동
		
		String id = (String) session.getAttribute("loginId");
		
		if (id == null || !id.equals("abc")){
			return "redirect:/ss/login";
		} else return "ssView/loginTest";
	}
	
}
