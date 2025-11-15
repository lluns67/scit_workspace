package net.datasa.spring2.controller;

import lombok.extern.slf4j.Slf4j;
import net.datasa.spring2.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("param")
public class ParamController {
	
	
	@GetMapping("view1")
	public String view1() {
		return "paramView/view1";
	}
	
	/*
		@RequestParam ?
		HTTP 요청 파라미터를 자바 변수로 받아오는 Annotation
		ex.
			http://localhost:9992/param?id=abc&name=aaa
			key			value
			id			abc
			name		aaa
			이 두 값을 컨트롤러 메서드의 매개변수로 자동 매핑
			
		속성		기능
		name		요청 파라미터와 메서드의파라미터를 매핑
		defaultValue 요청 파라미터로부터 value값이 없으면 default 설정
		required	요청 파라미터로부터 해당key값이 엀으면 에러 발생
	 */
	@GetMapping("input1")
	public String input1(
			@RequestParam(name = "id") String id,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			@RequestParam("com") String com
	
	
	) {
		log.debug("전달된 값: ID:{}, PW:{}, 이름:{}, 전화:{}, 통신:{}",
				id, password, name, phone, com);
		
		return "redirect:/";
	}
	
	
	@GetMapping("view2")
	public String view2() {
		return "paramView/view2";
	}
	
	/*
		Get:
			데이터를 URL 쿼리스트링으로 전송
			주소 표시줄에 사용자가 입력한 내용이 그대로 노출되기 때문에
			주로 데이터를 조회할 때 사용,
			최대 4096byte 까지의 데이터 전송 가능
			주로 조회, 검색, 읽기, 페이지 이동 등..
		Post:
			HTTP 메시지의 본문(body)에 데이터를 포함시켜 전송
			입력 내용의 길이 제한이 없으며, 입력값이 주소창에  노출되지 안ㄶ음.
			주로 서버의 상태를 변경하는 요청(쓰기, 등록, 수정, 삭제)에 사용
			로그인, 폼 데이터 제출, 파일 업로드, DB 갱신 등..
		
	 */
	@PostMapping("input2")
	public String input2(
			@RequestParam(name = "id") String id,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			@RequestParam("com") String com
	
	
	) {
		log.debug("전달된 값: ID:{}, PW:{}, 이름:{}, 전화:{}, 통신:{}",
				id, password, name, phone, com);
		
		return "redirect:/";
	}
	
	@GetMapping("view3")
	public String view3(){
		return "paramView/view3";
	}
	
	
	@PostMapping("input3")
	public String input3(Person p){
		
		log.debug("전달된 객체: {}", p);
		
		return "redirect:/";
	}
	
	@GetMapping("input4")
	public String input4(
			@RequestParam(name = "name", defaultValue = "기본값")
				String name,
			@RequestParam(name = "age", defaultValue = "0")
				int age
	){
		log.debug("name: {}, age: {}", name, age);
		return "redirect:/";
	}
	
	
	/*
		Model: 컨트롤러에서 뷰(JSP,  Thymeleaf 등)로 데이터를
				넘겨주는데 사용되는 데이터 전달객체
				controller에서 html로 넘어가는 순간만 유효한 1회성 객체구조
				(Spring은 Model 객체를 요청단위로 유지함)
				redirect:/ 등의 재요청에는 저장된 데이터가 없어짐
	 */
	@GetMapping("model")
	public String model(Model model){
		
		String str = "문자열";
		int num = 100;
		Person person = new Person
				("abc","홍길동","123","11111","kt");
		
		model.addAttribute("str", str);
		model.addAttribute("num", num);
		model.addAttribute("person", person);
		
		return "paramView/model";
		
		
		
	}
	
}