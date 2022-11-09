package com.junit.mockito.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junit.mockito.app.model.Employee;
import com.junit.mockito.app.repository.EmployeeRepository;

 
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee postEmployee(Employee employee) {
		return employeeRepository.save(employee);	
	}
	
	/* Fetch all records from the DB */
	public List<Employee> getList(){
		return employeeRepository.findAll();
	}
	
}
