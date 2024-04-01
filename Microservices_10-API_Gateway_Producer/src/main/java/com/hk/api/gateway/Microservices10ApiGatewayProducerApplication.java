package com.hk.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Microservices10ApiGatewayProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservices10ApiGatewayProducerApplication.class, args);
	}

}
