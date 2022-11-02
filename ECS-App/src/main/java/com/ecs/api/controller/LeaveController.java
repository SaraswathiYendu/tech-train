package com.ecs.api.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecs.api.dto.ResLeaveDto;
import com.ecs.api.exception.InvalidIdException;
import com.ecs.api.exception.ResourceNotFoundException;
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
		leave.setIsArchived(false);
		
		leave.setEmployee(employee);
		leaveRepository.save(leave);
	}
	
	@GetMapping("/all")
	public List<ResLeaveDto> getAllNonArchivedLeaves(Principal principal) {
		String username = principal.getName();	
		List<Leave> list = leaveRepository.getLeavesByEmployeeUsername(username, false);
		List<ResLeaveDto> listDto = ResLeaveDto.convertToDto(list);
		return listDto; 
	}
	@GetMapping("/pending/all/{status}")
	public List<ResLeaveDto> getAllNonArchivedPendingLeavesByManager(
			Principal principal, @PathVariable("status") String status) {
		
		String usernameManager = principal.getName();
		boolean isArchived=false;
		List<Leave> list = 
				leaveRepository.getAllNonArchivedPendingLeavesByManager
									(usernameManager,status,isArchived );
		
		List<ResLeaveDto> listDto = ResLeaveDto.convertToDto(list);
		return listDto; 
		
	}
	@PutMapping("/update/status/{id}/{status}")
	public void updateLeaveStatus(
			@PathVariable("status") String status,
			@PathVariable("id") Long id) {
		
		Leave leave = leaveRepository.findById(id)
		.orElseThrow(()->new ResourceNotFoundException("Invalid Leave ID given") );
		
		leave.setStatus(status);
		leaveRepository.save(leave);
	}
	
	@PutMapping("/update/archive/{id}/{archive}")
	public void updateLeaveArchiveValue(
			@PathVariable("archive") String archive,
			@PathVariable("id") Long id) {
		
		Leave leave = leaveRepository.findById(id)
		.orElseThrow(()->new InvalidIdException("Invalid Leave ID provided") );
		
		leave.setIsArchived(true);
		leaveRepository.save(leave);
	}
}
