package com.mvc.mp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.mp.model.Employee;
import com.mvc.mp.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
//	@Autowired
//	private EmployeeValidator validator;
	
	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	//hire-employee
	@GetMapping("/hire-employee")
	public String showHireEmployeeFormPage(@ModelAttribute("employee") Employee employee) {
		return "hire_employee";
	}
	
	/*@PostMapping("/hire-employee")
	public String hireEmployee(HttpSession session,
							   @ModelAttribute Employee employee) {
		Employee emp = service.hireEmployee(employee);
		session.setAttribute("message", "Employee hired with employee id :: " + emp.getId());
		return "redirect:employees-report";
	}*/
	
	@PostMapping("/hire-employee")
	public String hireEmployee(RedirectAttributes redirectAttributes,
							   @ModelAttribute Employee employee,
							   BindingResult errors) {
		
		/*//Checking for TypeMismatch errors
		if(errors.hasFieldErrors())
			return "hire_employee";
		//Application specific errors
		if(employee.getDesignation().equalsIgnoreCase("hacker")) {
			errors.rejectValue("designation", "designation.reject");
			return "hire_employee";
		}
		//Form validations
		if(validator.supports(employee.getClass())) {
			validator.validate(employee, errors);
			if(errors.hasErrors())
				return "hire_employee";
		}*/
		//Business logic
		Employee emp = service.hireEmployee(employee);
		redirectAttributes.addFlashAttribute("message", "Employee hired with employee id :: " + emp.getId());
		return "redirect:employees-report";
	}
	
	/*@PostMapping("/hire-employee")
	public String hireEmployee(Map<String, Object> map,
							   @ModelAttribute Employee employee) {
		Employee emp = service.hireEmployee(employee);
		map.put("employeeList", service.employeesReport());
		map.put("message", "Employee hired with employee id :: " + emp.getId());
		return "employees_report";
	}*/
	
	//employees-report
	@GetMapping("/employees-report")
	public String showEmployeesReport(Map<String, Object> map,
									  @ModelAttribute("employee") Employee employee) {
		map.put("employeeList", service.employeesReport());
		return "employees_report";
	}
	
	//edit-employee
	@GetMapping("/edit-employee")
	public String showEditEmployeeFormPage(Map<String, Object> map,
										   @RequestParam("id") Integer id) {
		map.put("employee", service.getEmployeeDetails(id));
		return "edit_employee";
	}
	
	@PostMapping("/edit-employee")
	public String editEmployee(RedirectAttributes redirectAttributes,
							   @ModelAttribute Employee employee,
							   BindingResult errors) {
		/*//Checking for type mismatch errors
		if(errors.hasFieldErrors())
			return "edit_employee";
		//Application specific error
		if(employee.getDesignation().equalsIgnoreCase("hacker")) {
			errors.rejectValue("designation", "designation.reject");
			return "edit_employee";
		}
		//Form validation errors
		if(validator.supports(employee.getClass())) {
			validator.validate(employee, errors);
			if(errors.hasErrors())
				return "edit_employee";
		}*/
		//Business logic
		service.hireEmployee(employee);
		redirectAttributes.addFlashAttribute("message", "Employee with id '" + employee.getId() + "' details are Updated");
		return "redirect:employees-report";
	}
	
	//delete-employee
	@GetMapping("/delete-employee")
	public String fireEmployee(@RequestParam("id") Integer id, Map<String, Object> map) {
		String msg = service.fireEmployee(id);
		map.put("message", msg);
		map.put("employeeList", service.employeesReport());
		return "employees_report";
	}

}
