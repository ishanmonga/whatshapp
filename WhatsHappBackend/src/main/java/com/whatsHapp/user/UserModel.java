package com.whatsHapp.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.whatsHapp.util.model.AddressModel;
import com.whatsHapp.util.model.GenericPersistentObject;

@Entity
@Table(name = "user")
@Component("userModel")
public class UserModel extends GenericPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1528723549758680500L;

	@Column(name = "userFirstName")
	private String userFirstName;
	
	@Column(name = "userLastName")
	private String userLastName;

	@Column(name = "userEmail")
	private String userEmail;

	@Column(name = "userPassword")
	private String userPassword;
	
	@Column(name = "userPhone")
	private String userPhone;
	
	@Column(name = "userActive")
	private boolean userActive;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AddressModel useraddress;


	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public AddressModel getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(AddressModel useraddress) {
		this.useraddress = useraddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public boolean isUserActive() {
		return userActive;
	}

	public void setUserActive(boolean userActive) {
		this.userActive = userActive;
	}

}
