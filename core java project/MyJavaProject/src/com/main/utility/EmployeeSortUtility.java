package com.main.utility;

import java.util.Comparator;

import com.main.model.Employee;

public class EmployeeSortUtility implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		//ASC order  12000 13000 = -1000
		return (int)(e1.getSalary() - e2.getSalary());
		 
	}
	
} 