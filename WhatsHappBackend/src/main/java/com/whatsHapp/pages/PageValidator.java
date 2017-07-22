package com.whatsHapp.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.whatsHapp.util.CommonMethods;

@Component("pageValidator")
public class PageValidator implements Validator {
	
	@Autowired
	CommonMethods commonMethod;
	
	

	public void setCommonMethod(CommonMethods commonMethod) {
		this.commonMethod = commonMethod;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		 return PageModel.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object o, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pageName", "pageName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pageUrl", "pageUrl.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pageContent", "pageContent.required");
	}

}

