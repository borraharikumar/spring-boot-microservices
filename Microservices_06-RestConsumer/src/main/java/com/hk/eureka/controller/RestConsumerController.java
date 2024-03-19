package com.hk.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestConsumerController {
	
	@Value("${db.user}")
	private String user;
	@Value("${db.pswd}")
	private String pwd;
	
	@GetMapping("/info")
	public String show() {
		return "<h1>DB-USER :: " + user
				+ "<br>DB-PSWD :: " + pwd;
	}

}
