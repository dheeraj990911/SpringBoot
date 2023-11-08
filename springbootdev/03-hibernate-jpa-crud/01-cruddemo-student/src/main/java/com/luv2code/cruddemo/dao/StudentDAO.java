package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findByID(Integer id);

    List<Student> findAll();
    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}