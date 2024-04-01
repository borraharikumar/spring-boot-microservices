package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {

	@RequestMapping("/home")
	public String showHome() {
		//Return Logical View Name
		return "welcome";
	}

}