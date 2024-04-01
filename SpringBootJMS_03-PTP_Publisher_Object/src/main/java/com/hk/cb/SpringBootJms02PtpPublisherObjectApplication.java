package com.hk.cb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootJms02PtpPublisherObjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJms02PtpPublisherObjectApplication.class, args);
	}

}
