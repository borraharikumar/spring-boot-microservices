package com.mvc.mp.validations;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.mp.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Type casting target object into Model object
		Employee emp = (Employee) target;
		
		//Form validations logic
		
		//name validation
		String name = emp.getName();
		if(name.equals("") || name==null || name.length()==0)
			errors.rejectValue("name", "name.required");
		else if(name.length()>20)
			errors.rejectValue("name", "name.maxlength");
		//mobile validation
		Long mobile = emp.getMobile();
		if(mobile==null)
			errors.rejectValue("mobile", "mobile.required");
		else if(mobile.toString().length()!=10)
			errors.rejectValue("mobile", "mobile.maxlength");
		//email validation
		String email = emp.getEmail();
		if(email.equals("") || email==null || email.length()==0)
			errors.rejectValue("email", "email.required");
		else if(email.length()>20)
			errors.rejectValue("email", "email.maxlength");
		//address validation
		String address = emp.getAddress();
		if(address.equals("") || address==null || address.length()==0)
			errors.rejectValue("address", "address.required");
		else if(address.length()>20)
			errors.rejectValue("address", "address.maxlength");
		//hireDate validation
		LocalDate hireDate = emp.getHireDate();
		if(hireDate==null)
			errors.rejectValue("hireDate", "hireDate.required");
		else if(hireDate.isAfter(LocalDate.now()))
			errors.reject("hireDate", "hireDate.range");
		//designation validation
		String designation = emp.getDesignation();
		if(designation.length()>10)
			errors.rejectValue("designation", "designation.maxlength");
		//salary validation
		Double salary = emp.getSalary();
		if(salary==null || salary==0) 
			errors.rejectValue("salary", "salary.required");
		else if(salary<10000 || salary>1000000)
			errors.rejectValue("salary", "salary.range");
	}

}
