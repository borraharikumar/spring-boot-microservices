package com.mvc.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mvc.model.Applicant;
import com.mvc.model.ApplicantData;
import com.mvc.repository.IApplicantRepository;

@Service
public class ApplicantServiceImpl implements IApplicantService {
	
	@Autowired
	private IApplicantRepository repository;
	
	@Autowired
	private Environment environment;

	@Override
	public ApplicantData register(ApplicantData applicantData) throws IOException {
		System.err.println("ApplicantServiceImpl.register()");
		//Getting store folder location from properties file
		String storeLocation = environment.getRequiredProperty("store.location");
		//If that folder is not available, create that folder
		File storeFile = new File(storeLocation);
		if(!storeFile.exists())
			storeFile.mkdir();
		//Get InputStreams representing uploaded files content
		MultipartFile resumeFile = applicantData.getResume();
		MultipartFile photoFile  = applicantData.getPhoto();
		InputStream resumeFileIS = resumeFile.getInputStream();
		InputStream photoFileIS  = photoFile.getInputStream();
		//Create OutputStreams representing destination files
		OutputStream resumeFileOS = new FileOutputStream(storeLocation+"/"+applicantData.getResume().getOriginalFilename());
		OutputStream photoFileOS  = new FileOutputStream(storeLocation+"/"+applicantData.getPhoto().getOriginalFilename());
		//Copy InputStreams data into OutputStreams
		IOUtils.copy(photoFileIS, photoFileOS);
		IOUtils.copy(resumeFileIS, resumeFileOS);
		//Close Input & Output streams
		resumeFileIS.close();
		resumeFileOS.close();
		photoFileIS.close();
		photoFileOS.close();
		//Copy ApplicantData object data into Applicant object
		Applicant applicant = new Applicant();
		applicant.setName(applicantData.getName());
		applicant.setMobile(applicantData.getMobile());
		applicant.setEmail(applicantData.getEmail());
		applicant.setAddress(applicantData.getAddress());
		applicant.setDob(applicantData.getDob());
		applicant.setQualification(applicantData.getQualification());
		applicant.setResumePath(storeLocation+"/"+applicantData.getResume().getOriginalFilename());
		applicant.setPhotoPath(storeLocation+"/"+applicantData.getPhoto().getOriginalFilename());
		//Copy generated id value to ApplicantData
		applicant = repository.save(applicant);
		applicantData.setId(applicant.getId());
		//return ApplicantData
		return applicantData;
	}

	
	@Override
	public List<Applicant> getJobSeekerReport() {
		return repository.findAll();
	}

	@Override
	public String getResumePathById(Integer id) {
		String resumepath = repository.getResumePath(id);
		return resumepath;
	}

	@Override
	public String getPhotoPathById(Integer id) {
		String photoPath = repository.getPhotoPath(id);
		return photoPath;
	}

	@Override
	public Applicant getApplicantById(Long id) {
		return repository.findById(id).get();
	}
	
}
