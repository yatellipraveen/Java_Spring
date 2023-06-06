package com.example.sprincoredemo.config;

import com.example.sprincoredemo.common.Coach;
import com.example.sprincoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aqua")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
