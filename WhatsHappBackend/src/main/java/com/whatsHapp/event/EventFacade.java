package com.whatsHapp.event;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component("eventFacade")
public class EventFacade {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	EventValidator eventValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(eventValidator);
	}
	
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	
	public void setEventValidator(EventValidator eventValidator) {
		this.eventValidator = eventValidator;
	}
	public ArrayList<EventModel> getEventLst(String city) {
		// TODO Auto-generated method stub
		return eventService.getEventLst(city);
	}

	public EventModel getEvent(long id) {
		// TODO Auto-generated method stub
		return eventService.getEvent(id);
	}

	public String createEvent(@ModelAttribute EventModel catdata, BindingResult result) {
		// TODO Auto-generated method stub
		return eventService.createEvent(catdata);
//		eventValidator.validate(catdata, result);
//		    if (result.hasErrors()) {
//		    	List<FieldError> fieldErrors = result.getFieldErrors();
//		    	 
//		       // return restValidationErrorHandler.processFieldErrors(fieldErrors); 
//		    } else {
//		    	return eventService.createEvent(catdata);
//		    }
//			return null;
			
		
		
	}

	public String editEvent(EventModel catdata) {
		// TODO Auto-generated method stub
		return eventService.editEvent(catdata);
	}

	public String deleteEvent(long id) {
		// TODO Auto-generated method stub
		return eventService.deleteEvent(id);
	}

	
}
