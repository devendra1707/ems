package com.ems;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ems.adg.exception.AdgNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AdgNotFoundException.class)
	public ResponseEntity<String> handleAdgNotFoundException(AdgNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}
