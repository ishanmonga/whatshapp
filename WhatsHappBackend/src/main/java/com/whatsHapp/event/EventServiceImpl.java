package com.whatsHapp.event;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("eventService")
public class EventServiceImpl implements EventService {

	@Autowired
	EventDao eventDao;

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public ArrayList<EventModel> getEventLst(String city) {
		// TODO Auto-generated method stub
		return eventDao.getEventLst( city);
	}

	@Override
	public EventModel getEvent(long id) {
		// TODO Auto-generated method stub
		return eventDao.getEvent(id);
	}

	@Override
	public String createEvent(EventModel catdata) {
		// TODO Auto-generated method stub
		return eventDao.createEvent(catdata);
	}

	@Override
	public String editEvent(EventModel catdata) {
		// TODO Auto-generated method stub
		return eventDao.editEvent(catdata);
	}

	@Override
	public String deleteEvent(long id) {
		// TODO Auto-generated method stub
		return eventDao.deleteEvent(id);
	}

}
