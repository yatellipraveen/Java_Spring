package com.example.sprincoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("SwimCoach Construtor");
    }
    @Override
    public String getDailyWorkout() {
        return "Swim a 1000 meters";
    }
}
