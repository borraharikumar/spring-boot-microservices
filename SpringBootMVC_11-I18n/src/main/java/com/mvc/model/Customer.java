package com.mvc.model;

import lombok.Data;

@Data
public class Customer {
	private Integer id;
	private String name;
	private String address;
	private Double billAmt;
}
