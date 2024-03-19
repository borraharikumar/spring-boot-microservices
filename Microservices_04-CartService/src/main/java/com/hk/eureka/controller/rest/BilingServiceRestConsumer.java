package com.hk.eureka.controller.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("BillingService")
public interface BilingServiceRestConsumer {
	
	@GetMapping("/bill/info")
	public ResponseEntity<String> fetchPaymentMethods();

}
