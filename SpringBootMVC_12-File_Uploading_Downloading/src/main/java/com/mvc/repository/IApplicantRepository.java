package com.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mvc.model.Applicant;

public interface IApplicantRepository extends JpaRepository<Applicant, Long> {
	
	@Query("select resumePath from Applicant where id = :id")
	public String getResumePath(Integer id);
	
	@Query("select photoPath from Applicant where id = :id")
	public String getPhotoPath(Integer id);
	
}
