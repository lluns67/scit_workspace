package net.datasa.spring5.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring5.domain.dto.MemberDTO;
import net.datasa.spring5.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {
	
	private final MemberService ms;
	
	@GetMapping("test")
	public String test() {
		ms.test();
		return "redirect:/";
	}
	/*
		가입 폼으로 이동
		@Return joinForm.html
	 */
	@GetMapping("join")
	public String join(){
		return "memberView/joinForm";
	}
	@PostMapping("join")
	public String join(MemberDTO dto){
		
		ms.join(dto);
		
		return "redirect:/";
	}
	@GetMapping("idCheck")
	public String idCheck(){
		return "memberView/idCheck";
	}
	/*
		아이디 중복확인
		@param searchId
		@param model
		@return idCheck.html
	 */
	@PostMapping("idCheck")
	public String idCheck(@RequestParam(name="searchId") String searchId, Model model){
		log.debug("검색할ID: {}", searchId);
		boolean result = ms.idCheck(searchId);
		
		model.addAttribute("result", result);
		model.addAttribute("searchId", searchId);
		return "/memberView/idCheck";
	}
	/**
	 * 	로그인 폼으로 이동
	 *
	 * @return loginForm.html
	 */
	@GetMapping("loginForm")
	public String loginForm(){
		return "memberView/loginForm";
	}
}
