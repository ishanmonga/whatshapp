package com.whatsHapp.feed;

import java.util.ArrayList;

public interface FeedService {


	ArrayList<FeedModel> getFeedLst(String city);

	FeedModel getFeed(long id);

	String createFeed(FeedModel catdata);

	String editFeed(FeedModel catdata);

	String deleteFeed(long id);

}
