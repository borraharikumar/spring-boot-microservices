package com.mvc.mp.service;

import java.util.List;

import com.mvc.mp.model.Employee;

public interface IEmployeeService {
	
	public Employee hireEmployee(Employee employee);
	public List<Employee> employeesReport();
	public Employee getEmployeeDetails(Integer id);
	public String fireEmployee(Integer id);

}
