package com.whatsHapp.dto;

import org.springframework.stereotype.Component;

@Component("eventListingDTO")
public class EventListingDTO {

	/**
	 * 
	 */

	private String eventThumbnail;
	
	private long eventId;

	private String eventName;

	private String eventDesc;

	private String eventTags;

	private String eventPublishUrl;

	private String eventDate;

	private String eventTime;

	private String eventGoogleAddress;

	private int eventType; // can be paid free
	

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getEventThumbnail() {
		return eventThumbnail;
	}

	public void setEventThumbnail(String eventThumbnail) {
		this.eventThumbnail = eventThumbnail;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getEventTags() {
		return eventTags;
	}

	public void setEventTags(String eventTags) {
		this.eventTags = eventTags;
	}

	public String getEventPublishUrl() {
		return eventPublishUrl;
	}

	public void setEventPublishUrl(String eventPublishUrl) {
		this.eventPublishUrl = eventPublishUrl;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventGoogleAddress() {
		return eventGoogleAddress;
	}

	public void setEventGoogleAddress(String eventGoogleAddress) {
		this.eventGoogleAddress = eventGoogleAddress;
	}

	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	
	

}