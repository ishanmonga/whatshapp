package com.whatsHapp.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component("userFacade")
public class UserFacade {
	
	@Autowired
	UserService userService;
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	public ArrayList<UserModel> getUserLst() {
		// TODO Auto-generated method stub
		return userService.getUserLst();
	}

	public UserModel getUser(long id) {
		// TODO Auto-generated method stub
		return userService.getUser(id);
	}

	public String createUser(@ModelAttribute UserModel catdata, BindingResult result) throws MethodArgumentNotValidException {
		    if (result.hasErrors()) {
		    	 throw new MethodArgumentNotValidException(null, result);
		    } else {
		    	return userService.createUser(catdata);
		    }
	}

	public String editUser(UserModel catdata) {
		// TODO Auto-generated method stub
		return userService.editUser(catdata);
	}

	public String deleteUser(long id) {
		// TODO Auto-generated method stub
		return userService.deleteUser(id);
	}


	public UserModel getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userService.getUserByUsername(username);
	}

	
}
