package com.main.service;

import java.util.ArrayList;
import java.util.List;

import com.main.db.EmployeeDB;
import com.main.model.Employee;

public class EmployeeService {

	public List<Employee> getAllEmployees() {
		//Reach out to EmployeeDB
		EmployeeDB employeeDB = new EmployeeDB();
		List<Employee> list = employeeDB.getAllEmployees();
		return list;
	}

}
