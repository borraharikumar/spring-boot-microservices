package com.mvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mvc.model.Customer;

@Controller
public class CustomerController {
	
	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showRegisterFormPage(@ModelAttribute Customer customer,
									   Map<String, Object> map) {
		return "register_customer";
	}

}
