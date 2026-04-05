package com.mb.spring.util;

import com.mb.spring.util.ValidEmail;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidate  implements ConstraintValidator<ValidEmail, String>{

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (email == null) {
            return false;
        }

        return email.endsWith("@mb.com");
	}

}
