package com.spr.springcoredemo.rest;

import com.spr.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @Autowired
    private Coach mCoach;

    private Coach mNewCoach;

    @Autowired
    public void setCoach(Coach coach) {
        mNewCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return mNewCoach.getDailyWorkout();
    }

    @GetMapping("/")
    public String getHome() {
        return mCoach.getDailyWorkout();
    }
}
