package com.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	public String getHomePage() {
		return "welcome";
	}
	
	@GetMapping("/report")
	public String getReport(@RequestParam("type") String type, Map<String, Object> map) {
		map.put("empList", service.getEmployeeReport());
		if(type.equalsIgnoreCase("excel"))
			return "excel_report";
		else if(type.equalsIgnoreCase("pdf"))
			return "pdf_report";
		else return null;
	}
	
}
