package com.jsr.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //inject properties for coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return coachName+teamName;
    }






    // expose "/" that return "hello world"
//    yha path btate hh basically
    @GetMapping("/")
    public String func() {
        return "Hello World ggg";
    }

    @GetMapping("/workout")
    public String func2(){
        return "Jay Shree Ram Ji";
    }
}
