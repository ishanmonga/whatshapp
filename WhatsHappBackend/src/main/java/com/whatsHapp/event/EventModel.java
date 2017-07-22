package com.whatsHapp.event;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.whatsHapp.category.CategoryModel;
import com.whatsHapp.user.UserModel;
import com.whatsHapp.util.model.AddressModel;
import com.whatsHapp.util.model.GenericPersistentObject;

@Entity
@Table(name = "event")
@Component("eventModel")
public class EventModel extends GenericPersistentObject {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name = "mediaUrlList")
	private String mediaUrlList;
	
	@Column(name = "eventThumbnail")
	private String eventThumbnail;

	// headline of the event
	@Column(name = "eventName")
	private String eventName;

	@Column(name = "eventDesc", length=1000)
	private String eventDesc;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "EVENT_CATEGORY_RELATION", joinColumns = {
	        @JoinColumn(name = "eventid",referencedColumnName = "id")}, inverseJoinColumns = {
	        @JoinColumn(name = "categoryid",referencedColumnName = "id")})
	private List<CategoryModel> eventCategory;

	@Column(name = "eventTags")
	private String eventTags;

	@Column(name = "eventPublishUrl")
	private String eventPublishUrl;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eventStartDate")
	private Date eventStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eventEndDate")
	private Date eventEndDate;

	@Column(name = "eventLocation")
	private String eventLocation;
	
	@Column(name = "eventGoogleAddress")
	private String eventGoogleAddress;

	@Column(name = "eventActiveFlag")
	private boolean eventActiveFlag;

	@Column(name = "eventType")
	private int eventType; // can be paid free

	@OneToOne(  cascade = CascadeType.ALL)
	@JoinColumn(name="eventAddress")
	private AddressModel eventAddress;

	// it will be enum of featured,
	@Column(name = "eventKind")
	private String eventKind;

	@Column(name = "eventTermsConditions")
	private String eventTermsConditions;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eventEndTime")
	private Date eventEndTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eventStartTime")
	private Date eventStartTime;
	
	@Column(name = "eventFaq")
	private String eventFaq;

	@OneToOne
    @JoinColumn(name="userId")
	private UserModel eventCreater;
	
	@Column(name = "eventPublishFlag")
	private boolean eventPublishFlag;
	
	@Column(name = "eventCity")
	private String eventCity;

	public String getMediaUrlList() {
		return mediaUrlList;
	}

	public void setMediaUrlList(String mediaUrlList) {
		this.mediaUrlList = mediaUrlList;
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

	public List<CategoryModel> getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(List<CategoryModel> eventCategory) {
		this.eventCategory = eventCategory;
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

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Date getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}


	public boolean isEventActiveFlag() {
		return eventActiveFlag;
	}

	public void setEventActiveFlag(boolean eventActiveFlag) {
		this.eventActiveFlag = eventActiveFlag;
	}

	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public AddressModel getEventAddress() {
		return eventAddress;
	}

	public void setEventAddress(AddressModel eventAddress) {
		this.eventAddress = eventAddress;
	}

	public String getEventKind() {
		return eventKind;
	}

	public void setEventKind(String eventKind) {
		this.eventKind = eventKind;
	}

	public String getEventTermsConditions() {
		return eventTermsConditions;
	}

	public void setEventTermsConditions(String eventTermsConditions) {
		this.eventTermsConditions = eventTermsConditions;
	}

	public String getEventFaq() {
		return eventFaq;
	}

	public void setEventFaq(String eventFaq) {
		this.eventFaq = eventFaq;
	}

	public UserModel getEventCreater() {
		return eventCreater;
	}

	public void setEventCreater(UserModel eventCreater) {
		this.eventCreater = eventCreater;
	}

	public String getEventGoogleAddress() {
		return eventGoogleAddress;
	}

	public void setEventGoogleAddress(String eventGoogleAddress) {
		this.eventGoogleAddress = eventGoogleAddress;
	}

	public Date getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(Date eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

	public Date getEventStartTime() {
		return eventStartTime;
	}

	public void setEventStartTime(Date eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public String getEventThumbnail() {
		return eventThumbnail;
	}

	public void setEventThumbnail(String eventThumbnail) {
		this.eventThumbnail = eventThumbnail;
	}

	public boolean isEventPublishFlag() {
		return eventPublishFlag;
	}

	public void setEventPublishFlag(boolean eventPublishFlag) {
		this.eventPublishFlag = eventPublishFlag;
	}

	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}





}
