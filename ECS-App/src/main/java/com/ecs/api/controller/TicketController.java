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
import com.ecs.api.model.Ticket;
import com.ecs.api.repository.EmployeeRepository;
import com.ecs.api.repository.TicketRepository;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
public class TicketController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	@PostMapping("/add")
	public void addTicket(@RequestBody Ticket ticket, Principal principal) {
		String username = principal.getName();
		/* Fetch employee by username */
		Employee employee = employeeRepository.getEmployeeByUsername(username);
		
		/* Set other properties of ticket model */
		ticket.setCreatedAt(LocalDate.now());
		ticket.setStatus("OPEN");
		ticket.setEmployee(employee);
		ticketRepository.save(ticket);
	}
	
}
