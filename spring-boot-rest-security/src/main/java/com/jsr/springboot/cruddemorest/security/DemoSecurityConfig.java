package com.jsr.springboot.cruddemorest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john= User.builder()
                .username("john").password("{noop}test123")
                .roles("Employee").build();
        // noop signifies no operation like encryption etc. applied on password
        UserDetails mary= User.builder()
                .username("mary").password("{noop}test123")
                .roles("Employee","Manager").build();

        UserDetails susan= User.builder()
                .username("susan").password("{noop}test123")
                .roles("Employee","Manager","Admin").build();

        return new InMemoryUserDetailsManager(john,mary,susan);

        // now spring-boot will not use the user/passwd from app.properties
    }

    //For restricting access based on roles
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->
            configurer.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("Employee")
                    .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("Employee")
                    .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("Manager")
                    .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("Manager")
                    .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("Admin")

        );

        // use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use get/put/post etc.
        http.csrf(csrf->csrf.disable());

        return http.build();
    }
}
