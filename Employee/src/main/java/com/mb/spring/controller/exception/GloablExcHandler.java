package com.mb.spring.controller.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GloablExcHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> usernotfoun(UserNotFoundException user){
		return new ResponseEntity<String>("id does not exist", HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidation(ConstraintViolationException ex){

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getLocalizedMessage());
    }
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {
//
//        Map<String, String> errors = new HashMap<>();
//
//        ex.getBindingResult().getFieldErrors()
//            .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
//
//        return errors;
//    }

	
}
