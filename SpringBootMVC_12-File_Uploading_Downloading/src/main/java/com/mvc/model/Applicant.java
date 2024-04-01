package com.mvc.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Applicant implements Serializable {

	private static final long serialVersionUID = 8423350181331930629L;
	
	@Id
	@SequenceGenerator(name = "id", sequenceName = "applicant_id", initialValue = 10000000, allocationSize = 1)
	@GeneratedValue(generator = "id", strategy = GenerationType.AUTO)
	private Long   id;
	@Column(length = 20)
	private String name;
	private Long   mobile;
	@Column(length = 25)
	private String email;
	private LocalDate dob;
	@Column(length = 20)
	private String address;
	@Column(length = 20)
	private String qualification;
	@Column
	private String resumePath;
	@Column
	private String photoPath;

}
