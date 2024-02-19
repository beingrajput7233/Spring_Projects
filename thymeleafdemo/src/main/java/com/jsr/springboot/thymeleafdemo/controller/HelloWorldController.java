package com.jsr.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // controller method to show initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form.html";
    }

    //controller method to process the form
    @RequestMapping("/processForm")
    public String processForm(){
        return "responseform";
    }

}
