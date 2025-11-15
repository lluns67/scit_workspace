package net.datasa.spring1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {
	
	@GetMapping("image")
	public String image(){
		
		System.out.println("이밎암즞");
	
		return "image";
	}
	
	//상대,절대 주소 비교하려고
	@GetMapping("sub/image")
	public String image2(){
		return "image";
	}
	@GetMapping("css")
	public String css(){
		return "css";
	}
	
	
	// home.html 에서 a태그의 href="js" <- 이 요청을 매핑
	@GetMapping("js")
	public String js(){
		// templates 폴더로부터 js 라고 하는 html을 찾겠다.
		return "js";
	}
	
	@GetMapping("path")
	public String path(){
		return "path";
	}
	@GetMapping("sub/path")
	public String sub(){
		return "sub/path2";
	}
}
