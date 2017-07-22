package com.whatsHapp.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.whatsHapp.util.CommonMethods;

@Component("MediaValidator")
public class MediaValidator implements Validator {
	
	@Autowired
	CommonMethods commonMethod;
	
	

	public void setCommonMethod(CommonMethods commonMethod) {
		this.commonMethod = commonMethod;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		 return MediaModel.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object o, Errors errors) {
		// TODO Auto-generated method stub

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "MediaName", "MediaName.required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "MediaDesc", "MediaDesc.required");
	}



}

