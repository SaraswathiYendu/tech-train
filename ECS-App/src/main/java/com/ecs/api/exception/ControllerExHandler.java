package com.ecs.api.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecs.api.dto.ResponseDto;

@ControllerAdvice
public class ControllerExHandler {

	@Autowired
	ResponseDto responseDto; 
	
	@ExceptionHandler(ResourceNotFoundException.class) //global exception handler
	public ResponseEntity<ResponseDto> throwResourceNotFoundException
									(ResourceNotFoundException ex) {
		responseDto.setMsg(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);	 
	}
	
	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<ResponseDto> throwInvalidIdException(InvalidIdException ex) {
		responseDto.setMsg(ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);	 
	}
}
/* 
 ExceptionHandler tells spring to call the method, where this annotation is present for 
 given exception. 
 For ex. If ResourceNotFoundException is thrown in controller, Spring will call 
 this method and will return ResponseEntity. 
 So we don't get 500 status and exception in the stack trace. 
 OUT EXCEPTION GETS HANDLED GLOBALLY */
