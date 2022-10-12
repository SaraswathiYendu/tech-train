package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Department;
import com.springboot.api.model.Employee;
import com.springboot.api.service.DepartmentService;
import com.springboot.api.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService; 
	
	@PostMapping("/employee/add/{did}")
	public Employee insertEmployee(@RequestBody Employee employee, 
								   @PathVariable("did") Long did) {
		//Step 1: Go to DB and fetch department record
		Department department = departmentService.getDepartmentById(did);
		
		//Step 2: attach this department to employee
		employee.setDepartment(department);
		
		//Step 3: Save the Employee
		employee = employeeService.insertEmployee(employee);
		return employee;
	}
	
	@GetMapping("/employees/all")
	public List<Employee> getAllEmployees() {
		List<Employee> list =employeeService.getAllEmployees();
		return list; 
	}
	
	@DeleteMapping("/employee/delete/v1/{id}") ///employee/delete/v1/1
	public void deleteById(@PathVariable("id") Long id) {
		employeeService.deleteById(id);
	}
	
	@DeleteMapping("/employee/delete/v2") ///employee/delete/v2?id=1
	public void deleteEmployeeByIdV2(@RequestParam("id") Long id) {
		employeeService.deleteById(id);
	}
	
	@PutMapping("/employee/edit/{id}")
	public Employee editEmployee(@PathVariable("id") Long id, @RequestBody Employee employeeNew) {
		//Step 1: Take the ID and fetch the record from the DB 
		Employee employeeDB = employeeService.findEmployeeById(id); //existing employee
		if(employeeDB == null)
			throw new RuntimeException("ID Invalid");
		//Step 2: Transfer the new values into old employee object. Don't change the ID
		employeeDB.setName(employeeNew.getName());
		employeeDB.setCity(employeeNew.getCity());
		employeeDB.setSalary(employeeNew.getSalary());
		//Step 3
		employeeDB = employeeService.insertEmployee(employeeDB);
		return employeeDB;
	}
	
	/* get all employees by city */
	@GetMapping("/employee/city/v1")
	public List<Employee> getEmployeesByCity(@RequestParam("city") String city){
		return employeeService.getEmployeesByCity(city);
	}
	
	/* get all employee that belong to certain department */
	@GetMapping("/employee/department/v1/{did}")
	public List<Employee> getEmployeesByDepartment(@PathVariable("did") Long did){
		return employeeService.getEmployeesByDepartment(did);
	}
	
	/* get all employees by city using jpql */
	@GetMapping("/employee/city/v2")
	public List<Employee> getEmployeesByCityV2(@RequestParam("city") String city){
		return employeeService.getEmployeesByCityV2(city);
	}
	
	/* get all employee that belong to certain department JPQL*/
	@GetMapping("/employee/department/v2/{did}")
	public List<Employee> getEmployeesByDepartmentV2(@PathVariable("did") Long did){
		return employeeService.getEmployeesByDepartmentV2(did);
	}
}
/*
 * GET POST PUT DELETE
 */
