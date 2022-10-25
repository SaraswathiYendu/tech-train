package com.springboot.api.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.ResponseDto;
import com.springboot.api.model.Customer;
import com.springboot.api.model.Policy;
import com.springboot.api.model.User;
import com.springboot.api.repository.CustomerRepository;
import com.springboot.api.repository.PolicyRepository;
import com.springboot.api.repository.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class CustomerController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private CustomerRepository customerRepository; 
	
	@Autowired
	private PasswordEncoder encoder; 
	
	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private ResponseDto response;
	
	@PostMapping("/customer/add")
	public ResponseEntity<Object>  addCustomer(@RequestBody Customer customer) {
		/* Fetch User info from Customer */
		User user = customer.getUser();
		if(user == null) {
			return ResponseEntity.status(400).body("User Data Not Present");
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
		 
		response.setMsg("Sign Up Success");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//{ "msg" : "Sign Up Successful!!"}
	@GetMapping("/customer/policy/{cid}/{pid}")
	public Customer buyPolicy(@PathVariable("cid") Long cid, @PathVariable("pid") Long pid) {
		/* fetch the customer details */
		Optional<Customer> optionalC =  customerRepository.findById(cid);
		if(!optionalC.isPresent()) throw new RuntimeException("Customer ID Invalid"); 
		Customer customer = optionalC.get();
		
		/* fetch the policy details */
		Optional<Policy> optionalP =  policyRepository.findById(pid);
		if(!optionalP.isPresent()) throw new RuntimeException("Policy ID Invalid"); 
		Policy policy = optionalP.get();
		
		/* Attach the policy to customer */
		List<Policy> list = customer.getPolicy(); //list of policies that customer has
		list.add(policy); //add new policy to the list
		customer.setPolicy(list); //attach the updated list to customer 
		
		/* save the customer as its policies have been updated */
		return customerRepository.save(customer);
		
	}
	
	@PostMapping("/policy/add")
	public Policy postPOlicy(@RequestBody Policy policy) {
		return policyRepository.save(policy);
	}
	
	@GetMapping("/customer/all")
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
}











