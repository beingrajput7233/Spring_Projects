package com.jsr.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    //adding data to model
    @RequestMapping("processFormVersionTwo")
    public String func(HttpServletRequest request, Model model){
        String name=request.getParameter("studentName");

        name=name.toUpperCase();

        String result="Yo! "+name;

        model.addAttribute("message",result);

        return "responseform";
    }

}
