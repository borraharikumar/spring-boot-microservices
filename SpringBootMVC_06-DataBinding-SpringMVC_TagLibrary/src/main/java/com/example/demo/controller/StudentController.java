package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.model.Student;

@Controller
public class StudentController {
	
	@GetMapping
	public String home() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String registerStudent(@ModelAttribute("student") Student student) {
		student.setCgpa(7.5f);
		student.setDepartment("Mechanical Engineering");
		return "register_student";
	}

}
