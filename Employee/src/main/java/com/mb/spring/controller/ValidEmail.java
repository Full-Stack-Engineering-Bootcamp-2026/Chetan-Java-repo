package com.mb.spring.controller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.mb.spring.util.EmailValidate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidate.class)

public @interface ValidEmail {
	
	String message() default "Email must end with @mb.com";
	
	Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
