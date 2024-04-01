package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	
	@Autowired
	private ServletContext context;
	@Autowired
	private ServletConfig config;
	@Autowired
	private HttpSession session;
	
	
	
	@GetMapping
	public String home() {
		System.err.println("Web-application name  :: " + context.getContextPath());
		System.err.println("DispatcherServlet LVN :: " + config.getServletName());
		System.err.println("Session id            :: " + session.getId());
		return "index";
	}
	
	
	/*
	@GetMapping
	public String home(ServletContext context, ServletConfig config, HttpSession session) {
		System.err.println("Web-application name  :: " + context.getContextPath());
		System.err.println("DispatcherServlet LVN :: " + config.getServletName());
		System.err.println("Session id            :: " + session.getId());
		return "index";
	}
	*/
	
	/*
	@GetMapping
	public String home(HttpSession session) {
		System.err.println("Session id            :: " + session.getId());
		return "index";
	}
	*/
	
}
