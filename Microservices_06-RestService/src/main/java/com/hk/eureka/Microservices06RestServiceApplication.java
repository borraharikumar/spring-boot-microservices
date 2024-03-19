package com.hk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Microservices06RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservices06RestServiceApplication.class, args);
	}

}
