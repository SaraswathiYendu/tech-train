package com.main.factory;

import java.util.List;

import com.main.model.Employee;
import com.main.service.EmployeeService;

public class EmployeeFactory {

	static EmployeeService employeeService = new EmployeeService();
	
	public static void getAllEmployees(){
		List<Employee> list = employeeService.getAllEmployees();
		if(list != null)
			for(Employee e : list) {
				System.out.println(e);
			}
	}
}
