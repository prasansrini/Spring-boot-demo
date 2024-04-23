package com.spr.thymeleaf.ThymeLeafSample.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "form";
    }

    @RequestMapping("/processForm")
    public String processAndRespondForm() {
        return "processed-form";
    }

    @RequestMapping("/processFormAgain")
    public String processInformation(HttpServletRequest request, Model model) {
        // Read request param from HTML form.
        String name = request.getParameter("studentName");

        // Convert the data to upper case.
        name = name.toUpperCase();

        // Create a message.
        String result = "Hello " + name + "!";

        // Add the message to the model.
        model.addAttribute("message", result);

        return "helloworld-new";
    }

    @PostMapping("/processFormWithReq")
    public String processInformation(@RequestParam("studentName") String studentName, Model model) {
        // Convert the data to upper case.
        studentName = studentName.toUpperCase();

        // Create a message.
        String result = "Yo " + studentName + "!";

        // Add the message to the model.
        model.addAttribute("message", result);

        return "helloworld-new";
    }
}
