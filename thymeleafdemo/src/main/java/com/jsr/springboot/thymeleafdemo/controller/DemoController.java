package com.jsr.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    // create mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate",new java.util.Date());

        // helloworld is the name of template
        // springboot will search automatically for helloworld template in
        // src/main/resources/templates/helloworld.html
        return "helloworld";
    }


}
