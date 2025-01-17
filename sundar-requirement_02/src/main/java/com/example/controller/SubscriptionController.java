package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Company;
import com.example.service.ICompanyService;
import com.example.util.KeyUtil;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

	@Autowired
	private ICompanyService service;
	@Autowired
	private KeyUtil keyUtil;

	// http://localhost:9000/subscription/generate-key/
	@PostMapping("/generate-key")
	public ResponseEntity<String> generateKey(@RequestBody Company company) {
		String subscriptionKey = keyUtil.encodeCompanyDetails(company);
		company.setSubscriptionKey(subscriptionKey);
		service.saveCompany(company);
		return ResponseEntity.ok(subscriptionKey);
	}

}
