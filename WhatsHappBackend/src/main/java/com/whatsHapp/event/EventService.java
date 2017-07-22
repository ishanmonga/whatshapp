package com.whatsHapp.event;

import java.util.ArrayList;

public interface EventService {


	ArrayList<EventModel> getEventLst(String city);

	EventModel getEvent(long id);

	String createEvent(EventModel catdata);

	String editEvent(EventModel catdata);

	String deleteEvent(long id);

}
