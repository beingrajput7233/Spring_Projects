package com.jsr.springboot.cruddemorest.service;

import com.jsr.springboot.cruddemorest.dao.EmployeeDAO;
import com.jsr.springboot.cruddemorest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO dao){
        employeeDAO=dao;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
