package net.nocori.spring13.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class LocalController {

    @GetMapping("local/save")
    public String save(){
        return "localView/save";
    }
    @GetMapping("local/output")
    public String output(){
        return "localView/output";
    }
    @GetMapping("local/delete")
    public String delete(){
        return "localView/delete";
    }
}
