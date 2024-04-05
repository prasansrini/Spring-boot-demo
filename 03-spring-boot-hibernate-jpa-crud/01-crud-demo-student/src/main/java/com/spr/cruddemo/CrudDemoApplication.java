package com.spr.cruddemo;

import com.spr.cruddemo.dao.StudentDAO;
import com.spr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating student... ");
        Student student = new Student("Prasan", "Srini", "pr@email.com");
        System.out.println("Saving student... ");
        studentDAO.save(student);

        System.out.println("Last saved Student ID: " + student.getId());

//        studentDAO.deleteStudent(3);

        System.out.println("Get Student: " + studentDAO.getStudent(3));
    }
}
