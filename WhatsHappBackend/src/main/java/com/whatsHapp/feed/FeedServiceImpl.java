package com.whatsHapp.feed;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("feedService")
public class FeedServiceImpl implements FeedService {

	@Autowired
	FeedDao feedDao;

	public void setFeedDao(FeedDao feedDao) {
		this.feedDao = feedDao;
	}

	@Override
	public ArrayList<FeedModel> getFeedLst(String city) {
		// TODO Auto-generated method stub
		return feedDao.getFeedLst(city);
	}

	@Override
	public FeedModel getFeed(long id) {
		// TODO Auto-generated method stub
		return feedDao.getFeed(id);
	}

	@Override
	public String createFeed(FeedModel catdata) {
		// TODO Auto-generated method stub
		return feedDao.createFeed(catdata);
	}

	@Override
	public String editFeed(FeedModel catdata) {
		// TODO Auto-generated method stub
		return feedDao.editFeed(catdata);
	}

	@Override
	public String deleteFeed(long id) {
		// TODO Auto-generated method stub
		return feedDao.deleteFeed(id);
	}

}
