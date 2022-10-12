package com.springboot.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/hello")
	public String helloWorld() {
		return "hello Spring boot..";
	}
}
/*
METHOD
------
INSERTING : POST
DELETING: DELETE
UPDATING: PUT
FETCH: GET
*/