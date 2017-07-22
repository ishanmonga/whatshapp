package com.whatsHapp.userProfile;

import java.util.ArrayList;

public interface UserProfileDao {

	
	ArrayList<UserProfileModel> getUserProfileLst();

	UserProfileModel getUserProfile(long id);

	String createUserProfile(UserProfileModel catdata);

	String deleteUserProfile(long id);

	String editUserProfile(UserProfileModel catdata);

}
