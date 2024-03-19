package com.hk.eureka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillingServiceController {
	
	@GetMapping("/info")
	public ResponseEntity<String> getBillInfo() {
		return new ResponseEntity<String>("UPI | Debit Card | Credit Card | EMI | Cash on Delivery", HttpStatus.OK);
	}

}
