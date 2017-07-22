package com.whatsHapp.search;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.whatsHapp.event.EventModel;
import com.whatsHapp.feed.FeedModel;
 

// this model does not need to be populated in database
@Component("searchModel")
public class SearchModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// it will mainly have the search criteria, filter and the objects
	
	private List<String> searchCategoryList;
	
	private String searchCountry;

	private String searchLanguage;

	private Date startDate;
	
	private Date endDate;
	
	private List<EventModel> eventModel;
	
	private List<FeedModel> eventFeedModel;

	public List<String> getSearchCategoryList() {
		return searchCategoryList;
	}

	public void setSearchCategoryList(List<String> searchCategoryList) {
		this.searchCategoryList = searchCategoryList;
	}

	public String getSearchCountry() {
		return searchCountry;
	}

	public void setSearchCountry(String searchCountry) {
		this.searchCountry = searchCountry;
	}

	public String getSearchLanguage() {
		return searchLanguage;
	}

	public void setSearchLanguage(String searchLanguage) {
		this.searchLanguage = searchLanguage;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<EventModel> getEventModel() {
		return eventModel;
	}

	public void setEventModel(List<EventModel> eventModel) {
		this.eventModel = eventModel;
	}

	public List<FeedModel> getEventFeedModel() {
		return eventFeedModel;
	}

	public void setEventFeedModel(List<FeedModel> eventFeedModel) {
		this.eventFeedModel = eventFeedModel;
	}
	
	
	
	
	

}
