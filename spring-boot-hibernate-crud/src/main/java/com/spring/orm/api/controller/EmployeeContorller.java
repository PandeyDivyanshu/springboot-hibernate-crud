package com.spring.orm.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.orm.api.model.Employee;
import com.spring.orm.api.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeContorller {

	private EmployeeService employeeService;

	public EmployeeContorller(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	//create employee api
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	//get employee api
	@GetMapping
	public List<Employee> getEmployees(@RequestBody Employee employee){
		return employeeService.getAllEmployees();
	}

	//get employee by id api
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployees(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}

	//update employee api
	@PutMapping("{id}")
	public ResponseEntity<Employee> saveEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployeeById(employeeId, employee), HttpStatus.OK);
	}
	
	//delete employee by id api
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployees(@PathVariable("id") long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>("Employee with id " + employeeId + " is deleted", HttpStatus.OK);
	}
}
