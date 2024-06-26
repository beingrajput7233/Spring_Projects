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

    @Override
    public Employee findById(int theId) {
        Employee e=entityManager.find(Employee.class,theId);

        return e;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee=entityManager.merge(theEmployee);
        // merge method :- if id==0 --> insert else update
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee e=entityManager.find(Employee.class,theId);

        entityManager.remove(e);
    }
}
