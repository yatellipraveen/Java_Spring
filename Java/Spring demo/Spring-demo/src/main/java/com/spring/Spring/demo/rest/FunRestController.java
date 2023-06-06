package com.spring.Spring.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" that return "Hello World!"

    //inject properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teanName;

    @GetMapping("/teaminfo")
    private String getTeamInfo(){
        return "Coach: "+ coachName + ", Team Name: "+ teanName;
    }
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // expose a new endpoint for "fortune"

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky Day!!!";
    }
}
