package net.datasa.spring6.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring6.domain.dto.MemberDTO;
import net.datasa.spring6.service.ExService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ExController {
	private final ExService exService;
	@GetMapping("posts/like")
	public String like(Model model){
		
		return "like";
	}
	
	@ResponseBody
	@GetMapping("posts/{num}/like")
	public int readLike(@PathVariable("num") Integer num){
		int cnt = exService.readLike(num);
		return cnt;
	}
	@ResponseBody
	@PostMapping("posts/{num}/like")
	public int likePlus(@PathVariable("num") Integer num){
		int cnt = exService.readPlus(num);
		return cnt;
	}
	@GetMapping("joinForm")
	public String joinForm(){
		return "joinForm";
	}
	@GetMapping("idCheck/{id}")
	@ResponseBody
	public Boolean idCheck(@PathVariable("id") String id){
		log.debug("입력하려는 id {}",id);
		Boolean msg = exService.idCheck(id);
		return msg;
	}
	@PostMapping("submit")
	@ResponseBody
	public String submit(@RequestBody MemberDTO dto){
		log.debug("회원가입할 때 넘어온 값 {}",dto);
		try{
			exService.join(dto);
			return "회원가입 성공";
		} catch (Exception e){
			return "알 수 없수는 에러가 발생하였습니다.";
		}
	}
}
