package net.datasa.spring4.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring4.domain.dto.GuestBookDTO;
import net.datasa.spring4.service.GuestBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
//autowired 안써도 됨 요건 생성자 주입
@RequiredArgsConstructor

public class GuestBookController {
	private final GuestBookService gs;
	
	@GetMapping("test")
	public String test(){
		
		gs.test();
		
		return "redirect:/";
	}
	
	//글쓰기 폼으로 이동
	
	@GetMapping("write")
	public String write(){
		return "writeForm";
	}
	@PostMapping("write")
	public String write(GuestBookDTO dto){
		log.debug(dto.toString());
		
		gs.write(dto);
		
		return "redirect:/";
	}
}
