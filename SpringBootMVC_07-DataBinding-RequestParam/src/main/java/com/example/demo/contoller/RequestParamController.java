package com.example.demo.contoller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamController {
	
	/*@GetMapping("/student")
	public String requestParam(@RequestParam("roll") Integer rollNo, @RequestParam("name") String studName) {
		return "result";
	}*/
	
	/*@GetMapping("/student")
	public String requestParam(@RequestParam Integer roll, @RequestParam String name) {
		return "result";
	}*/
	
	/*@GetMapping("/student")
	public String requestParam(@RequestParam Integer roll, @RequestParam(required = false) String name) {
		return "result";
	}*/
	
	/*@GetMapping("/student")
	public String requestParam(@RequestParam Integer roll,
							   @RequestParam(required = false, defaultValue = "Harikumar") String name) {
		return "result";
	}*/
	
	@GetMapping("/student")
	public String requestParam(@RequestParam Integer roll, @RequestParam String name,
								@RequestParam("add") String addArray[],
								@RequestParam("add") List<String> addList,
								@RequestParam("add") Set<String> addSet) {
		System.err.println(roll + "\t" + name + "\t" + Arrays.toString(addArray) + "\t" + addList + "\t" + addSet);
		return "result";
	}

}
