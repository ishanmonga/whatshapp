package com.whatsHapp.feed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.whatsHapp.user.UserModel;
import com.whatsHapp.util.model.GenericPersistentObject;
 
@Entity
@Table(name = "feed")
@Component("feedModel")
public class FeedModel extends GenericPersistentObject{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5053526919171047038L;

	@Column(name = "feedHeading")
	private String feedHeading;
	
	@Column(name = "feedMessage")
	private String feedMessage;
	
	@Column(name = "feedLikesCount")
	private int feedLikesCount;
	
	@Column(name = "feedDislikesCount")
	private int feedDislikesCount;
	
	@Column(name = "feedMediaUrlList")
	private String feedMediaUrlList;
	
	@OneToOne
    @JoinColumn(name="userId")
	private UserModel eventCreater;
	
	@Column(name = "feedLocation")
	private String feedLocation;
	
	@Column(name = "feedAddress")
	private String feedAddress;
	
	@Column(name = "feedActive")
	private boolean feedActive;
	
	@Column(name = "feedCity")
	private String feedCity;

	public String getFeedHeading() {
		return feedHeading;
	}

	public void setFeedHeading(String feedHeading) {
		this.feedHeading = feedHeading;
	}

	public String getFeedMessage() {
		return feedMessage;
	}

	public void setFeedMessage(String feedMessage) {
		this.feedMessage = feedMessage;
	}


	public String getFeedLocation() {
		return feedLocation;
	}

	public void setFeedLocation(String feedLocation) {
		this.feedLocation = feedLocation;
	}

	public int getFeedLikesCount() {
		return feedLikesCount;
	}

	public void setFeedLikesCount(int feedLikesCount) {
		this.feedLikesCount = feedLikesCount;
	}

	public int getFeedDislikesCount() {
		return feedDislikesCount;
	}

	public void setFeedDislikesCount(int feedDislikesCount) {
		this.feedDislikesCount = feedDislikesCount;
	}


	public String getFeedAddress() {
		return feedAddress;
	}

	public void setFeedAddress(String feedAddress) {
		this.feedAddress = feedAddress;
	}

	public String getFeedMediaUrlList() {
		return feedMediaUrlList;
	}

	public void setFeedMediaUrlList(String feedMediaUrlList) {
		this.feedMediaUrlList = feedMediaUrlList;
	}

	public UserModel getEventCreater() {
		return eventCreater;
	}

	public void setEventCreater(UserModel eventCreater) {
		this.eventCreater = eventCreater;
	}

	public boolean isFeedActive() {
		return feedActive;
	}

	public void setFeedActive(boolean feedActive) {
		this.feedActive = feedActive;
	}

	public String getFeedCity() {
		return feedCity;
	}

	public void setFeedCity(String feedCity) {
		this.feedCity = feedCity;
	}

	

}
