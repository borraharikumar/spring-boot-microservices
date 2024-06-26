package com.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
