package com.jsr.demo.rest;

import com.jsr.demo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> l=new ArrayList<>();

        l.add(new Student("Ashutosh","Singh"));
        l.add(new Student("A","S"));

//        spring will use Jackson in background
        return l;
    }
}
