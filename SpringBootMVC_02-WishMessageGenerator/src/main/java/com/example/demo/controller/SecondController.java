package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/second")
public class SecondController {
	
	@GetMapping("/all")
	public String example() {
		return "example";
	}
	
	@GetMapping("/ex")
	public String example2() {
		return "forward:second/all";
	}

}
