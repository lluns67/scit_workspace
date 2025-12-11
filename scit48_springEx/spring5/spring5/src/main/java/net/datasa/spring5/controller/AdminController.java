package net.datasa.spring5.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring5.domain.dto.MemberDTO;
import net.datasa.spring5.service.MemberService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * 	관리자 Controller
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
	
	private final MemberService ms;
	
	@GetMapping("page")
	public String admin() { return "adminView/adminPage";}
	
	/**
	 * 회원목록을 볼 수 있는 페이지로 이동
	 * @param model
	 * @return
	 */
	@GetMapping("list")
	public String list(Model model){
		
		List<MemberDTO> memberlist = ms.selectAll();
		model.addAttribute("memberList", memberlist);
		
		return "adminView/memberList";
	}
	@GetMapping("update")
	public String update(
			@RequestParam("id") String memberId
	){
		try {
			ms.update(memberId);
			log.debug("권한 변경 성공!");
		} catch (Exception e){
			log.debug("[예외 발생] {}", e.getMessage());
		}
		return "redirect:/admin/list";
	}
	@GetMapping("updateEnabled")
	public String enabled(String id, boolean enabled){
		log.debug("Enabled 받은 값 {}, {}",id, enabled);
		try {
			ms.enabled(id, !enabled);
			log.debug("권한 변경 성공!");
		} catch (Exception e){
			log.debug("[예외 발생] {}", e.getMessage());
		}
		return "redirect:/admin/list";
	}
}
