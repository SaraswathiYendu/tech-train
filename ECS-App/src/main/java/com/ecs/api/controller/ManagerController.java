package com.ecs.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecs.api.model.Manager;
import com.ecs.api.model.User;
import com.ecs.api.repository.ManagerRepository;
import com.ecs.api.repository.UserRepository;

@RestController
@RequestMapping("api/manager")
public class ManagerController {

	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	/*
	 Path: api/manager/add
	 Description: Post manager details
	 Request Body: Manager Object  
	 */
	@PostMapping("/add")   
	public void addManager(@RequestBody Manager manager) {
		/* Fetch User from request body and save it in DB */
 		User user = manager.getUser(); //this user does not have an ID
		user.setRole("MANAGER");
		user.setEnabled(true);
		
		/* Encrypt the password */
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		user = userRepository.save(user); //spring will assign an ID to this user
 		/* Attach the saved User to manager and persist/save the manager in DB*/
		manager.setUser(user);
		managerRepository.save(manager);
	}
}
