package com.hk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Microservices05EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservices05EurekaServerApplication.class, args);
	}

}
