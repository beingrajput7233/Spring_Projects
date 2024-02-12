package com.jsr.springboot.cruddemorest.service;

import com.jsr.springboot.cruddemorest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
