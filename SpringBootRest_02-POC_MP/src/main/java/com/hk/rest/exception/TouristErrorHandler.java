package com.hk.rest.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TouristErrorHandler {
	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFoundException(TouristNotFoundException exception) {
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), "Tourist not found with given id");
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleException(Exception exception) {
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), "Internal error");
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
