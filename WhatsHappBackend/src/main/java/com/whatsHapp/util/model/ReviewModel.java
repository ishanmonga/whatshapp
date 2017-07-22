package com.whatsHapp.util.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.whatsHapp.user.UserModel;

@Entity
@Table(name = "review")
@Component("reviewModel")
public class ReviewModel extends GenericPersistentObject{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(name = "reviewUser")
	private UserModel reviewUser ; 
	
	@Column(name = "comment")
	private String comment;

	public UserModel getReviewUser() {
		return reviewUser;
	}

	public void setReviewUser(UserModel reviewUser) {
		this.reviewUser = reviewUser;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
