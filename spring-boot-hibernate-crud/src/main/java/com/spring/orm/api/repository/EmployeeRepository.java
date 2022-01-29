package com.spring.orm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.orm.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
