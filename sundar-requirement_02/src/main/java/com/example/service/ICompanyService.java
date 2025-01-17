package com.example.service;

import com.example.entity.Company;

public interface ICompanyService {
	
	public Company saveCompany(Company company);
	public Company getCompany(Long id);

}
