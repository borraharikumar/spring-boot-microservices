package com.mvc.mp.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@SequenceGenerator(name = "id", sequenceName = "employee_id", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "id", strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Long mobile;
	private String email;
	private String address;
	private LocalDate hireDate;
	private String designation;
	private Double salary;
	
}
