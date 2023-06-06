package com.example.sprincoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements Coach{

    //define init method
    @PostConstruct
    public void doStartupStuff() {
        System.out.println("Constructor called for Tennis Coach");
    }

    //define desturctpr method
    @PreDestroy
    public void doDestructorStuff() {
        System.out.println("Destructor called for Tennis Coach");
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis Coach";
    }
}
