package com.mb.spring.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String message) {
        super(message); // Pass the message to the parent constructor
    }
}
