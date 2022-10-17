package com.springboot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Customer;
import com.springboot.api.model.User;
import com.springboot.api.repository.CustomerRepository;
import com.springboot.api.repository.UserRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private CustomerRepository customerRepository; 
	
	@Autowired
	private PasswordEncoder encoder; 
	
	@PostMapping("/customer/add")
	public void addCustomer(@RequestBody Customer customer) {
		/* Fetch User info from Customer */
		User user = customer.getUser();
		if(user == null) {
			throw new RuntimeException("User data not present");
		}
		/* Attach Role */	
		user.setRole("CUSTOMER");
		
		/* Encrypt the password */
		String encryptedPassword = encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		
		/* Save this User in DB(you get the ID assigned) 
		 * and attach the User again to customer */
		user = userRepository.save(user); //had an ID
		customer.setUser(user);
		
		/* Save the Customer */
		customerRepository.save(customer);
	}
}
