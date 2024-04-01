package com.batch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResult {
	
	@Id
	private Integer id;
	private String name;
	private String collegeCode;
	private Float percentage;

}
