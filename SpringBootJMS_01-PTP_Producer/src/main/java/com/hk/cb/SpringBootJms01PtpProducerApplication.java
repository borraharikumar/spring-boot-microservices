package com.hk.cb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootJms01PtpProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJms01PtpProducerApplication.class, args);
	}

}
