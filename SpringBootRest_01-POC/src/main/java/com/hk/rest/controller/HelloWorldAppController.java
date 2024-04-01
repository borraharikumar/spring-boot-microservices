package com.hk.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hk.rest.model.Student;

//@Controller
//@ResponseBody
@RestController
public class HelloWorldAppController {
	
	// Simple hello world
	// http://localhost:8083/SpringBootRest_01-POC/hello-world
	@GetMapping("/hello-world")
	public String sayHello() {
		return "Hello world...!";
	}
	
	// JSON object as response
	// http://localhost:8083/SpringBootRest_01-POC/stud
	@GetMapping("/stud")
	public Student getStudentDetails() {
		return new Student("17X21A0302", "Harikumar Borra", "ME", "PITS");
	}
	
	// List of JSON objects as response
	// http://localhost:8083/SpringBootRest_01-POC/students
	@GetMapping("/students")
	public List<Student> getAllStudentDetails() {
		return List.of(new Student("17X21A0302", "Harikumar Borra", "ME", "PITS"),
					   new Student("17X21A0513", "Ganesh Kanuma", "CSE", "PITS"), 
					   new Student("17X21A0422", "Bharath Murahari", "ECE", "PITS"));
	}
	
	// Path variables
	// http://localhost:8083/SpringBootRest_01-POC/student/17X21A0302/Harikumar Borra/ME/PITS
	@GetMapping("/student/{rollNumber}/{name}/{branch}/{college}")
	public Student studentPathVariables(@PathVariable("rollNumber") String rollNo,
										@PathVariable String name,
										@PathVariable String branch,
										@PathVariable String college) {
		return new Student(rollNo, name, branch, college);
	}
	
	// Request params
	// http://localhost:8083/SpringBootRest_01-POC/student?rollNumber=17X21A0302&name=Harikumar Borra&branch=ME&college=PITS
	@GetMapping("/student")
	public Student studentRequestParam(@RequestParam("rollNumber") String rollNo,
									   @RequestParam String name,
									   @RequestParam String branch,
									   @RequestParam String college) {
		return new Student(rollNo, name, branch, college);
	}

}
