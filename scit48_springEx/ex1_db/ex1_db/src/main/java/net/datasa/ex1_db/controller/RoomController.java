package net.datasa.ex1_db.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class RoomController {
	
	@GetMapping("room")
	public String room(){
		return "room/1";
	}
	@GetMapping("2")
	public String room2(){
		return "room/2";
	}
	@GetMapping("3")
	public String room3(){
		return "room/3";
	}
}
