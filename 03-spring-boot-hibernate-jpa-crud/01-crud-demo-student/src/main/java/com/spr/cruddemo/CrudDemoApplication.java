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
//            createStudent(studentDAO);

//            readStudent(studentDAO);

//            queryForStudents(studentDAO);

            queryForStudentsByLastName(studentDAO);
        };
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

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating student... ");
        Student student = new Student("Sundari", "Srinivasan", "sundari@email.com");
        System.out.println("Saving student... ");
        studentDAO.save(student);

//        studentDAO.deleteStudent(1);

//        System.out.println("Last saved Student ID: " + student.getId());

//        studentDAO.deleteStudent(3);

        System.out.println("Get Student: " + studentDAO.findStudentById(3));
    }
}
