package com.mvc.service;

import java.io.IOException;
import java.util.List;

import com.mvc.model.Applicant;
import com.mvc.model.ApplicantData;

public interface IApplicantService {
	
	public ApplicantData register(ApplicantData applicantData) throws IOException;
	public List<Applicant> getJobSeekerReport();
	public String getResumePathById(Integer id);
	public String getPhotoPathById(Integer id);
	public Applicant getApplicantById(Long id);
	
}
