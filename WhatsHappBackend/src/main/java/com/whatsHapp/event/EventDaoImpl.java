package com.whatsHapp.event;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatsHapp.util.CustomHibernateDaoSupport;

@Repository("eventDao")
@Transactional(readOnly = false)
public class EventDaoImpl extends CustomHibernateDaoSupport implements EventDao {

	@SuppressWarnings("unchecked")
	

	
	@Override
	public ArrayList<EventModel> getEventLst(String city) {
		ArrayList<EventModel> eventLst = (ArrayList<EventModel>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(EventModel.class));
		return eventLst;
	}
	
	@Override
	public EventModel getEvent(long id) {
		EventModel event = new EventModel();
		event=getHibernateTemplate().get(EventModel.class, id);
		return event;
	}

	@Override
	public String editEvent(EventModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(catdata);
		return "success";
	}

	@Override
	public String deleteEvent(long id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(EventModel.class, id));
		return "success";
	}

	@Override
	public String createEvent(EventModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(catdata);
		// super.saveOrUpdate(userLogin);
		return "success";
	}




}
