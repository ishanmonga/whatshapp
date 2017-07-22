package com.whatsHapp.feed;

import java.util.ArrayList;

public interface FeedDao {

	
	ArrayList<FeedModel> getFeedLst(String city);

	FeedModel getFeed(long id);

	String createFeed(FeedModel catdata);

	String deleteFeed(long id);

	String editFeed(FeedModel catdata);

}
