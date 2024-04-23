package com.spr.thymeleaf.ThymeLeafSample.controller;

import com.spr.thymeleaf.ThymeLeafSample.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countryList;

    @Value("${languages}")
    private List<String> languages;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countryList);
        model.addAttribute("languages", languages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student) {
        System.out.println(student);

        return "student-confirmation";
    }
}
