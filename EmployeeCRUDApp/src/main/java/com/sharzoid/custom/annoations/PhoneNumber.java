package com.sharzoid.custom.annoations;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR })
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {
	
	String message() default "{phonenumber.message}";
	
	int size() default 10;
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
