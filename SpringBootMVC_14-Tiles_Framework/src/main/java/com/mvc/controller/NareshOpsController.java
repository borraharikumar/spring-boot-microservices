package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NareshOpsController {
	
	@GetMapping("/")
	public String showHomePage() {
		return "homePageDef";
	}
	
}
