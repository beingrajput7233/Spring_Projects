package com.jsr.cruddemo.dao;

import com.jsr.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    void deleteById(Integer id);
}
