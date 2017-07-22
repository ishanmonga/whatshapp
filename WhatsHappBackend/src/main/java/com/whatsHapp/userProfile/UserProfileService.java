package com.whatsHapp.userProfile;

import java.util.ArrayList;

public interface UserProfileService {


	ArrayList<UserProfileModel> getUserProfileLst();

	UserProfileModel getUserProfile(long id);

	String createUserProfile(UserProfileModel catdata);

	String editUserProfile(UserProfileModel catdata);

	String deleteUserProfile(long id);

}
