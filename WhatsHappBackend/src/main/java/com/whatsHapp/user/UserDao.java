package com.whatsHapp.user;

import java.util.ArrayList;

public interface UserDao {

	
	ArrayList<UserModel> getUserLst();

	UserModel getUser(long id);

	String createUser(UserModel catdata);

	String deleteUser(long id);

	String editUser(UserModel catdata);
	
	ArrayList<UserModel> getUserByUsername(String username);

}
