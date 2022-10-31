package com.ecs.api.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecs.api.dto.ResponseDto;
import com.ecs.api.model.User;
import com.ecs.api.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
public class UserController {
  
	@Autowired
	private UserRepository userRepository; 
	@Autowired
	private ResponseDto responseDto; 
	
	@GetMapping("/login") //-- i will let u call this login if credentials are right
	public Object login(Principal principal) {
		 
		String username = principal.getName();
		/* Fetch user from DB using username */
		User user = userRepository.getUserByUsername(username);
		if(user == null) {
			responseDto.setMsg("Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDto);
		}
		user.setPassword("");
		if(user.isEnabled() == false) {
			responseDto.setMsg("User not enabled");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseDto);
		}
		return user; 
	}
}
/* 
 DELETE: 
 POST: 
 status : null : 200 (200,400, 401, 403 , 500 )
 next() => ()=> { api success  }
 error() => () => { api fail }
 
 ResponseEntity: status: 403, "User not enabled"
 {"msg": "User not enabled" }
 */