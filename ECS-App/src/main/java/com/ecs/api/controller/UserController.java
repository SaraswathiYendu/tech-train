package com.ecs.api.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecs.api.model.User;
import com.ecs.api.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
public class UserController {

	@Autowired
	private UserRepository userRepository; 
	
	@GetMapping("/login")
	public User login(Principal principal) {
		String username = principal.getName();
		/* Fetch user from DB using username */
		User user = userRepository.getUserByUsername(username);
		user.setPassword("");
		return user; 
		
	}
}
