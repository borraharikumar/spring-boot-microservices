package com.hk.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillingServiceController {
	
	@Value("${server.port}")
	private Integer port;
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	
	@GetMapping("/info")
	public ResponseEntity<String> paymentMethods() {
		return new ResponseEntity<String>("UPI | Debit Card | Credit Card | EMI | Cash on Delivery"
										  + "<br>Port :: " + port + "<br>Instance id :: " + instanceId,
										  HttpStatus.OK);
	}

}
