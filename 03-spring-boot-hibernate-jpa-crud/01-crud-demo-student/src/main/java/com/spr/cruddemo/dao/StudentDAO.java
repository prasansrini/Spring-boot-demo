package com.spr.cruddemo.dao;

import com.spr.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
