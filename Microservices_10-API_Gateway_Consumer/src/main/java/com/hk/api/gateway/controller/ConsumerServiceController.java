package com.hk.api.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.api.gateway.controller.rest.ConsumerRestConsumer;

@RestController
@RequestMapping("/consumer")
public class ConsumerServiceController {
	
	@Autowired
	private ConsumerRestConsumer restConsumer;
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return restConsumer.getProducerResponse();
	}

}
