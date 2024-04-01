package com.hk.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Microservices10ApiGatewayEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservices10ApiGatewayEurekaServerApplication.class, args);
	}

}
