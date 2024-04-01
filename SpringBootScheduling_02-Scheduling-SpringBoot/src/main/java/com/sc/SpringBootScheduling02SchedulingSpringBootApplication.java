package com.sc;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootScheduling02SchedulingSpringBootApplication {

	public static void main(String[] args) {
		System.err.println("Application started :: " + new Date());
		SpringApplication.run(SpringBootScheduling02SchedulingSpringBootApplication.class, args);
	}

}
