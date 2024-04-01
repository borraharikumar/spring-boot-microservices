package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mvc.model.Employee;
import com.mvc.repository.IEmployeeRepository;

@Service
public class EmployeeServiceimpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository repository;

	@Override
	public Employee hireEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee viewEmployee(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public String editEmployee(Employee employee) {
		repository.save(employee);
		return "Employee details with id '" + employee.getId() + "' updated successfully...!";
	}

	@Override
	public List<Employee> getEmployeeReport() {
		return repository.findAll();
	}

	@Override
	public Page<Employee> getEmployeeReport(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public void fireEmployee(Integer id) {
		repository.deleteById(id);
	}

}
