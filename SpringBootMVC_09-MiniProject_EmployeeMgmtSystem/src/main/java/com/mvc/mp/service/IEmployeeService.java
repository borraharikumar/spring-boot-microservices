package com.mvc.mp.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mvc.mp.model.Employee;

public interface IEmployeeService {
	
	public Employee saveEmployee(Employee employee);
	public Employee getEmployee(Integer id);
	public Employee editEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Page<Employee> getEmployeePageData(Pageable pageable);
	public String deleteEmployee(Integer id);
	
	public Set<String> getCountries();
	public List<String> getStatesByCountry(String country);

}
