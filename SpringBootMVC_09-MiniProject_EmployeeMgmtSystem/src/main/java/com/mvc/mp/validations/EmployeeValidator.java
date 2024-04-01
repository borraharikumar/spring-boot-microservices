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
		//Type casting target object into Employee class object
		Employee employee = (Employee) target;
		//Getting properties to validate
		String name = employee.getName();
		String email = employee.getEmail();
		LocalDate hireDate = employee.getHireDate();
		String job = employee.getJob();
		Double salary = employee.getSalary();
		
		//Name validation
		if(name==null || name.length()==0 || name=="")
			errors.rejectValue("name", "name.required");
		else if(name.length()>20)
			errors.rejectValue("name", "name.maxlength");
		//Email validation
		if(email==null || email.length()==0 || email=="")
			errors.rejectValue("email", "email.required");
		else if(name.length()>20)
			errors.rejectValue("email", "email.maxlength");
		else if(!email.contains("@") || !email.contains(".com"))
			errors.rejectValue("email", "email.format");
		//Hire-date validation
		if(hireDate==null)
			errors.rejectValue("hireDate", "hireDate.required");
		else if(hireDate.isAfter(LocalDate.now()))
			errors.rejectValue("hireDate", "hireDate.maxdate");
		//Job validation
		if(job.length()>10)
			errors.rejectValue("job", "job.maxlength");
		//Salary validation
		if(salary==null)
			errors.rejectValue("salary", "salary.required");
		else if(salary<10000 || salary>1000000)
			errors.rejectValue("salary", "salary.range");
			
	}

}
