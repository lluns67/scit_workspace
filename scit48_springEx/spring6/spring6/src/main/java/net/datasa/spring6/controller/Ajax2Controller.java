package net.datasa.spring6.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring6.domain.dto.PersonDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class Ajax2Controller {
	
	@GetMapping("ajax2")
	public String ajax2(){
		return "ajax2";
	}
	@ResponseBody
	@PostMapping("insert1")
	public void insert1(
			@RequestParam("name") String name,
			@RequestParam("age") String age,
			@RequestParam("phone") String phone
	){
		log.debug("insert1(): name={}, age={}, phone={}",name,age,phone);
	}
	
	@ResponseBody
	@PostMapping("insert2")
	public void insert2(PersonDTO person){
		log.debug("inser2() : {}",person);
	}
	@ResponseBody
	@PostMapping("insert3")
	public void insert3(PersonDTO person){
		log.debug("insert3() : {}", person);
	}
	
	@ResponseBody
	@GetMapping("getObject")
	public PersonDTO getObject(){
		PersonDTO person =
				new PersonDTO("홍길동", 20, "010-1111-2222");
		return person;
	}
	@ResponseBody
	@GetMapping("getList")
	public List<PersonDTO> getlist(){
		
		List<PersonDTO> list = new ArrayList<>();
		list.add(new PersonDTO("홍길동", 30, "010-1111-2222"));
		list.add(new PersonDTO("홍길동", 30, "010-1111-2222"));
		list.add(new PersonDTO("홍길동2", 30, "010-1111-2222"));
		return list;
	}
	
	@ResponseBody
	@PostMapping("getJson")
	public String getJson(
			@RequestBody String personList
	) throws Exception {
		log.debug("전달받은 문자열: {}", personList);
		
		ObjectMapper om = new ObjectMapper();
		List<PersonDTO> list = om.readValue(personList, new TypeReference<List<PersonDTO>>() {
		});
		for (PersonDTO p : list){
			log.debug("list: {}", p);
		}
		
		// Java -> JSON				writeValueAssString
		List<PersonDTO> plist = new ArrayList<>();
		plist.add(new PersonDTO("홍길동", 20, "1111"));
		plist.add(new PersonDTO("이순신", 30, "1111"));
		plist.add(new PersonDTO("홍길동2", 40, "1111"));
		String jsonString  = om.writeValueAsString(plist);
		return jsonString;
	}
}
