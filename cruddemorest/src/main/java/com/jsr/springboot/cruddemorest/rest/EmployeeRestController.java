package com.jsr.springboot.cruddemorest.rest;

import com.jsr.springboot.cruddemorest.dao.EmployeeDAO;
import com.jsr.springboot.cruddemorest.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    public EmployeeDAO employeeDAO;
    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO=theEmployeeDAO;
    }

    // /employees to return all employee
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
