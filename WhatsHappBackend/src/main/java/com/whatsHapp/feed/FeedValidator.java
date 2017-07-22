package com.whatsHapp.feed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.whatsHapp.util.CommonMethods;

@Component("feedValidator")
public class FeedValidator implements Validator {
	
	@Autowired
	CommonMethods commonMethod;
	
	

	public void setCommonMethod(CommonMethods commonMethod) {
		this.commonMethod = commonMethod;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		 return FeedModel.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object o, Errors errors) {
		// TODO Auto-generated method stub

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "feedHeading", "feedHeading.required");

//		FeedModel cat = (FeedModel) obj;
//		if (commonMethod.checkEmpty(cat.getFeedName())) {
//			errors.rejectValue("id", "negativeValue", new Object[] { "'id'" }, "id can't be negative");
//		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "feedMessage", "feedMessage.required");
	}



}

