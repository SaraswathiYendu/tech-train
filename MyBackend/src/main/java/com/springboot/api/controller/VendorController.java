package com.springboot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.User;
import com.springboot.api.model.Vendor;
import com.springboot.api.repository.UserRepository;
import com.springboot.api.repository.VendorRepository;

@RestController
public class VendorController {

	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private PasswordEncoder encoder; 
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@PostMapping("/vendor/add")
	public void addVendor(@RequestBody Vendor vendor) {
		/* Fetch User info from Customer */
		User user = vendor.getUser();
		if(user == null) {
			throw new RuntimeException("User data not present");
		}
		/* Attach Role */	
		user.setRole("VENDOR");
		
		/* Encrypt the password */
		String encryptedPassword = encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		
		/* Save this User in DB(you get the ID assigned) 
		 * and attach the User again to customer */
		user = userRepository.save(user); //had an ID
		vendor.setUser(user);
		
		/* Save the Customer */
		vendorRepository.save(vendor);
	}
}
