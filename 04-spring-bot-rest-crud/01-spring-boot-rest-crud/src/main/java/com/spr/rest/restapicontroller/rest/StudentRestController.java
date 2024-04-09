package com.spr.rest.restapicontroller.rest;

import com.spr.rest.restapicontroller.entity.Student;
import com.spr.rest.restapicontroller.exception.StudentErrorResponse;
import com.spr.rest.restapicontroller.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadStudent() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Prasanna", "Srinivasan"));
        theStudents.add(new Student("Sundari", "Srinivasan"));
        theStudents.add(new Student("Rajakamalam", "Mariappan"));
    }

    // Define an endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student [" + studentId + "] not found!");
        }

        return theStudents.get(studentId);
    }
}
