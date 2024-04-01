package com.mvc.mp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.mp.model.CricketPlayer;

@Controller
public class CricketPlayerController {
	
	@GetMapping("/")
	public String showPlayerRegistrationPage(@ModelAttribute("player") CricketPlayer player) {
		return "register_player";
	}
	
	@PostMapping("/")
	public String showPlayerRegistrationResultPage(@ModelAttribute("player") CricketPlayer player) {
		return "result_register_player";
	}
	
	@InitBinder
	public void myInitBinber(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
