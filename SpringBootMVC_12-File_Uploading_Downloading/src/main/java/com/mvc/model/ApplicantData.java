package com.mvc.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ApplicantData implements Serializable {

	private static final long serialVersionUID = 2454907159849504485L;

	private Long   id;
	private String name;
	private Long   mobile;
	private String email;
	private LocalDate dob;
	private String address;
	private String qualification;
	private MultipartFile resume;
	private MultipartFile photo;

}
