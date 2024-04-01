package com.hk.rest.service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CricketerExceptionHandler {
	
	@ExceptionHandler(CricketerNotFoundException.class)
	public ResponseEntity<ErrorDetails> cricketerNotFoundException(CricketerNotFoundException exception, HttpRequest request) {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setMessage(exception.getMessage());
		errorDetails.setStatus(HttpStatus.NOT_FOUND);
		errorDetails.setPath(request.getURI().toString());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
