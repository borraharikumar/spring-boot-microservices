package com.batch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamResult {
	
	private Integer id;
	private String name;
	private String college_code;
	private Float percentage;

}
