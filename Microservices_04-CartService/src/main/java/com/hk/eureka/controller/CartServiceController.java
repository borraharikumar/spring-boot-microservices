package com.hk.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.eureka.controller.rest.BilingServiceRestConsumer;

@RestController
@RequestMapping("/cart")
public class CartServiceController {
	
	@Autowired
	private BilingServiceRestConsumer consumer;
	
	@GetMapping("/info")
	public ResponseEntity<String> fetchInfo(){
		return new ResponseEntity<String>("We accept the following payment methods :: " + consumer.fetchPaymentMethods(),
										  HttpStatus.OK);
	}

}
