package com.java8.main;

import java.util.List;

public class EmployeeService {
	
	public void filterEmployeeList(EmployeeStream s, List<Employee> list) {
		s.filter(list);
	}
}
