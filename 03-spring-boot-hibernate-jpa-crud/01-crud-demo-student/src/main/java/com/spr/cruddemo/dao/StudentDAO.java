package com.spr.cruddemo.dao;

import com.spr.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findStudentById(int id);

    void deleteStudent(Integer id);

    List<Student> findAll();

    List<Student> findStudentByLastName(String lastName);

    void update(Student student);

    int deleteAll();
}
