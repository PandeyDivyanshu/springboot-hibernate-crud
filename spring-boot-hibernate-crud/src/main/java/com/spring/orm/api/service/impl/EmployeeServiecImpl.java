package com.spring.orm.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.orm.api.exception.ResourceNotFoundException;
import com.spring.orm.api.model.Employee;
import com.spring.orm.api.repository.EmployeeRepository;
import com.spring.orm.api.service.EmployeeService;

@Service
public class EmployeeServiecImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;


	public EmployeeServiecImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		//		Optional<Employee> employee = employeeRepository.findById(id);
		//		if(employee.isPresent()) {
		//			return employee.get();
		//		}
		//		else {
		//			throw new ResourceNotFoundException("Employee", "Id", id);
		//		}

		//using java8 optional feature
		return employeeRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployeeById(long id, Employee employee) {

		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}
	
	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

}
