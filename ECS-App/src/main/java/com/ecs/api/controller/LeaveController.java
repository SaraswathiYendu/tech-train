package com.ecs.api.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecs.api.model.Employee;
import com.ecs.api.model.Leave;
import com.ecs.api.repository.EmployeeRepository;
import com.ecs.api.repository.LeaveRepository;

@RestController
@RequestMapping("/api/leave")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
public class LeaveController {

	@Autowired
	private LeaveRepository leaveRepository;
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@PostMapping("/add")
	public void postLeave(@RequestBody Leave leave, Principal principal) {
		String username = principal.getName();
		/* Fetch employee by username */
		Employee employee = employeeRepository.getEmployeeByUsername(username);
		
		/* Set other properties of leave model */
		leave.setAppliedAt(LocalDate.now());
		leave.setStatus("PENDING");
		
		leave.setEmployee(employee);
		leaveRepository.save(leave);
	}
}
