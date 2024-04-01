package com.hk.api.gateway.controller.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Producer")
public interface ConsumerRestConsumer {
	
	@GetMapping("/producer/test")
	public ResponseEntity<String> getProducerResponse();

}
