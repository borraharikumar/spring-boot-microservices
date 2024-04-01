package com.mvc.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	private Integer id;
	private String name;
	private String email;
	private LocalDate hireDate;
	private String job;
	private Double salary;

}
