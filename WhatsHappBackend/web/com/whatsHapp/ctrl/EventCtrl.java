package com.whatsHapp.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whatsHapp.event.EventFacade;
import com.whatsHapp.event.EventModel;
import com.whatsHapp.event.EventValidator;
import com.whatsHapp.user.UserService;
import com.whatsHapp.user.UserModel;
import com.whatsHapp.user.UserService;
import com.whatsHapp.user.UserServiceImpl;
@Validated
@RestController
@RequestMapping("/event") 
public class EventCtrl {

	@Autowired
	EventValidator eventValidator;
	
	@Autowired
	UserService userService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(eventValidator);
	}

	@Autowired
	EventFacade eventFacade;
	
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setEventValidator(EventValidator eventValidator) {
		this.eventValidator = eventValidator;

	}

	public void setEventFacade(EventFacade eventFacade) {
		this.eventFacade = eventFacade;
	}

	@RequestMapping( value = "/city/{city}",method = RequestMethod.GET)
	public ResponseEntity<ArrayList<EventModel>> getEvents(@PathVariable("city") String city) {
		ArrayList<EventModel> events = eventFacade.getEventLst(city);
		return new ResponseEntity<ArrayList<EventModel>>(events, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<EventModel> getCatByID(@PathVariable("id") long id) {
		EventModel event = eventFacade.getEvent(id);
		return  new ResponseEntity<EventModel>(event, HttpStatus.OK);

	}

	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void>  createNewEvent(@Valid @RequestBody EventModel eventData, BindingResult bindingResult) {
		//remove this user
		//UserService userdao= new UserServiceImpl();
		UserModel user= userService.getUserByUsername("ishanmonga@gmail.com");
		eventData.setEventCreater(user);
		
		eventData.setCreateDate(new Date());
	
		String status = eventFacade.createEvent(eventData, bindingResult);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<EventModel>  updateEvent(@Valid @RequestBody EventModel eventData, BindingResult bindingResult) {
		eventData.setLastUpdate(new Date());
		String status = eventFacade.editEvent(eventData);
		return new ResponseEntity<EventModel>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<EventModel> deleteEventById(@PathVariable("id") long id) {
		String status = eventFacade.deleteEvent(id);
		return new ResponseEntity<EventModel>(HttpStatus.NO_CONTENT);
	}

}
