package com.hk.cb.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/cb")
public class ExampleController {
	
	@GetMapping("/test")
	@CircuitBreaker(name = "example_circuit_breaker", fallbackMethod = "fallbackMethod")
	public String businessMethod() {
		System.out.println("ExampleController.businessMethod()");
		if(new Random().nextInt(10)<9) throw new RuntimeException();
		return "<h1 style='color:blue'>Response from business method</h1>";
	}
	
	public String fallbackMethod(Throwable throwable) {
		System.err.println("ExampleController.fallbackMethod()");
		return "<h1 style='color:red'>Response from fallback method</h1>";
	}

}
