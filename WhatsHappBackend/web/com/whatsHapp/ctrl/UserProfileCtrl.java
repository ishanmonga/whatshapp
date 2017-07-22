package com.whatsHapp.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whatsHapp.userProfile.UserProfileFacade;
import com.whatsHapp.userProfile.UserProfileModel;
import com.whatsHapp.userProfile.UserProfileValidator;
@Validated
@RestController
@RequestMapping("/userProfile") 
public class UserProfileCtrl {

	@Autowired
	UserProfileValidator userProfileValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userProfileValidator);
	}

	@Autowired
	UserProfileFacade userProfileFacade;

	public void setUserProfileValidator(UserProfileValidator userProfileValidator) {
		this.userProfileValidator = userProfileValidator;

	}

	public void setUserProfileFacade(UserProfileFacade userProfileFacade) {
		this.userProfileFacade = userProfileFacade;
	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<UserProfileModel>> getCategories() {
		ArrayList<UserProfileModel> categories = userProfileFacade.getUserProfileLst();
		return new ResponseEntity<List<UserProfileModel>>(categories, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserProfileModel> getCatByID(@PathVariable("id") long id) {
		UserProfileModel userProfile = userProfileFacade.getUserProfile(id);
		return  new ResponseEntity<UserProfileModel>(userProfile, HttpStatus.OK);

	}

	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void>  createNewUserProfile(@Valid @RequestBody UserProfileModel userProfileData, BindingResult bindingResult) {
		userProfileData.setCreateDate(new Date());
		String status = userProfileFacade.createUserProfile(userProfileData, bindingResult);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<UserProfileModel>  updateUserProfile(UserProfileModel userProfileData) {
		userProfileData.setLastUpdate(new Date());
		String status = userProfileFacade.editUserProfile(userProfileData);
		return new ResponseEntity<UserProfileModel>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserProfileModel> deleteUserProfileById(@PathVariable("id") long id) {
		String status = userProfileFacade.deleteUserProfile(id);
		return new ResponseEntity<UserProfileModel>(HttpStatus.NO_CONTENT);
	}

}
