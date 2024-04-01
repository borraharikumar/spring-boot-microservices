package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class FirstController {

	@GetMapping
	public String method11() {
		System.err.println("FirstController.method11()");
		return "welcome";
	}

	@GetMapping("/date")
	public String method12() {
		System.err.println("FirstController.method12()");
		return "date";
	}

	/*@GetMapping("/dat")
	public String method13() {
		System.err.println("FirstController.method13()");
		return "forward:date";
	}*/

	@GetMapping("/tim")
	public String method14() {
		System.err.println("FirstController.method14()");
		return "forward:../second/time";
	}
	
	/*@GetMapping("/dat")
	public String method15() {
		System.err.println("FirstController.method15()");
		return "redirect:date";
	}*/
	
	/*@GetMapping("/tim")
	public String method16() {
		System.err.println("FirstController.method15()");
		return "redirect:../second/time";
	}*/

}