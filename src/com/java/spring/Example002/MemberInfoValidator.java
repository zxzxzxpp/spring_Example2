package com.java.spring.Example002;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class MemberInfoValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return MemberInfo.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.address1", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.address2", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobCode", "required");
		
		MemberInfo memberInfo = (MemberInfo)target;
		if(memberInfo.getFavorites()==null || memberInfo.getFavorites().length==0){
			errors.rejectValue("favorites" , "must_select");
		}
		
	}
}
