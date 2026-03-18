package net.datasa.spring1224.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring1224.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
@Slf4j
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService ms;
	
	@GetMapping("test")
	public String test(){
		ms.test();
		return "redirect:/";
	}
}
