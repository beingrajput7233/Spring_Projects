package com.jsr.springboot.cruddemorest.service;

import com.jsr.springboot.cruddemorest.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    public Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
