package com.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication
public class FileUploadingDownloadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadingDownloadingApplication.class, args);
	}
	
	@Bean("multipartResolver")//Fixed bean id
	MultipartResolver multiPartResolver() {
		return new StandardServletMultipartResolver();
	}

}
