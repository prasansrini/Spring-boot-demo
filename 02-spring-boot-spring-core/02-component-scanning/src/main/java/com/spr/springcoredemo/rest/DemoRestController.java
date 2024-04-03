package com.spr.springcoredemo.rest;

import com.spr.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    private final Coach mCoach;

    @Autowired
    DemoRestController(Coach coach) {
        mCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return mCoach.getDailyWorkout();
    }

    @GetMapping("/")
    public String getHome() {
        return mCoach.getDailyWorkout();
    }
}
