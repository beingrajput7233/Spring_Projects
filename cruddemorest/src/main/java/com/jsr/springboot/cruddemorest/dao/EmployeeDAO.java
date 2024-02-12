package com.jsr.springboot.cruddemorest.dao;

import com.jsr.springboot.cruddemorest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
