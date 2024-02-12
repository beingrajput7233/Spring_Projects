package com.jsr.springboot.cruddemorest.dao;

import com.jsr.springboot.cruddemorest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //Entity manager

    EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager em){
        entityManager=em;
    }


    @Override
    public List<Employee> findAll(){
        TypedQuery<Employee> q=entityManager.createQuery("FROM Employee",Employee.class);

        return q.getResultList();
    }
}
