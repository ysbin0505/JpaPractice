package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
  @GetMapping("hello")
  public String hello(Model model){
    model.addAttribute("data", "hello!!!");
      return "hello";   //SpringBoot의 thymeleaf가 알아서 hello.html 찾아줌
  }
}
