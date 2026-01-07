package net.datasa.spring6.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class AjaxController {
	/**
	 * 	테스트 페이지1로 이동
	 */
	@GetMapping("ajax1")
	public String ajax1(){
		return "ajax1";
	}
	
	/**
	 *  Ajax 요청에 대한 응답 1
	 */
	// 리턴값을 화면(HTML)로 보내지 말고, HTTP 응답 데이터로 그대로 보내달라
	@ResponseBody
	@GetMapping("ajaxText1")
	public void ajaxText1(){
		log.debug("AjaxController의 ajaxText1() 실행");
	}
	@ResponseBody
	@PostMapping("ajaxText2")
	public void ajaxText2(@RequestParam("str") String str){
		log.debug("AjaxContoller의 ajaxText2()에서 출력 {}",str);
		throw new RuntimeException("서버에서 실행 중 예외 발생");
	}
	
	/**
	 *  Ajax 요청에 대한 응답 3
	 */
	@GetMapping("ajaxTest3")
	@ResponseBody
	public String ajaxTest3(){
		String msg = "서버에서 보내는 메시지";
		log.debug("AjaxController의 ajaxTest3()에서 보냄: {}", msg);
		return msg;
	}
	
	@ResponseBody
	@PostMapping("ajaxTest4")
	public int ajaxTest4(
		@RequestParam("num1") int a,
		@RequestParam("num2") int b
	){
		log.debug("ajaxTest4 전달받은 값:  num1= {}, num2={}", a, b);
		int sum = a + b;
		return sum;
	}
	
	/**
	 *
	 * @param a
	 * @param b
	 * @return
	 * ResponseEntity : 응답객체(상태 코드, 헤더, 바디)를 사용자가 직접 만들어서 제어하는 객체
	 */
	@PostMapping("ajaxTest5")
	public ResponseEntity<?> ajaxTest5(
			@RequestParam("num4") String a,
			@RequestParam("num5") String b
	){
		log.debug("ajaxTest5에서 전달받은 값: num4={}, num5={}}",a,b);
		
		try {
			int n1 = Integer.parseInt(a);
			int n2 = Integer.parseInt(b);
			int n3 = n1 / n2;
			
			return ResponseEntity.ok(n3);
		} catch (NumberFormatException e){
			e.printStackTrace();
			return ResponseEntity.badRequest().body("함수가 아닙니다.");
		} catch (NullPointerException e) {
			return ResponseEntity.status(500).body("서버 오류");
		}
	}
	@PostMapping("ajaxTest6")
	public ResponseEntity<?> ajaxTest6(
			@RequestParam("num7") String a,
			@RequestParam("num8") String b,
			@RequestParam("op") String op
	){
		log.debug("ajaxTest6 전달받은 값: num7={}, num8={}, op={}", a,b,op);
		
		try {
			int n1 = Integer.parseInt(a);
			int n2 = Integer.parseInt(b);
			int result = 0;
			
			switch (op){
				case "+" -> result = n1 + n2;
				case "-" -> result = n1 - n2;
				case "/" -> result = n1 / n2;
				case "*" -> result = n1 * n2;
				default -> {return  ResponseEntity
						.badRequest().body("연산자를 확인해주세요");}
			}
			return ResponseEntity.ok(result);
		} catch (NumberFormatException e){
			return ResponseEntity.badRequest().body("함수가 아닙니다.");
		} catch (ArithmeticException e){
			return ResponseEntity.badRequest().body("0으로 나눌 수 없습니다.");
		}
	}
}
