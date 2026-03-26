package com.mb.spring.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GloablExcHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> usernotfoun(UserNotFoundException user){
		return new ResponseEntity<String>("Cannot find with id", HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidation(ConstraintViolationException ex){

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("value cannot be 0 or neagative");
    }

	
}
