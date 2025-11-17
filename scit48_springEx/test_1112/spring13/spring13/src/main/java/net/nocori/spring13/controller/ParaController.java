package net.nocori.spring13.controller;


import lombok.extern.slf4j.Slf4j;
import net.nocori.spring13.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("param")
@Controller
public class ParaController {
	
	@GetMapping("view1")
	public String view1(){
		return "ParaView/view1";
	}
	
	@GetMapping("input1")
	public String input1(){
		
		
		
		return "redirect:/";
	}
	
	@GetMapping("view2")
	public String view2(){
		return "Paraview/view2";
	}
	
	@PostMapping("input2")
	public String input2(
		@RequestParam("id") String id,
		@RequestParam("password")  String password,
		@RequestParam("name") String name,
		@RequestParam("phone") String phone,
		@RequestParam("com") String com
		){
		
		log.debug("id = {}, pass = {}, name= {}, phone= {}, com= {}",
				id,password,name,phone,com);
		
		log.info(" 이것은 인포입니다 id = {}, pass = {}, name= {}, phone= {}, com= {}",
				id,password,name,phone,com);
		log.trace(" 이것은 트레이스입니다 id = {}, pass = {}, name= {}, phone= {}, com= {}",
				id,password,name,phone,com);
		return "redirect:/";
	}
	
	@GetMapping("view3")
	public String view3(){
		return "Paraview/view3";
	}
	
	@PostMapping("input3")
	public String input3(Person p){
		
		log.debug("전달된 객체{}",p);
		
		return "redirect:/";
	}
	
	@GetMapping("info4")
	public String input4(
			@RequestParam(name = "name", defaultValue = "루샤오펑")
			String name,
			@RequestParam(name = "id", defaultValue = "biliard")
			String id,
			@RequestParam(name = "age", defaultValue = "110")
			int age
	){
		log.debug("출력할 값 {} {} {}", name, id, age);
		return "redirect:/";
	}
	@GetMapping("model")
	public String model(Model model){
		
		String str = "문자열";
		int num = 9999;
		Person person = new Person(
				"깁갑환", "asdsda", "sdasdasd", "010-2323","kt"
		);
		model.addAttribute("str",str);
		model.addAttribute("num",num);
		model.addAttribute("person",person);
		
		return "ParaView/model";

        //테스트
	}
}
