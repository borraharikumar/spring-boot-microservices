package com.hk.eureka.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceLoadBalancingClient {
	
	@Autowired
	private LoadBalancerClient client;
	
	public String getPaymentMethods() {
		ServiceInstance instance = client.choose("BillingService");
		String url = instance.getUri() + "/bill/info";
		ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, null, String.class);
		return response.getBody() + "<br>Port :: " + instance.getPort()
				  + "<br>Service instance :: " + instance.getInstanceId();
	}

}
