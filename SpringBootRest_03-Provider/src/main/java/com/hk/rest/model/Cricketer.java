package com.hk.rest.model;

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
public class Cricketer {
	
	@Id
	@SequenceGenerator(name = "id", sequenceName = "Cricketer_Id", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "id", strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private LocalDate dob;
	private String birthPlace;
	private String role;
	private String battingStyle;
	private String bowlingStyle;

}
