package net.datasa.spring2.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("local")
public class LocalController {
	
	//localStorage, sessionStorage 에 값 저장하는 페이지
	@GetMapping("save")
	public String save(){
		return "localView/save";
	}
	@GetMapping("output")
	public String output(){
		return "localView/output";
		
	}
	@GetMapping("delete")
	public String delete(){
		return "localView/delete";
	}
}
