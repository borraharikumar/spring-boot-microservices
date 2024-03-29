package com.hk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Microservices05ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservices05ConfigServerApplication.class, args);
	}

}
