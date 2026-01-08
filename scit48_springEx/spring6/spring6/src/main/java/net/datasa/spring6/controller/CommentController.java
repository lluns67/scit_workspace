package net.datasa.spring6.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class CommentController {
	@GetMapping("board/comment")
	public String comment() {
		return "comment";
	}
}
