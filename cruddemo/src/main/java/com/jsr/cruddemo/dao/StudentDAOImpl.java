package com.jsr.cruddemo.dao;

import com.jsr.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;



    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }


    @Override
    public Student findById(Integer id) {
        Student s=entityManager.find(Student.class,id);
        return s;
    }

    @Override
    public List<Student> findAll(){

        TypedQuery<Student> q=entityManager.createQuery("FROM Student ORDER BY lastName",Student.class);

        return q.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(Integer id){
        Student s=entityManager.find(Student.class,id);
        entityManager.remove(s);
    }
}
