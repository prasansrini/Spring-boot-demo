package com.spr.rest.restapicontroller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {
    @GetMapping("/hello")
    public String getHelloWorld() {
        System.out.println("Reached /test/hello endpoint.");
        return "Hello World!";
    }
}
