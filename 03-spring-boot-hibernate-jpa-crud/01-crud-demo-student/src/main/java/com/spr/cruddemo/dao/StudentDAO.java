package com.spr.cruddemo.dao;

import com.spr.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findStudentById(int id);

    void deleteStudent(int id);

    List<Student> findAll();
}
