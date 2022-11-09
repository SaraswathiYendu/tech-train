package com.junit.mockito.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.mockito.app.model.Employee;
import com.junit.mockito.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/add")
	public void postEmployee(@RequestBody Employee employee) {
		employeeService.postEmployee(employee);
	}
}
