package com.hk.rest.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hk.rest.model.Cricketer;

@Component
public class GetRequestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate object
		RestTemplate template = new RestTemplate();
		//Defining URI
		String url = "http://localhost:8083/SpringBootRest_03-Provider/cricketer/find/{id}";
		//Invoke the business method
		ResponseEntity<Cricketer> response = template.exchange(url, HttpMethod.GET, null, Cricketer.class, Map.of("id", 1000));
		
		System.err.println("Response body        :: " + response.getBody());
		System.err.println("Response headers     :: " + response.getHeaders().toString());
		System.err.println("Response status code :: " + response.getStatusCode());
		
		System.exit(0);
		
	}

}
