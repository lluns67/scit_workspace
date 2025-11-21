package net.nocori.spring13.controller;

import lombok.extern.slf4j.Slf4j;
import net.nocori.spring13.domain.Calc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Slf4j
@Controller
@RequestMapping("ex")
public class exController {
	
	@GetMapping("calc1")
	public String calc1(){
		return "exView/calc1";
	}
	@PostMapping("calc1")
	public String calcu1(
		 Calc cal,
		Model model
	){
		int res = 0, n1, n2;
		
		try {
			switch (cal.getOp()){
				case "+": res = cal.getNum1() + cal.getNum2(); break;
				case "-": res = cal.getNum1() - cal.getNum2(); break;
				case "*": res = cal.getNum1() * cal.getNum2(); break;
				case "/": res = cal.getNum1() / cal.getNum2(); break;
				default: throw new Exception("연사자 선택 오류");
			}
			model.addAttribute("cal", cal);
			model.addAttribute("res", res);
		} catch (Exception e){
			log.debug("[예외 발생] 원인: {}", e.getMessage());
			return "exView/calcForm";
		}
		return "exView/calcul";
	}
	@GetMapping("info")
	public String info(){
		return "exView/info";
	}
	@PostMapping("info")
	public String infopage(
			String name,
			String ssr,
			Model model
	){
	
		 String birth_a = "";
		 String gender = "";
		log.debug("받아온 값{}, {}",name, ssr);
		if (Integer.parseInt(ssr.substring(7,8)) == 1 ||
				Integer.parseInt(ssr.substring(7,8)) == 2){
			birth_a = "19";
		} else {
			birth_a = "20";
		}
		if (Integer.parseInt(ssr.substring(7,8)) == 1 ||
				Integer.parseInt(ssr.substring(7,8)) == 3){
			 gender = "남자";
		} else {
			gender = "여자";
		}
		String birth_y = birth_a + ssr.substring(0,2);
		int todayyear = LocalDate.now().getYear();
		int age = todayyear - Integer.parseInt(birth_y);
		String birth = String.format("%s년 %s월 %s일",birth_y, ssr.substring(2,4),
				ssr.substring(4,6));
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("birth", birth);
		model.addAttribute("gender", gender);
		
		return "exView/infopage";
	}
	@GetMapping("darkmode")
	private String darkmode(){
		
		return "exView/darkmode";
	}
	@GetMapping("temp")
	private String temp(){
		return "exView/temp";
	}
}
