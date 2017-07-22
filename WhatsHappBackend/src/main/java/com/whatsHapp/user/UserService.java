package com.whatsHapp.user;

import java.util.ArrayList;

public interface UserService {


	ArrayList<UserModel> getUserLst();

	UserModel getUser(long id);

	String createUser(UserModel catdata);

	String editUser(UserModel catdata);

	String deleteUser(long id);

	UserModel getUserByUsername(String username);

}
