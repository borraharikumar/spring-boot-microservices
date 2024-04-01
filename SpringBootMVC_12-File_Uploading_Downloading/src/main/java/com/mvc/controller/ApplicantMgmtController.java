package com.mvc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.model.ApplicantData;
import com.mvc.service.IApplicantService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ApplicantMgmtController {
	
	@Autowired
	private IApplicantService service;
	
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/register-applicant")
	public String registerApplicantFormPage(@ModelAttribute ApplicantData applicantData) {
		return "register_applicant";
	}
	
	@PostMapping("/register-applicant")
	public String registerApplicant(@ModelAttribute ApplicantData applicantData,
									Map<String, Object> map) throws IOException {
		applicantData = service.register(applicantData);
		map.put("message", "Job seeker is registered with id : '" + applicantData.getId() + "' successfully...!");
		return "result_page";
	}
	
	@GetMapping("/jobseeker-report")
	public String jobSeekerReport(Map<String, Object> map) {
		map.put("jobSeekerList", service.getJobSeekerReport());
		return "jobseeker_report";
	}
	
	@GetMapping("/download")
	public void downloadFile(HttpServletResponse response,
							 @RequestParam("id") Integer id,
							 @RequestParam("type") String type) throws IOException {
		//Get the pathy of the file to be downloaded
		String filePath = null;
		if(type.equalsIgnoreCase("resume"))
			filePath = service.getResumePathById(id);
		else if(type.equalsIgnoreCase("photo"))
			filePath = service.getPhotoPathById(id);
		System.err.println(filePath);
		//Create a file object representing the file to be downloaded
		File file = new File(filePath);
		//Get the file length & make response content length as the file content length
		response.setContentLengthLong(file.length());
		//Get MIME type of the file & make it as the response content type
		String mimeType = servletContext.getMimeType(filePath);
		mimeType = (mimeType==null?"application/octet-stream":mimeType);
		response.setContentType(mimeType);
		//Create InputStream pointing to file object
		InputStream is = new FileInputStream(file);
		//Create OutputStream object pointing to Response object
		OutputStream os = response.getOutputStream();
		//Instruct the browser to give file content type as downloadable file
		response.setHeader("Content-Disposition", "attachment;fileName="+id+"_"+file.getName());
		//Write file content to response object
		IOUtils.copy(is, os);
		//Close the stream objects
		is.close();
		os.close();
	}

}
