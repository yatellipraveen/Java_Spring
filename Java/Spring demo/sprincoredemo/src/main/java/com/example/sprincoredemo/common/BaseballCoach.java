package com.example.sprincoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout()
    {
        return "Baseball Coach";
    }
}
