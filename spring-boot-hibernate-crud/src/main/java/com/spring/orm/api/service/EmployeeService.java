package com.spring.orm.api.service;

import java.util.List;

import com.spring.orm.api.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployeeById(long id, Employee employee);
	void deleteEmployee(long id);
}
