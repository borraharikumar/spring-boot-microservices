package com.mvc.mp.service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mvc.mp.model.Employee;
import com.mvc.mp.repo.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository repository;
	
	@Autowired
	private Environment environment;

	@Override
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	@Override
	public Employee getEmployee(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public Employee editEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
	
	@Override
	public Page<Employee> getEmployeePageData(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public String deleteEmployee(Integer id) {
		repository.deleteById(id);
		return "Employee with '"+ id + "' is fired...!";
	}
	
	@Override
	public Set<String> getCountries() {
		Locale[] country = Locale.getAvailableLocales();
		Set<String> countrySet = new TreeSet<String>();
		for(Locale c : country) {
			countrySet.add(c.getDisplayCountry());
		}
		return countrySet;
	}
	
	@Override
	public List<String> getStatesByCountry(String country) {
		//Get states of the country by Environment object
		String states = environment.getRequiredProperty(country);
		//Convert comma separated values into List & return it
		return Arrays.asList(states.split(", "));
	}

}