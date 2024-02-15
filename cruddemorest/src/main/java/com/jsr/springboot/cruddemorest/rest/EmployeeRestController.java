package com.jsr.springboot.cruddemorest.rest;

import com.jsr.springboot.cruddemorest.dao.EmployeeDAO;
import com.jsr.springboot.cruddemorest.entity.Employee;
import com.jsr.springboot.cruddemorest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    // /employees to return all employee
    // GET method
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // GET method
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee e=employeeService.findById(employeeId);

        if(e==null){
            throw new RuntimeException("Emplyee Id not found - "+employeeId);
        }
        return e;
    }

    // post method to save
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee e){

        // also if they pass an id in JSON...set id to 0
        // this is to force save a new item...instead of update

        e.setId(0);

        Employee dbEmployee=employeeService.save(e);
        return dbEmployee;
    }

    // put method to update
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee e){

        Employee dbEmployee=employeeService.save(e);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee e=employeeService.findById(employeeId);

        if(e==null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id- "+employeeId;
    }
}
