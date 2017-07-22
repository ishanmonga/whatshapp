package com.whatsHapp.userProfile;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userProfileService")
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileDao userProfileDao;

	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}

	@Override
	public ArrayList<UserProfileModel> getUserProfileLst() {
		// TODO Auto-generated method stub
		return userProfileDao.getUserProfileLst();
	}

	@Override
	public UserProfileModel getUserProfile(long id) {
		// TODO Auto-generated method stub
		return userProfileDao.getUserProfile(id);
	}

	@Override
	public String createUserProfile(UserProfileModel catdata) {
		// TODO Auto-generated method stub
		return userProfileDao.createUserProfile(catdata);
	}

	@Override
	public String editUserProfile(UserProfileModel catdata) {
		// TODO Auto-generated method stub
		return userProfileDao.editUserProfile(catdata);
	}

	@Override
	public String deleteUserProfile(long id) {
		// TODO Auto-generated method stub
		return userProfileDao.deleteUserProfile(id);
	}

}
