package com.mvc.mp.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import lombok.Data;

@SuppressWarnings("deprecation")
@Entity
@SQLDelete(sql = "UPDATE Employee SET Status = 'inactive' WHERE id = ? ")
@Where(clause = "status <> 'inactive'")
@Data
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "id", sequenceName = "empid_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "id", strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 20)
	private String name;
	@Column(length = 25)
	private String email;
	private LocalDate hireDate;
	@Column(length = 10)
	private String job;
	private Double salary;
	private String country;
	private String state;
	
	@Column(length = 8)
	private String status;
	
	//Unwanted properties
	@Transient
	private String vflag = "no";
	
	
	

}
