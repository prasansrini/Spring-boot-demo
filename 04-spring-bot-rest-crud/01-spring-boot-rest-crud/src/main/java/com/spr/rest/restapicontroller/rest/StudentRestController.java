package com.spr.rest.restapicontroller.rest;

import com.spr.rest.restapicontroller.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // Define an endpoint for "/students"

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Prasanna", "Srinivasan"));
        students.add(new Student("Sundari", "Srinivasan"));
        students.add(new Student("Rajakamalam", "Mariappan"));

        return students;
    }
}
