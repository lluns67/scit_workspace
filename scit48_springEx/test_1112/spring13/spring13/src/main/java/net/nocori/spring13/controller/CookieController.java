package net.nocori.spring13.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CookieValue;

@Controller
@Slf4j
public class CookieController {

    @GetMapping("ck/cookie1")
    public String cookie1(HttpServletResponse response){

        // 쿠키 생성 (이름. 값)
        Cookie c1 = new Cookie("str", "제임스");
        Cookie c2 = new Cookie("num", "1233");

        c1.setMaxAge(50);

        c1.setPath("/");
        c2.setPath("/");

        response.addCookie(c1);
        response.addCookie(c2);

        return "redirect:/";
    }
    @GetMapping("ck/cookie2")
    public String cookie2(HttpServletResponse response){
        Cookie c1 = new Cookie("str",null);
        Cookie c2 = new Cookie("num",null);

        c1.setMaxAge(0);
        c2.setMaxAge(0);
        c1.setPath("/");
        c2.setPath("/");

        response.addCookie(c1);
        response.addCookie(c2);

        return "redirect:/";
    }
    @GetMapping("ck/cookie3")
    public String cookie3(
            @CookieValue(name = "str", defaultValue = "없음") String str,
            @CookieValue(name = "num", defaultValue = "0") int num
    ){
        log.debug("쿠키 {}, {}",str,num);

        return "redirect:/";
    }
}
