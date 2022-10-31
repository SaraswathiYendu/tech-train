package com.ecs.api.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecs.api.dto.ReqEmployeeDto;
import com.ecs.api.dto.ResponseDto;
import com.ecs.api.model.Employee;
import com.ecs.api.model.Manager;
import com.ecs.api.model.User;
import com.ecs.api.repository.EmployeeRepository;
import com.ecs.api.repository.ManagerRepository;
import com.ecs.api.repository.UserRepository;

@RestController
@RequestMapping("api/employee")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
public class EmployeeController {

	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ResponseDto responseDto;
	/*
	 * Path: /api/employee/add/:managerId
	 * Desc: Post employee in the DB
	 */
	@PostMapping("/add/{managerId}")
	public ResponseEntity<Object> postEmployee(@RequestBody ReqEmployeeDto employeeDto, 
							 @PathVariable("managerId") Long managerId) {
		
		/* Fetch Manager Record from DB using managerId */
		Optional<Manager> optional = managerRepository.findById(managerId);
		
		if(!optional.isPresent()) {
			responseDto.setMsg("Manager ID Invalid");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(responseDto);
		}
		
		Manager manager = optional.get();
		
		/* Fetch User from request body and save it in DB */
 		User user = new User(); //this user does not have an ID
 		user.setUsername(employeeDto.getUsername());
 		user.setPassword(employeeDto.getPassword());
		user.setRole("EMPLOYEE");
		user.setEnabled(false);
		
		/* Encrypt the password */
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		user = userRepository.save(user); //spring will assign an ID to this user
		
		/* Attach the saved User & manager to employee and persist/save the employee in DB*/
		Employee employee = new Employee();
		employee.setName(employeeDto.getName());
		employee.setJobTitle(employeeDto.getJobTitle());
		employee.setUser(user);
		
		/* Attach Manager to employee*/
		employee.setManager(manager);
		
		employeeRepository.save(employee);
		
		responseDto.setMsg("Sign Up Success");
		return ResponseEntity.status(HttpStatus.OK)
				.body(responseDto);
	}
	
	@GetMapping("/manager/all")
	public List<ReqEmployeeDto> getEmployeesByManagerUser(Principal principal) {
		String username = principal.getName();
		System.out.println(username);
		/* fetch all employees by manager email */
		List<Employee>  list = employeeRepository.getEmployeesByManagerUser(username,false);
		List<ReqEmployeeDto> listDto = ReqEmployeeDto.convert(list);
		return listDto;
	}
}
