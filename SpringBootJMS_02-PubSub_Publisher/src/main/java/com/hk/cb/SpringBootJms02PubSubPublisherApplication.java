package com.hk.cb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootJms02PubSubPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJms02PubSubPublisherApplication.class, args);
	}

}
