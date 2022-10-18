package com.springboot.api.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.CustomerDto;
import com.springboot.api.dto.VendorDto;
import com.springboot.api.model.Customer;
import com.springboot.api.model.User;
import com.springboot.api.model.Vendor;
import com.springboot.api.repository.CustomerRepository;
import com.springboot.api.repository.UserRepository;
import com.springboot.api.repository.VendorRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private VendorRepository vendorRepository; 
	
	@GetMapping("/user/login") //<-- authenticated in security config
	public User userLogin(Principal principal) { //<-- DI
		//At this line spring already has username and password of the user.
		
		/* Read the username from spring using Principal */
		String username = principal.getName();
		
		/* fetch user details on the basis of this username */
		User user = userRepository.findByUsername(username);
		
		return user; 
	}
	
	@GetMapping("/user/details")
	public Object getUserDetails(Principal principal) {
		//At this line spring already has username of the user.
		
		/* Read the username from spring using Principal */
		String username = principal.getName();
		
		/* fetch user details on the basis of this username */
		User user = userRepository.findByUsername(username);
		
		if(user.getRole().equalsIgnoreCase("CUSTOMER")) {
			Customer customer = customerRepository.getCustomerDetails(username);
			CustomerDto dto = new CustomerDto(customer.getId(),
											  customer.getName(),
											  customer.getCity(),
											  username);
			
			return dto; 
		}
		if(user.getRole().equalsIgnoreCase("VENDOR")) {
			Vendor vendor = vendorRepository.getVendorDetails(username);
			VendorDto dto = new VendorDto(vendor.getId(),
					vendor.getName(),
					vendor.getCity(),
					  username);
			return dto;
		}
		if(user.getRole().equalsIgnoreCase("ADMIN")) {
			
		}
		return null;
	}
}
