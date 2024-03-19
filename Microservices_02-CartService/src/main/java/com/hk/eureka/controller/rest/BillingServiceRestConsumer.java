package com.hk.eureka.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumer {
	
	@Autowired
	private DiscoveryClient client;
	
	public String getBillInfo() {
		//Get all the instances of the producer by using auto-configuration
		List<ServiceInstance> serviceInstances = client.getInstances("BillingService");
		//Get ServiceInstance from the list service instances
		ServiceInstance instance = serviceInstances.get(0);
		//Get MicroService URI from service instance and make URL
		String url = instance.getUri() + "/bill/info";
		//Create RestTemplate object
		RestTemplate restTemplate = new RestTemplate();
		//Make a HTTP call using RestTemplate
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		//Return the response
		return response.getBody() + "<br>Port :: " + instance.getPort() + "<br>Instance Id :: " + instance.getInstanceId();
	}

}
