package net.datasa.spring3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring3.domain.dto.PersonDTO;
import net.datasa.spring3.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PersonController {
	
	
	private final PersonService ps;
	
	@GetMapping("test")
	public String test() {
		ps.test();
		
		return "redirect:/";
	}
	@GetMapping("insert")
	public String insert(){
		return "insertForm";
	}
	@PostMapping("insert")
	public String insert(
			PersonDTO dto
	) {
		log.debug("전달된 데이터: {}",dto);
		
		ps.insert(dto);
		
		return "redirect:/";
	}
	
	@GetMapping("select")
	public String select(){
		return "selectForm";
	}
	@PostMapping("select")
	public String select(
			@RequestParam("id") String id,
			Model model
	){
		log.debug("조회할 아이디: {}",id);
		
		PersonDTO dto = ps.select(id);
		model.addAttribute("id",id);
		model.addAttribute("person", dto);
		
		
		return "select";
	}
	/*
		삭제 페이지로 이동
	 */
	
	@GetMapping("delete")
	public String delete(){
		return "deleteForm";
	}
	/*
		삭제처리 요청
		@param id 입력한 아이디
		@return 삭제 결과 페이지로 이동
		
	 */
	@PostMapping("delete")
	public String delete(@RequestParam("id") String id, Model model){
		
		log.debug("삭제할 아이디: {}", id);
		boolean result =true;
		
		try {
		
		ps.delete(id);
		} catch (Exception e) {
			result = false;
			log.debug("삭제 실패", e.getMessage());
		} finally {
			model.addAttribute("id", id);
			model.addAttribute("result", result);
		}
		
		return  "delete";
	}
	/*
		전체 정보 목록 조회
		@return 결과 출력화면으로 이동
	 */
	@GetMapping("selectAll")
	public String selectAll(Model model){
		log.debug("전체 목록 조회");
		
		List<PersonDTO> personList = ps.selectAll();
		model.addAttribute("personList", personList);
		
		return "selectAll";
	}
	@GetMapping("selectAll2")
	public String selectAll2(Model model){
		log.debug("전체 목록 조회");
		
		List<PersonDTO> personList = ps.selectAll();
		model.addAttribute("personList", personList);
		
		return "selectAll2";
	}
	/*
		회원 정보 상세보기
		@param id
		@param model
		@return 상세보기 페이지 이동
		
	 */
	@GetMapping("view")
	public String view(@RequestParam("id") String id, Model model){
		log.debug("조회할 아이디: {}", id);
		
		PersonDTO dto = null;
		try {
			dto = ps.select(id);
			log.debug("[조회 성공] {}", dto);
		} catch (Exception e) {
			log.debug("[조회ㅣ 실패] {}", e.getMessage());
		} finally {
			model.addAttribute("id",id);
			model.addAttribute("person", dto);
		}
		return "select";
	}
	
	/*
		URL 경로 자체에 포함된 값을 파라미터로 받아오는 방식
			@RequestParam 		/member?id=abc		<- 쿼리스트링
			@PathVariable		/member/abc			<경로 변수
	 */
	@GetMapping("info" + "/{id}")
	public String info(
			@PathVariable(name= "id", required = false) String id,
			Model model
	) {
		log.debug("조회할 아이디: {}",id);
		
		PersonDTO dto = null;
		try {
			dto = ps.select(id);
			log.debug("[조회 성공] {}", dto);
		} catch (Exception e) {
			log.debug("[조회ㅣ 실패] {}", e.getMessage());
		} finally {
			model.addAttribute("id",id);
			model.addAttribute("person", dto);
		}
		return "select";
	}
	@GetMapping("deleteUser")
			public String deleteuser(@RequestParam("id") String id, Model model) {
		log.debug("삭제할 아이디: {}", id);
		boolean result = true;
		
		try {
			
			ps.delete(id);
			log.debug("[삭제성공]");
		} catch (Exception e) {
			result = false;
			log.debug("[삭제 실패]", e.getMessage());
		} finally {
			model.addAttribute("id", id);
			model.addAttribute("result", result);
		}
		
		return "redirect:selectAll2";
	}
	@GetMapping("update")
	public String update(@RequestParam("id") String id, Model model){
		log.debug("수정할 아이디 {}", id);
		
		PersonDTO dto = null;
		try {
			dto = ps.select(id);
			log.debug("[조회 성공] {}", dto);
			model.addAttribute("person", dto);
		} catch (Exception e){
			model.addAttribute("id", id);
			log.debug("[조회 실패] {}", e.getMessage());
		}
		
		return "updateForm";
	}
	@PostMapping("update")
	public String update(PersonDTO dto){
		log.debug("수정할 데이터: {}", dto);
		
		try {
			ps.update(dto);
			log.debug("수정성공");
		} catch (Exception e){
			log.debug("수정 실패 {}", e.getMessage());
		}
		return "redirect:view?id=" + dto.getId();
	}
	
}
