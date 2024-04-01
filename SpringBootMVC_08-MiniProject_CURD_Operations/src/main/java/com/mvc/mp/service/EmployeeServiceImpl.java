package com.mvc.mp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mp.model.Employee;
import com.mvc.mp.repo.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository repository;

	@Override
	public Employee hireEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public List<Employee> employeesReport() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeDetails(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public String fireEmployee(Integer id) {
		repository.deleteById(id);
		return "Employee with id '" + id + "' is fired...!";
	}

}
