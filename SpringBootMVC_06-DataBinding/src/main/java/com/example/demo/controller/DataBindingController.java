package com.example.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;

@Controller
public class DataBindingController {
	
	@GetMapping
	public String home() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String registerStudent() {
		return "register_student";
	}
	
	@PostMapping("/register")
	public String registrationBinding(Map<String, Object> map,
									  @ModelAttribute("student") Student st) {
		return "result_page";
	}

}
