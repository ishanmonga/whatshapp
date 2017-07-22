package com.whatsHapp.userProfile;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component("userProfileFacade")
public class UserProfileFacade {
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	UserProfileValidator userProfileValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userProfileValidator);
	}
	
//	@Autowired
//	RestValidationErrorHandler restValidationErrorHandler;
	
	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	
	public void setUserProfileValidator(UserProfileValidator userProfileValidator) {
		this.userProfileValidator = userProfileValidator;
	}
	public ArrayList<UserProfileModel> getUserProfileLst() {
		// TODO Auto-generated method stub
		return userProfileService.getUserProfileLst();
	}

	public UserProfileModel getUserProfile(long id) {
		// TODO Auto-generated method stub
		return userProfileService.getUserProfile(id);
	}

	public String createUserProfile(@ModelAttribute UserProfileModel catdata, BindingResult result) {
		// TODO Auto-generated method stub
		return userProfileService.createUserProfile(catdata);
//		userProfileValidator.validate(catdata, result);
//		    if (result.hasErrors()) {
//		    	List<FieldError> fieldErrors = result.getFieldErrors();
//		    	 
//		       // return restValidationErrorHandler.processFieldErrors(fieldErrors); 
//		    } else {
//		    	return userProfileService.createUserProfile(catdata);
//		    }
//			return null;
			
		
		
	}

	public String editUserProfile(UserProfileModel catdata) {
		// TODO Auto-generated method stub
		return userProfileService.editUserProfile(catdata);
	}

	public String deleteUserProfile(long id) {
		// TODO Auto-generated method stub
		return userProfileService.deleteUserProfile(id);
	}

	
}
