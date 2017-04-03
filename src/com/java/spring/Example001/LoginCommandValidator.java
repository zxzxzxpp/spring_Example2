package com.java.spring.Example001;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class LoginCommandValidator implements Validator{
	
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginType", "required");
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
	
		return LoginCommand.class.isAssignableFrom(arg0);
	}
}
