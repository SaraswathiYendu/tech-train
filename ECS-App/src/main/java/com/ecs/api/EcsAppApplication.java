package com.ecs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
 
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EcsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcsAppApplication.class, args);
	}

	
}
 
//Spring cloud gateway
//starter dependency : spring core, beans, context, web , webmvc 
//spring starter web 