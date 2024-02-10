package com.jsr.springcoredemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Play Cricket daily";
    }


}
