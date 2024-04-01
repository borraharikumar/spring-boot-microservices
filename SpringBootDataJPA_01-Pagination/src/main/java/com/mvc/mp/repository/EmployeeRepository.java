package com.mvc.mp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.mp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
