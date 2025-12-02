package net.datasa.spring4.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring4.domain.dto.GuestBookDTO;
import net.datasa.spring4.service.GuestBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
		log.debug("작성한 글 정보 {}",dto);
		
		gs.write(dto);
		
		return "redirect:list";
	}
	@GetMapping("list")
	public String lsit(Model model){
		
		List<GuestBookDTO> dtoList = gs.getList();
		model.addAttribute("guestbooklist",dtoList);
		log.debug(" >> 글 목록: {}",dtoList);
		return "list";
	}
	@PostMapping("delete")
	public String delete(Integer num, String password){
		log.debug("글번호, 비번 {} {}",num,password);
		gs.delete(num, password);
		
		return "redirect:list";
	}
	
}
