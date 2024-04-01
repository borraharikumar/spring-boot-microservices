package com.hk.rest.runner;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hk.rest.model.Cricketer;

//@Component
public class PostRequestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		Cricketer cricketer = new Cricketer();
		cricketer.setName("Rohit Sharma");
		cricketer.setRole("Batsman");
		cricketer.setBirthPlace("Nagpur");
		cricketer.setBattingStyle("Right handed");
		cricketer.setBowlingStyle("Right handed");
		cricketer.setDob(LocalDate.of(1987, 4, 30));
		String cricketer_json = cricketer.toString();
		
		//Create RestTemplate object
		RestTemplate template = new RestTemplate();
		//Prepare service url
		String url = "http://localhost:8083/SpringBootRest_03-Provider/cricketer/enroll";
		//Prepare HttpHeaders
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		//Prepare HttpRequest as HttpEntity object having header & body
		HttpEntity<String> httpEntity = new HttpEntity<String>(cricketer_json, httpHeaders);
		//Make HttpRequest as post mode request
		ResponseEntity<Cricketer> response = template.postForEntity(url, httpEntity, Cricketer.class);
		
		System.err.println("Response body              :: " + response.getBody());
		System.err.println("Response headers           :: " + response.getHeaders().toString());
		System.err.println("Response status code       :: " + response.getStatusCode());
		
		System.exit(0);
		
	}

}
