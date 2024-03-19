package com.hk.eureka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillingSeviceController {
	
	@GetMapping("/info")
	public ResponseEntity<String> displayMessage(){
		return new ResponseEntity<String>("UPI | Credit Card | Debit Card | Cash on Delivery", HttpStatus.OK);
	}

}
