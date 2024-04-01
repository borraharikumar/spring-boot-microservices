package com.batch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResult {
	
	@Id
	private Integer id;
	private String name;
	private String college_code;
	private Float percentage;
	
}
