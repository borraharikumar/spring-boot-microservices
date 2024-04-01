package com.hk.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BillingServiceController {
	
	private Logger logger = LoggerFactory.getLogger(BillingServiceController.class);
	
	@GetMapping("/bill")
	public ResponseEntity<String> sample() {
		logger.info(new Date() + " :: Welcome to billing module");
		ResponseEntity<String> response = new ResponseEntity<String>("Bill amount ::" + 3000 + "rupees", HttpStatus.OK);
		logger.info(new Date() + " :: Back to billing module with response :: " + response);
		return response;
	}

}
