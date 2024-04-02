package com.spr.demo.coolapp.rest;

import jakarta.websocket.OnError;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

    @Value("${server.port}")
    private String mPort;

    @GetMapping("/")
    public String getString() {
        return "Hello World!";
    }

    // Expose a new endpoint for "Workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // Expose a new endpoind for "Fortune"
    @GetMapping("/fortune")
    public String getFortune() {
        return "Today is your lucky day! Port is " + mPort;
    }
//
//    @OnError()
//    public String getError() {
//        return "Oops, some error occured!";
//    }
}
