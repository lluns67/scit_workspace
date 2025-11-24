package net.datasa.spring3.controller;


import lombok.extern.slf4j.Slf4j;
import net.datasa.spring3.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Controller
@Slf4j
public class Homecontroller {
	
	@Qualifier("impl2")
	@Autowired
	TestService ts;
	
	@GetMapping({"", "/"})
	public String home() {
		ts.testLog();
		return "home";
	}
	
	/*
		Optional<T>
		- null 값으로 인한 NullPointerException(NPE)를 방지하기위한 클래스
		"값이 있을 수도, 없을 수도 있음"을 명시적으로 표현해주는 클래스
		- null을직접 사용하는 것보다 안정적이고 가독성이 높음.
	 */
	@GetMapping("optional")
	public String optional(){
		
		//1. null을 그대로 사욯하는 경우
		// null 체크를 직접 해줘야 하며, 체크하지 않을 시 NPE 발생
		String name = null;
		if(name != null) {
			log.debug("이름: {}", name.toUpperCase());
		} else {
			log.debug("이름이 없습니다.");
		}
		
		//2. optional을사요한느 경우
		String name2 = null;
		Optional<String> opt = Optional.ofNullable(name2);
		String result = opt.orElse("이름이 없습니다.");
		log.debug("결과: {}", result);
		opt.ifPresent(res -> log.debug("결과: {}", res));
		
		// 3.JPA  사용 예시
		Map<String,  String> database = new HashMap<>();
		database.put("hong", "gildong");
		database.put("kim", "cheolsoo");
		
		// 존재하는 키 조회
		Optional<String> data1 = Optional.ofNullable(database.get("hong"));
		log.debug("데이터가 존재할 경우: {}", data1.orElse("데이터 없음"));
		
		// 존재하지 않는 키 조회
		Optional<String> data2 = Optional.ofNullable(database.get("lee"));
		log.debug("데이터가 존재하지 않는 경우: {}", data2.orElse("데이터 업음"));
		
		//값이 없으면 예외 던지기
		try {
			String data3 = Optional.ofNullable(database.get("kim"))
					.orElseThrow(()-> new RuntimeException("데이터 없음"));
			log.debug("orElseThrow 패턴: {}", data3);
			
			String data4 = Optional.ofNullable(database.get("lee"))
					.orElseThrow(new Supplier<RuntimeException>(){
						@Override
						public RuntimeException get(){
							return new RuntimeException("데이터 없음");
						}
					});
		} catch (Exception e){
			log.debug("[예외 발생] {}", e.getMessage());
			
		}
		
		return "redirect:/";
	}
}
