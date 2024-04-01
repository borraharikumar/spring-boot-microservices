package com.hk.rest.exception;

public class TouristNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TouristNotFoundException(String message) {
		super(message);
	}

}