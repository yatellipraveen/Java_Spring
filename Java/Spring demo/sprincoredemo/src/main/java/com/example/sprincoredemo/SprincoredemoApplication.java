package com.example.sprincoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
//		scanBasePackages = {"com.example.springcoredemo", "com.example.util"}
)
public class SprincoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprincoredemoApplication.class, args);
	}

}
