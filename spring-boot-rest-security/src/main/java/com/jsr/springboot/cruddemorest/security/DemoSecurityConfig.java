package com.jsr.springboot.cruddemorest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john= User.builder()
                .username("john").password("{noop}test123")
                .roles("Employee").build();

        UserDetails mary= User.builder()
                .username("mary").password("{noop}test123")
                .roles("Employee","Manager").build();

        return new InMemoryUserDetailsManager(john,mary);

        // now spring-boot will not use the user/passwd from app.properties
    }
}
