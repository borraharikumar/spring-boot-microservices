package com.hk.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private String rollNo;
	private String name;
	private String branch;
	private String college;

}