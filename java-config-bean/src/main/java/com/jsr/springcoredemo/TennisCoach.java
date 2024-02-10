package com.jsr.springcoredemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// NOT USING COMPONENT ANNOTATION
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "Play Tennis Daily";
    }
}
