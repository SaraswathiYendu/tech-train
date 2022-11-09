package com.sonarqube.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sonarqube.app.service.MessageService;

@SpringBootTest
public class MessageServiceTest {

	@Autowired
	MessageService messageService;
	
	@Test
	public void getMessageTest(){
		Assertions.assertEquals("Hey john, You have a call at 12.30PM today with freedy team", 
				messageService.getMessage("john"));
		Assertions.assertEquals("Hey geoff, You have a call at 10AM today with toyota team", 
				messageService.getMessage("geoff"));
	}
}
