package com.spr.cruddemo.dao;

import com.spr.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // Define EntityManager using constructor injection
    private final EntityManager mEntityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        mEntityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        mEntityManager.persist(student);
    }

    @Override
    public Student getStudent(int id) {
        return mEntityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = new Student();
        student.setId(id);
        mEntityManager.remove(student);
    }
}
