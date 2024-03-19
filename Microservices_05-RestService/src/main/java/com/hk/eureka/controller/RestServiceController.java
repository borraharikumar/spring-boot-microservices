package com.hk.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poc")
public class RestServiceController {
	
	@Value("${db.username}")
	private String user;
	@Value("${db.password}")
	private String pwd;
	
	@GetMapping("/info")
	public String show() {
		System.err.println("RestServiceController.show()");
		return "DB-USER :: " + user
				+ "<br>DB-PSWD :: " + pwd;
	}

}
