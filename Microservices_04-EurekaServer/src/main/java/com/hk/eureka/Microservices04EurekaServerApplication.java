package com.hk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Microservices04EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservices04EurekaServerApplication.class, args);
	}

}
