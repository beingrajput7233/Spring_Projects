package com.jsr.springcoredemo.config;

import com.jsr.springcoredemo.Coach;
import com.jsr.springcoredemo.TennisCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach tennisCoach(){
        // the name of the function is same as bean id---->start from small letter
        return new TennisCoach();
    }
}
