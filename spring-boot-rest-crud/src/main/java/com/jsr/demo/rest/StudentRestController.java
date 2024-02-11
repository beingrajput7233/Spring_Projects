package com.jsr.demo.rest;

import com.jsr.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> l;

    @PostConstruct
    public void loadData(){
//        it is done so that list is created only once for every run of main application not for every http request
        l=new ArrayList<>();
        l.add(new Student("Ashutosh","Singh"));
        l.add(new Student("A","S"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
//        spring will use Jackson in background
        return l;
    }

    // "/students/{studentId}" ---return a single student....by index of array list
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // Exception Handling

        if((studentId>=l.size())||(studentId<0)){
            throw new StudentNotFoundException("Student Id not found - "+studentId);
        }

        return l.get(studentId);
    }

    // Adding exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException excep){
        StudentErrorResponse error=new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());

        error.setMessage(excep.getMessage());

        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
