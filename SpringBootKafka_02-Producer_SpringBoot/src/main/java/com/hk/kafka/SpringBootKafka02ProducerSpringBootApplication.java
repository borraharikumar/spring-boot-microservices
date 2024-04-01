package com.hk.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringBootKafka02ProducerSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafka02ProducerSpringBootApplication.class, args);
	}

}
