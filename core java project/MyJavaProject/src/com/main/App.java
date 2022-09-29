package com.main;

import java.util.List;
import java.util.Scanner;

import com.main.model.Employee;
import com.main.service.EmployeeService;

public class App {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		/* Reach out to Employee Service  */
		EmployeeService employeeService = new EmployeeService();
		
		while(true) { 
			System.out.println("*******MENU*********");
			System.out.println("1. Display all employees");
			System.out.println("2. Insert an Employee");
			System.out.println("3. Delete an Employee");
			System.out.println("4. Fetch as per the Filter");
			System.out.println("5. Employee Statistics");
			System.out.println("0. Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting.. Bye!!");
				break; 
			}
			switch(input) {
			case 1: 
				List<Employee> list = employeeService.getAllEmployees();
				if(list != null)
					for(Employee e : list) {
						System.out.println(e);
					}
				break; 
			case 2: 
				break;
			case 3: 
				break; 
			case 4: 
				break;
			case 5: 
				break; 
			default: 
				System.out.println("Invalid Option");
				break;
			}
		}
		
	}
}











