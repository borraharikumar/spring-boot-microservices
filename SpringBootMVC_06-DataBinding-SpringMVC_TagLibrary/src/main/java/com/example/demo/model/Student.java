package com.example.demo.model;

import lombok.Data;

@Data
public class Student {
	private String roll;
	private String name;
	private String department;
	private Float cgpa;
	
	/*public Student() {
		System.out.println("██   ██  █████  ██████  ██ ██   ██ ██    ██ ███    ███  █████  ██████  \r\n"
						 + "██   ██ ██   ██ ██   ██ ██ ██  ██  ██    ██ ████  ████ ██   ██ ██   ██ \r\n"
						 + "███████ ███████ ██████  ██ █████   ██    ██ ██ ████ ██ ███████ ██████  \r\n"
						 + "██   ██ ██   ██ ██   ██ ██ ██  ██  ██    ██ ██  ██  ██ ██   ██ ██   ██ \r\n"
						 + "██   ██ ██   ██ ██   ██ ██ ██   ██  ██████  ██      ██ ██   ██ ██   ██ ");
	}*/
}
