package com.whatsHapp.feed;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatsHapp.util.CustomHibernateDaoSupport;

@Repository("feedDao")
@Transactional(readOnly = false)
public class FeedDaoImpl extends CustomHibernateDaoSupport implements FeedDao {

	@SuppressWarnings("unchecked")

	@Override
	public ArrayList<FeedModel> getFeedLst(String city) {
		ArrayList<FeedModel> feedLst = (ArrayList<FeedModel>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(FeedModel.class));
		return feedLst;
	}

	@Override
	public FeedModel getFeed(long id) {
		return getHibernateTemplate().get(FeedModel.class, id);
	}

	@Override
	public String editFeed(FeedModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(catdata);
		return "success";
	}

	@Override
	public String deleteFeed(long id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(FeedModel.class, id));
		return "success";
	}

	@Override
	public String createFeed(FeedModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(catdata);
		// super.saveOrUpdate(userLogin);
		return "success";
	}

}
