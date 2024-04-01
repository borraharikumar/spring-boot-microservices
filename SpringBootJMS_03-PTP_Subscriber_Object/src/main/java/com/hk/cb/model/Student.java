package com.hk.cb.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

	private static final long serialVersionUID = 6390458453195173322L;
	
	private String roll;
	private String name;
	private String branch;

}
