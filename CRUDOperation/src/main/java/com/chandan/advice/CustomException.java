package com.chandan.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.chandan.customeException.EmptyInputException;
import com.chandan.entity.Employee;


@ControllerAdvice
public class CustomException extends RuntimeException{
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> business(EmptyInputException ex) {
		System.out.println(ex.getMessage());
		return new ResponseEntity<String>("Input Fields is empty, please look into it", HttpStatus.BAD_REQUEST);
	}

}
