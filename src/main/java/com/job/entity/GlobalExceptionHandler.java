package com.job.entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
//	@ExceptionHandler(CustomException.class)
//	public ResponseEntity<String> handleJobNotFound(CustomException ex) {
//		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Map<String, Object>> handleCustomException(CustomException ex) {
	    Map<String, Object> errorBody = new HashMap<>();
	    errorBody.put("timestamp", LocalDateTime.now());
	    errorBody.put("status", HttpStatus.NOT_FOUND.value());
	    errorBody.put("error", "Not Found");
	    errorBody.put("message", ex.getMessage());

	    return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}

}