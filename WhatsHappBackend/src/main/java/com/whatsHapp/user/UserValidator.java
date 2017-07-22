package com.whatsHapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.whatsHapp.util.CommonMethods;

@Component("userValidator")
public class UserValidator implements Validator {
	
	@Autowired
	CommonMethods commonMethod;
	
	

	public void setCommonMethod(CommonMethods commonMethod) {
		this.commonMethod = commonMethod;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		 return UserModel.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object o, Errors errors) {

//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userFirstName", "userFirstName.required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userLastName", "userLastName.required");
	}

}

