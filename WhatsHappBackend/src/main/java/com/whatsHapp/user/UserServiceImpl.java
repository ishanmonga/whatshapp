package com.whatsHapp.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public ArrayList<UserModel> getUserLst() {
		// TODO Auto-generated method stub
		return userDao.getUserLst();
	}

	@Override
	public UserModel getUser(long id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	@Override
	public String createUser(UserModel catdata) {
		// TODO Auto-generated method stub
		return userDao.createUser(catdata);
	}

	@Override
	public String editUser(UserModel catdata) {
		// TODO Auto-generated method stub
		return userDao.editUser(catdata);
	}

	@Override
	public String deleteUser(long id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

	@Override
	public UserModel getUserByUsername(String username) {
		// TODO Auto-generated method stub
		ArrayList<UserModel> users=userDao.getUserByUsername(username);
		
		if(users!=null && !users.isEmpty()){
			return users.get(0);
		}else{
			return new UserModel();
		}
		 
	}

}
