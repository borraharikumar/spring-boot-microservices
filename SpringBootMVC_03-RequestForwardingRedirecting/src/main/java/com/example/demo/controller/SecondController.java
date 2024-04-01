package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/second")
public class SecondController {

	@GetMapping("/time")
	public String method21() {
		System.err.println("SecondController.method21()");
		return "time";
	}
	
}
