package com.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.main.dto.EmployeeStatsDto;
import com.main.exception.InvalidIdException;
import com.main.factory.EmployeeFactory;
import com.main.model.Employee;
import com.main.service.EmployeeService;
import com.main.utility.EmployeeSortUtility;

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
			System.out.println("6. Employee Sorting By Salary-ASC");
			System.out.println("0. Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting.. Bye!!");
				break; 
			}
			switch(input) {
			case 1: 
				EmployeeFactory.getAllEmployees();
				break; 
			case 2: 
				System.out.println("Enter Employee details");
				System.out.println("Enter Name");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter salary");
				double salary = sc.nextDouble();
				System.out.println("Enter branch");
				String branch = sc.next();
				Employee e = new Employee(name,salary,branch);
				employeeService.insertEmployee(e);
				System.out.println("Employee record added to db..");
				break;
			case 3: 
				EmployeeFactory.getAllEmployees();
				System.out.println("Enter Employee ID to delete: ");
				int id = sc.nextInt();
				boolean isValid = employeeService.validateId(id);
				if(isValid == true) {
					employeeService.deleteEmployeeById(id);
					System.out.println("Employee Record deleted from the DB..");
				}
				else
					System.out.println("Invalid ID, Please try again");
				
				break; 
			case 4: 
				System.out.println("Enter the branch to filter the employees: ");
				sc.nextLine();
				branch = sc.nextLine();
				employeeService.filterByBranch(branch);
				break;
			case 5: 
				System.out.println("******Employee Statistics********");
				List<EmployeeStatsDto> list = employeeService.fetchStats();
				list.parallelStream().forEach(emp->System.out.println(emp.getBranch() + "--" + emp.getNum()));
				break;
			case 6: 
				List<Employee> empList = employeeService.getAllEmployees();
				//sort the list as per salary-ASC
				Collections.sort(empList, new EmployeeSortUtility()); //e1(id,branch,name,salary) e2 e3 e4
				
				empList.stream().forEach(emp->System.out.println(emp));
				break;
			default: 
				System.out.println("Invalid Option");
				break;
			}
		}
		sc.close();
	}
}
 







