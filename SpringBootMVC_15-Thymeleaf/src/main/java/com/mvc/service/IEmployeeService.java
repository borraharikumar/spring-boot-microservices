package com.mvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mvc.model.Employee;

public interface IEmployeeService {
	
	public Employee hireEmployee(Employee employee);
	public Employee viewEmployee(Integer id);
	public String editEmployee(Employee employee);
	public List<Employee> getEmployeeReport();
	public Page<Employee> getEmployeeReport(Pageable pageable);
	public void fireEmployee(Integer id);
	
}
