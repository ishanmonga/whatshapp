package com.whatsHapp.userProfile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.whatsHapp.util.model.GenericPersistentObject;
 
@Entity
@Table(name = "userProfile")
@Component("userProfileModel")
public class UserProfileModel extends GenericPersistentObject{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Column(name = "userProfileName")
	private String userProfileName;
	
	@Column(name = "userProfileDesc")
	private String userProfileDesc;


	public String getUserProfileName() {
		return userProfileName;
	}

	public void setUserProfileName(String userProfileName) {
		this.userProfileName = userProfileName;
	}

	public String getUserProfileDesc() {
		return userProfileDesc;
	}

	public void setUserProfileDesc(String userProfileDesc) {
		this.userProfileDesc = userProfileDesc;
	}


}
