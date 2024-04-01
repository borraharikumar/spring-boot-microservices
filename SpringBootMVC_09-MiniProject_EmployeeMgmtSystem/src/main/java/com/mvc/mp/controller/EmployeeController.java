package com.mvc.mp.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.mp.model.Employee;
import com.mvc.mp.service.IEmployeeService;
import com.mvc.mp.validations.EmployeeValidator;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@Autowired
	private EmployeeValidator validator;
	
	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/hire-employee")
	public String showHireEmployeeForm(@ModelAttribute Employee employee) {
		return "hire_employee";
	}
	
	@PostMapping("/hire-employee")
	public String hireEmployee(@ModelAttribute Employee employee,
							   RedirectAttributes redirectAttributes,
							   BindingResult errors) {
		if(employee.getVflag()=="no") {
			//Checking for type mismatch errors
			if(errors.hasFieldErrors())
				return "hire_employee";
			//Form validations logic
			if(validator.supports(employee.getClass())) {
				validator.validate(employee, errors);
				if(errors.hasErrors())
					return "hire_employee";
			}
		}
		//Application error validations
		if(employee.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
			return "edit_employee";
		}
		Employee emp = service.saveEmployee(employee);
		redirectAttributes.addFlashAttribute("message", "Employee hired with id '" + emp.getId() + "' successfully...!");
		return "redirect:employee-report";
	}
	
	@GetMapping("/employee-report")
	public String employeeReport(@PageableDefault(page=0,size=5,sort="id",direction=Sort.Direction.ASC) Pageable pageable,
								 @ModelAttribute Employee employee,
								 Map<String, Object> map) {
		map.put("empList", service.getEmployeePageData(pageable));
		return "employee_report";
	}
	
	@GetMapping("/edit-employee")
	public String showEditEmployeeForm(@RequestParam("id") Integer id,
									   Map<String, Object> map) {
		map.put("employee", service.getEmployee(id));
		return "edit_employee";
	}
	
	
	
	@PostMapping("/edit-employee")
	public String editEmployee(RedirectAttributes redirectAttributes,
							   @ModelAttribute Employee employee,
							   BindingResult errors) {
		if(employee.getVflag()=="no") {
			//Checking for type mismatch errors
			if(errors.hasFieldErrors())
				return "edit_employee";
			//Form validation logic
			if(validator.supports(employee.getClass())) {
				validator.validate(employee, errors);
				if(errors.hasErrors())
					return "edit_employee";
			}
		}
		//Application error validations
		if(employee.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
			return "edit_employee";
		}
		//Business logics
		service.editEmployee(employee);
		redirectAttributes.addFlashAttribute("message", "Employee details with id '" + employee.getId() + "'  are Updated successfully...!");
		return "redirect:employee-report";
	}
	
	@GetMapping("/fire-employee")
	public String fireEmployee(@RequestParam("id") Integer id,
							   RedirectAttributes redirectAttributes) {
		service.deleteEmployee(id);
		redirectAttributes.addFlashAttribute("message", "Employee with id '" + id + "' is fired...!");
		return "redirect:employee-report";
	}
	
	@ModelAttribute("countries")
	public Set<String> getAllCountries(){
		return service.getCountries();
	}
	
	@PostMapping("/requestStates")
	public String getStates(@RequestParam("country") String country,
						    @ModelAttribute Employee employee,
						    Map<String, Object> map) {
		System.err.println("EmployeeController.getStates()");
		map.put("states", service.getStatesByCountry(country));
		return "hire_employee";
	}

}
