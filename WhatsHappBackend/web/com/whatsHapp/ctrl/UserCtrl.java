package com.whatsHapp.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.whatsHapp.user.UserFacade;
import com.whatsHapp.user.UserModel;
import com.whatsHapp.user.UserValidator;

@Validated
@RestController
@RequestMapping("/user") 
public class UserCtrl {

	@Autowired
	UserValidator userValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@Autowired
	UserFacade userFacade;

	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;

	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<UserModel>> getUsers() {
		ArrayList<UserModel> Users = userFacade.getUserLst();
		return new ResponseEntity<List<UserModel>>(Users, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/{username}/username",method = RequestMethod.GET)
	public ResponseEntity<UserModel> getUserByUsername(@PathVariable("username") String username) {
		UserModel user = userFacade.getUserByUsername(username);
		return  new ResponseEntity<UserModel>(user, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserModel> getUserById(@PathVariable("id") long id) {
		UserModel user = userFacade.getUser(id);
		return  new ResponseEntity<UserModel>(user, HttpStatus.OK);

	}

	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void>  createNewUser( @RequestBody UserModel userData, BindingResult bindingResult) throws MethodArgumentNotValidException {
		userData.setCreateDate(new Date());
		String status = userFacade.createUser(userData, bindingResult);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<UserModel>  updateUser(@Valid @RequestBody UserModel userData, BindingResult bindingResult) throws MethodArgumentNotValidException{
		userData.setLastUpdate(new Date());
		String status = userFacade.editUser(userData);
		return new ResponseEntity<UserModel>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserModel> deleteUserById(@PathVariable("id") long id) {
		String status = userFacade.deleteUser(id);
		return new ResponseEntity<UserModel>(HttpStatus.NO_CONTENT);
	}

}
