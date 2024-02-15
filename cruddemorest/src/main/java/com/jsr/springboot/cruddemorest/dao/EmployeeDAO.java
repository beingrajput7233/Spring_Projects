package com.jsr.springboot.cruddemorest.dao;

import com.jsr.springboot.cruddemorest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
