package com.mvc.mp.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mvc.mp.repository.EmployeeRepository;

@Component
public class EmployeeAppRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		repository.findAll().forEach(x->{
			x.setEmail(x.getEname().toLowerCase() + "@gmail.com");
			repository.save(x);
		});
		
	}

}
