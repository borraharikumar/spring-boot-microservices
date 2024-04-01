package com.hk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@Configuration
public class AppConfig {

	@Bean
	Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
