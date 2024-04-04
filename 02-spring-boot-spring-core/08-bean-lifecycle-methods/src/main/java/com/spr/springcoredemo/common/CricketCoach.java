package com.spr.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 minutes.";
    }

    // Define init method
    @PostConstruct
    public void DoMyStartupStuff() {
        System.out.println("Do init for: " + getClass().getSimpleName());
    }

    // Define destruction method
    @PreDestroy
    public void doSomeDestruction() {
        System.out.println("Do destruction for: " + getClass().getSimpleName());
    }
}
