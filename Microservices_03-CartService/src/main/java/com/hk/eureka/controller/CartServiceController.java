package com.hk.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.eureka.controller.rest.BillingServiceLoadBalancingClient;

@RestController
@RequestMapping("/cart")
public class CartServiceController {
	
	@Value("${server.port}")
	private Integer port;
	@Value("${eureka.instance.instance-id}")
	private String serviceInstance;
	
	@Autowired
	private BillingServiceLoadBalancingClient client;
	
	@GetMapping("/info")
	public ResponseEntity<String> getCartInfo() {
		return new ResponseEntity<String>("We accept the following payment methods :: " + client.getPaymentMethods(),
										  HttpStatus.OK);
	}

}
