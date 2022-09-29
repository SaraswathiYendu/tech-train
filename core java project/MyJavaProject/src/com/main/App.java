package com.main;

import java.util.List;

import com.main.model.Employee;
import com.main.service.EmployeeService;

public class App {
	public static void main(String[] args) {
		/* Reach out to Employee Service  */
		EmployeeService employeeService = new EmployeeService();
		List<Employee> list = employeeService.getAllEmployees();
		
		if(list != null)
			for(Employee e : list) {
				System.out.println(e);
			}
		
	}
}











