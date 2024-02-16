package com.jsr.springboot.cruddemorest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


    /*

    THIS IS TO HARD CODE USERS

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

     */



    /* USING JDBC ...NO MORE HARD CODING */
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        // it will automatially find tables users and authorities
        return new JdbcUserDetailsManager(dataSource);
    }







    //For restricting access based on roles
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->
            configurer.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")

        );

        // use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use get/put/post etc.
        http.csrf(csrf->csrf.disable());

        return http.build();
    }
}
