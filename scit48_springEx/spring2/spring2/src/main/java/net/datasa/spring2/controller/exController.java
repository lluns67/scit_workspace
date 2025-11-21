package net.datasa.spring2.controller;


//		[연습문제 1]
//		1. home.html에서 ex/calc1 경로 요청을 처리할 메서드 생성
//        2. calcForm.html 입려 폼을 출력
//		(입력란 2개, select1, submit버튼 1개)
//        3. 숫자 2개를 입력=하고 여산자(사치연산자)를 선택한 후 submit 클릭
//        4. 숫자가아닌 값을 입력하면 js에서 유효성검ㅅ사 후 오류메시지 출력
//        5. 숫자 2개, 연산자를 정상적으로 입력 및 선택 했다면 선버로 전송
//        6.컨트롤러에서 ㄱ값을 전달받아 계산
//        7.계산한 결괄르 model에 전장하고 calcOutput.html로 이동
//        8.화면에 계산한 결과 출력

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring2.domain.Calc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@Slf4j
public class exController {
	
	@GetMapping("ex/calc1")
	public String calc1(){
		
		
		return "exView/calcForm";
		
	}
	
	/*
		연산 처리 및 결과하면 이동
		@param cal
		@param model
		@return 연산결과를출력하는 html
	
	 */
	
	@PostMapping("ex/calc1")
	public String calcOutput(
		@ModelAttribute Calc cal,
		Model model
		){
		log.debug("param: {}", cal);
		
		int res = 0, n1, n2;
		
		try {
			switch (cal.getOp()){
				case "+": res = cal.getNum1() + cal.getNum2(); break;
				case "-": res = cal.getNum1() - cal.getNum2(); break;
				case "*": res = cal.getNum1() * cal.getNum2(); break;
				case "/": res = cal.getNum1() / cal.getNum2(); break;
				default: throw new Exception("연사자 선택 오류");
			}
			model.addAttribute("calc", cal);
			model.addAttribute("res", res);
		} catch (Exception e){
			log.debug("[예외 발생] 원인: {}", e.getMessage());
			return "exView/calcForm";
		}
		return "exView/CalcOutput";
	}
	
	/*
		[연습문줴 2]
		개인정보 입력폼으로 이동
	 */
	
	@GetMapping("ex/info")
	public String info(){
		return "exView/info";
	}
	@PostMapping("ex/info")
	public String infoOutput(
			@RequestParam("name") String name,
			@RequestParam("ssn") String ssn,
			Model model
			){
		log.debug("전달된 값: {}, {}",name,ssn);
		
		model.addAttribute("name", name);
		model.addAttribute("ssn", ssn);
		
		// 기본 검증
		if (ssn == null || ssn.length() != 14 || ssn.charAt(6) != '-'){
			model.addAttribute("error", "error");
			return "exView/info";
		}
		
		try {
			String ssnYear = ssn.substring(0,2);
			int month = Integer.parseInt(ssn.substring(2,4));
			int day =  Integer.parseInt(ssn.substring(4,6));
			char genderCode = ssn.charAt(7);
			
			String gender = (genderCode == '1' || genderCode == '3')
							? "남자" : "여자";
			
			int yearPrepix = (genderCode == '1' || genderCode == '2'
								? 1900 : 2000	);
			int year = yearPrepix + Integer.parseInt(ssnYear);
			
			int thsYear = LocalDate.now().getYear();
			int age = thsYear - year;
			
			// 포멧
			String birth = String.format("""
					%d년 %d월 %d일
					""", year, month,day);
			model.addAttribute("y", year);
			model.addAttribute("m", month);
			model.addAttribute("d", day);
			model.addAttribute("age", age);
			model.addAttribute("gender", gender);
			model.addAttribute("birth", birth);
			
			return "exView/infoOutput";
		} catch (Exception e){
			model.addAttribute("error", "error");
			return  "exView/info";
		}
	}
	/*
		[연습문제 3]
		방문회수 카운트예제
			1. 방문횟수가  저장된 쿠키를 읽어온다.
			2. 없으면 방문횟수는 현재 0으로 처리
			3. 있으면 쿠키에 저장된 숫자가 기존 방문회수
			4. 방문횟수에 1을 더한다
			5. 쿠킹에 증가된 방문횟수를 저장하여 클라이언트로 전송
			6. 방문횟수를 model에 저장하여 html 페이지에서 출력
	 */
	@GetMapping("ex/count")
	public String count(
			@CookieValue(name = "count", defaultValue = "0")
			//스프링이 자동으로 int 매핑 해줌
			int count,
			HttpServletResponse response,
			Model model
	) {
		count++;
		model.addAttribute("count", count);
		
		Cookie cookie = new Cookie("count",  Integer.toString(count));
		
		cookie.setMaxAge(60*60*24*3);
		cookie.setPath("/ex/count");
		response.addCookie(cookie);
	
		
		
		return "exView/count";
	}
	@GetMapping("ex/darkmode")
	public String darkmode(){
		return "exView/darkmode";
	}
	/*
		[연습문제 5]
		임시 저장
	 */
	@GetMapping("ex/temp")
	public String temp(){
		return "exView/temp";
	}
}

//Info info,
//Model model
//		){
//
////		String ssn = info.getSsn();
////		String birthdate = String.format("%s년 %s월 %s일", ssn[]);
//
