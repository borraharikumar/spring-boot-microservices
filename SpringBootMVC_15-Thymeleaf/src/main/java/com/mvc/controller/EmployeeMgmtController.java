package com.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.model.Employee;
import com.mvc.service.IEmployeeService;

@Controller
public class EmployeeMgmtController {
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/hire-employee")
	public String hireEmployeePage(@ModelAttribute Employee employee) {
		return "hire_employee";
	}
	
	@PostMapping("/hire-employee")
	public String hireEmployee(@ModelAttribute Employee employee,
							   RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", "Employee hired with id '"+service.hireEmployee(employee).getId()+"' successfully...!");
		return "redirect:employee-report";
	}
	
	@GetMapping("employee-report")
	public String employeeReport(@PageableDefault(page=0, size=5, direction=Direction.ASC, sort="id") Pageable pageable,
								Map<String, Object> map) {
		map.put("empList", service.getEmployeeReport(pageable));
		return "employee_report";
	}
	
	@GetMapping("/fire-employee")
	public String fireEmployee(@RequestParam Integer id,
							   RedirectAttributes redirectAttributes) {
		service.fireEmployee(id);
		redirectAttributes.addFlashAttribute("message", "Employee with id '"+id+"' is fired...!");
		return "redirect:employee-report";
	}
	
	@GetMapping("/edit-employee")
	public String editEmployeeForm(@ModelAttribute Employee employee,
								   @RequestParam Integer id, Map<String, Object> map) {
		map.put("employee", service.viewEmployee(id));
		return "edit_employee";
	}

}
