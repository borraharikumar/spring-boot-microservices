package com.hk.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.eureka.controller.rest.BillingServiceRestConsumer;

@RestController
@RequestMapping("/cart")
public class CartServiceController {
	
	@Autowired
	private BillingServiceRestConsumer consumer;
	
	@GetMapping("/info")
	public ResponseEntity<String> getCartInfo() {
		return new ResponseEntity<String>("<h1 style='color:red;'>We accept different types of payment methods :: <br>"
											+ consumer.getBillInfo() + "<h1>",
											HttpStatus.CREATED);
	}

}
