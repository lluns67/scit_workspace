package net.datasa.spring6.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring6.domain.dto.CommentDTO;
import net.datasa.spring6.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j

// @Controller 와 @reponseBody를 합친 것과 같으
// 클래스 내의 모든 메서드에 @ResponseBody를 붙여줌
@RestController
@RequiredArgsConstructor
@RequestMapping("/board/comment")
public class CommentRestController {
	private final CommentService cs;
	
	@PostMapping("/write")
	public void write(CommentDTO dto){
		log.debug("저장할 댓글 정보: {}", dto);
		cs.write(dto);
	}
	@GetMapping("/list")
	public ResponseEntity<?> list(){
		List<CommentDTO> list = cs.getList();
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("/{num}")
	public void delete(@PathVariable("num") Integer num){
		log.debug("삭제중 {}", num);
		cs.delete(num);
	}
	
	@PatchMapping("/{num}")
	public void update(
			@PathVariable("num") Integer num,
			@RequestBody CommentDTO dto
	){
		log.debug("수정중 {}", num);
		dto.setNum(num);
		cs.update(dto);
	}
	
}
