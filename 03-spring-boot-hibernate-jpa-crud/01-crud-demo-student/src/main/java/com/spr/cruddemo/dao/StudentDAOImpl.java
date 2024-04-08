package com.spr.cruddemo.dao;

import com.spr.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Student findStudentById(int id) {
        return mEntityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = new Student();
        student.setId(id);
        mEntityManager.remove(student);
    }

    @Override
    public List<Student> findAll() {
        // Create query for get all Student in the DB.
//        TypedQuery<Student> query = mEntityManager.createQuery("FROM Student", Student.class);

        TypedQuery<Student> query = mEntityManager.createQuery("FROM Student order by lastName desc", Student.class);

        // Return query results.
        return query.getResultList();
    }

    @Override
    public List<Student> findStudentByLastName(String lastName) {

        TypedQuery<Student> theQuery = mEntityManager.
                createQuery("FROM Student WHERE lastName=:theData", Student.class);

        theQuery.setParameter("theData", lastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        mEntityManager.merge(student);
    }
}
