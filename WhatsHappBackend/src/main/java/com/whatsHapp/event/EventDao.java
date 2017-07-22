package com.whatsHapp.event;

import java.util.ArrayList;

public interface EventDao {

	
	ArrayList<EventModel> getEventLst(String city);

	EventModel getEvent(long id);

	String createEvent(EventModel catdata);

	String deleteEvent(long id);

	String editEvent(EventModel catdata);

}
