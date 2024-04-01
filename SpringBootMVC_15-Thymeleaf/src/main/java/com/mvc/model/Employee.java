package com.mvc.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@SuppressWarnings("deprecation")
@Entity
@Data
@SQLDelete(sql = "UPDATE employee SET status = 'inactive' WHERE id = ?")
@Where(clause = "status <> 'inactive'")
public class Employee implements Serializable {

	private static final long serialVersionUID = 3230515761748159L;
	
	@Id
	@SequenceGenerator(name = "id", sequenceName = "applicant_id", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "id", strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private LocalDate hireDate;
	private String job;
	private Double salary;
	
	private String status = "active";

}
