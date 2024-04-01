package com.hk.rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Tourist {
	
	@Id
	@GeneratedValue
	private Integer 		id;
	@Column(length = 20)
	@NonNull
	private String  		name;
	@Column(length = 10)
	@NonNull
	private String  		address;

}
