package com.hk.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class CartServiceController {
	
	@Autowired
	private RestTemplate restTemplate;
	private Logger logger = LoggerFactory.getLogger(CartServiceController.class);
	
	@GetMapping("/cart")
	public ResponseEntity<String> sample() {
		logger.info(new Date() + " :: Welcome to cart module");
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8102/bill", String.class);
		logger.info(new Date() + " :: Back to cart module with response :: " + response);
		return response;
	}

}
