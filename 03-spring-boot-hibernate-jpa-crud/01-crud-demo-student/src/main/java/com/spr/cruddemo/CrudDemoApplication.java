package com.spr.cruddemo;

import com.spr.cruddemo.dao.StudentDAO;
import com.spr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createMultipleStudents(studentDAO);

//            readStudent(studentDAO);

//            queryForStudents(studentDAO);

//            queryForStudentsByLastName(studentDAO);

//            updateStudent(studentDAO);

//            deleteStudent(studentDAO);

//            deleteAll(studentDAO);
        };
    }

    private void deleteAll(StudentDAO studentDAO) {
        System.out.println("Number of rows deleted: " + studentDAO.deleteAll());
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 4;

        System.out.println("Deleting student: " + studentId);

        studentDAO.deleteStudent(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findStudentById(3);

        student.setFirstName("Prasanna");
        student.setEmail("prasansrini@email.com");

        studentDAO.update(student);

        System.out.println(student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // Get Students ordered by last name.
        String lastName = "Mariappan";
        List<Student> students = studentDAO.findStudentByLastName(lastName);

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // Get all the students.
        List<Student> students = studentDAO.findAll();

        // Display the list.
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Last saved Student ID: " + studentDAO.findStudentById(1));
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating student... ");
        Student student = new Student("Ram", "Sam", "sundari@email.com");
        System.out.println("Saving student... ");
        studentDAO.save(student);

        student = new Student("Shyam", "Shyam", "shyam@email.com");
        studentDAO.save(student);

        student = new Student("Bama", "Shyama", "bama@email.com");
        studentDAO.save(student);

//        studentDAO.deleteStudent(1);

//        System.out.println("Last saved Student ID: " + student.getId());

//        studentDAO.deleteStudent(3);

//        System.out.println("Get Student: " + studentDAO.findStudentById(3));
    }
}
