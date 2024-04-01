package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.model.Employee;
import com.mvc.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository repository;

	@Override
	public List<Employee> getEmployeeReport() {
		return repository.findAll();
	}

}
