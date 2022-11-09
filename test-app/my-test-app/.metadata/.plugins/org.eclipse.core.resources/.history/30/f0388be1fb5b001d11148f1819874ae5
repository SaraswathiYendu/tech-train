package com.sonarqube.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonarqube.app.service.MessageService;

@RestController
@RequestMapping("/api/message")
public class MessageController {

	@Autowired
	private MessageService messageService; 
	
	@GetMapping("/one")
	public String getMessage() {
		/* Go to Service class and fetch the message */
		String message = messageService.getMessage("geoff");
		return message; 
	}	
}
