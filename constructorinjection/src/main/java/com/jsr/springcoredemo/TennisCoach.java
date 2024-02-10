package com.jsr.springcoredemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "Play Tennis Daily";
    }
}
