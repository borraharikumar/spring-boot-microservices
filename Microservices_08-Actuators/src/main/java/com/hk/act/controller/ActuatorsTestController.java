package com.hk.act.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/act")
public class ActuatorsTestController {
	
	@GetMapping("/display")
	public String display() {
		return "";
	}

}
