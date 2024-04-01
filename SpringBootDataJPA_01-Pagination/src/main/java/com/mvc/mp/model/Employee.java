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
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@SequenceGenerator(name = "id", sequenceName = "empno_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "id", strategy = GenerationType.AUTO)
	private Integer empno;
	private String ename;
	private String email;
	private String job;
	private LocalDate hiredate;
	private Double sal;
}
