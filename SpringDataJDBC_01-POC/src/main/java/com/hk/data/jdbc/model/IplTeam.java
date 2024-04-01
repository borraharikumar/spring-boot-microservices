package com.hk.data.jdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "IPL_TEAMS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IplTeam implements Persistable<Integer> {
	
	@Id
	private Integer id;
	private String name;
	private String captain;
	private String owner;
	private Integer titles;
	
	@Transient
	private Boolean isNew;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return isNew;
	}

	@Override
	public String toString() {
		return "IplTeam [id=" + id + ", name=" + name + ", captain=" + captain + ", owner=" + owner + ", titles="
				+ titles + "]";
	}
	
	

}
