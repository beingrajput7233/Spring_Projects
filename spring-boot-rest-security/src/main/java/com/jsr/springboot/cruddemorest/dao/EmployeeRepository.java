package com.jsr.springboot.cruddemorest.dao;

import com.jsr.springboot.cruddemorest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //nothing here
}
