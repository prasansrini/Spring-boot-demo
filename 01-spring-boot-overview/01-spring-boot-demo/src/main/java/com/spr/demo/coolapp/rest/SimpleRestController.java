package com.spr.demo.coolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
    @GetMapping("/")
    public String getString() {
        return "Hello World!";
    }
}
