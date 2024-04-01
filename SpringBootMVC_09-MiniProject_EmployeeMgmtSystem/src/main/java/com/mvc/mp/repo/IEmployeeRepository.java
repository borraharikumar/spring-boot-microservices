package com.mvc.mp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.mp.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
