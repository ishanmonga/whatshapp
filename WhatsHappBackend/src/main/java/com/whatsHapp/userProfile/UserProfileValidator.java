package com.whatsHapp.userProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.whatsHapp.util.CommonMethods;

@Component("userProfileValidator")
public class UserProfileValidator implements Validator {
	
	@Autowired
	CommonMethods commonMethod;
	
	

	public void setCommonMethod(CommonMethods commonMethod) {
		this.commonMethod = commonMethod;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		 return UserProfileModel.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object o, Errors errors) {
		// TODO Auto-generated method stub

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userProfileName", "userProfileName.required");

//		UserProfileModel cat = (UserProfileModel) obj;
//		if (commonMethod.checkEmpty(cat.getUserProfileName())) {
//			errors.rejectValue("id", "negativeValue", new Object[] { "'id'" }, "id can't be negative");
//		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userProfileDesc", "userProfileDesc.required");
	}



}

