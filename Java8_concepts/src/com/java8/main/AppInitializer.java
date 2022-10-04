package com.java8.main;

import java.util.Arrays;
import java.util.List;

public class AppInitializer {
	public static void main(String[] args) {
		Employee e1 = new Employee(1,"harry","IT",85000);
		Employee e2 = new Employee(2,"ronald","ADMIN",75000);
		Employee e3 = new Employee(3,"hermione","IT",95000);
		
		List<Employee> empList = Arrays.asList(e1,e2,e3);
		
		EmployeeService service = new EmployeeService();
		System.out.println("Employees that belong to IT department");
		service.filterEmployeeList( (List<Employee> list)-> {
		list.stream()
			.filter(e->e.getBranch().equalsIgnoreCase("IT"))
			.forEach(e-> System.out.println(e));
		}, empList);
		
		System.out.println("Employees having salary > 80000");
		service.filterEmployeeList((List<Employee> list)-> {
		list.stream()
			.filter(e->e.getSalary()>80000)
			.forEach(e-> System.out.println(e));
		}, empList);
		
		System.out.println("Employees having salary < 80000");
		service.filterEmployeeList((List<Employee> list)-> {
			list.stream()
				.filter(e->e.getSalary()<80000)
				.forEach(e-> System.out.println(e));
			}, empList);
	}
	
	  
}
