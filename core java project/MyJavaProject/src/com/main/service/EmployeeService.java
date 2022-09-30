package com.main.service;

import java.util.ArrayList;
import java.util.List;

import com.main.db.EmployeeDB;
import com.main.model.Employee;

public class EmployeeService {

	EmployeeDB employeeDB;
	
	public List<Employee> getAllEmployees() {
		//Reach out to EmployeeDB
		employeeDB = new EmployeeDB();//100X
		List<Employee> list = employeeDB.getAllEmployees();
		employeeDB = null; //employeeDB is ready to be delete. make it garbage and delete it. 
		return list;
	}

	public void insertEmployee(Employee e) {
		employeeDB = new EmployeeDB();//200X
		employeeDB.insertEmployee(e);
		employeeDB = null;
	}

	public void deleteEmployeeById(int id) {
		employeeDB = new EmployeeDB();//300X
		employeeDB.deleteEmployeeById(id);
		employeeDB = null;
		
	}

}
