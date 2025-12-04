package net.datasa.spring4.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring4.domain.dto.GuestBookDTO;
import net.datasa.spring4.service.GuestBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	/*
		RedirectAttributes : redirect 후에도 임시로 저장될 데이터객체
	 */
	@PostMapping("delete")
	public String delete(Integer num, String password, RedirectAttributes rs){
		log.debug("delete - num : {}, pw : {}",num,password);
		try {
			gs.delete(num, password);
		} catch (Exception e){
			log.debug("글 삭제 실패.. {}", e.getMessage());
			rs.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:list";
	}
	@GetMapping("update")
	public String update(@RequestParam("num") Integer num, @RequestParam("password") String password
						, RedirectAttributes rs,Model model){
		log.debug("수정하기 글번호 {}, 비번 {}",num,password);
		try {
			gs.passwordCheck(num, password);
			GuestBookDTO dto = gs.selectGuestbook(num);
			
			model.addAttribute("guestbook", dto);
			log.debug("글 수정 폼으로 이동");
		} catch (Exception e){
			log.debug("글 수정 실패.. {}", e.getMessage());
			rs.addFlashAttribute("msg", e.getMessage());
			return "redirect:list";
		}
		return "updateForm";
	}
	@PostMapping("update")
	public  String update(GuestBookDTO dto){
		
		log.debug("수정할 정보: {}", dto);
		try {
			gs.update(dto);
			log.debug("글 수정 성공");
		} catch (Exception e) {
			log.debug("글 수정 실패.. {}", e.getMessage());
		}
		return "redirect:list";
	}
	@PostMapping("recommend")
	public String recommend(
			@RequestParam("num") Integer num,
			HttpServletRequest request,
			RedirectAttributes ra

			
	){
		String clientIp = request.getRemoteAddr();
		
		try{
			gs.recommend(num, clientIp);
			ra.addFlashAttribute("msg", "추천되었습니다.");
			
		} catch (Exception e) {
			ra.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:/list";
	}
}
