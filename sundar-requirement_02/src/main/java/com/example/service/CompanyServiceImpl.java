package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Company;
import com.example.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements ICompanyService {
	
	@Autowired
	private CompanyRepository repository;

	@Override
	public Company saveCompany(Company company) {
		return repository.save(company);
	}

	@Override
	public Company getCompany(Long id) {
		return repository.findById(id).orElseThrow();
	}

}
