package com.spr.thymeleaf.ThymeLeafSample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class DemoController {
    // Endpoint for "/hello".
    @GetMapping("/hello")
    public String getInformation(Model model) {
        model.addAttribute("theDate", LocalDateTime.now());

        return "helloworld";
    }
}
