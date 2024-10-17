package com.sharzoid.custom.annoations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
	
	String message;

	@Override
	public void initialize(PhoneNumber number) {
		//this.message = number.message();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length() == 0) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("{phonenumber.message.not.empty}").addConstraintViolation();
			return false;
		}
			
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isDigit(value.charAt(i))) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("{phonenumber.message.not.digit}").addConstraintViolation();
				return false;
			}
		}
		if(value.length() != 10) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("{phonenumber.message.size}").addConstraintViolation();
			return false;
		}
		
		return true;
	}

}
