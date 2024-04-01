package com.hk.rest.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cricketer {
	
	private Integer id;
	private String name;
	private LocalDate dob;
	private String birthPlace;
	private String role;
	private String battingStyle;
	private String bowlingStyle;
	
	@Override
	public String toString() {
		return "\n{\n"
					+ "\t\"id\" : " + id
					+ ",\n\t\"name\" : \"" + name
					+ "\",\n\t\"dob\" : \"" + dob
					+ "\",\n\t\"birthPlace\" : \"" + birthPlace
					+ "\",\n\t\"role\" : \"" + role
					+ "\",\n\t\"battingStyle\" : \"" + battingStyle
					+ "\",\n\t\"bowlingStyle\" : \"" + bowlingStyle + 
			   "\"\n}";
	}

}
