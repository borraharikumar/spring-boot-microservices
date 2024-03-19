package com.hk.eureka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/wish")
	public ResponseEntity<String> wish() {
		return new ResponseEntity<String>("Welcome to Eureka server...!", HttpStatus.OK);
	}

}
