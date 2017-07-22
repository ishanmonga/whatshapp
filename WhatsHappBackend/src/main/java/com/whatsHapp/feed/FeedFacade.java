package com.whatsHapp.feed;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component("feedFacade")
public class FeedFacade {
	
	@Autowired
	FeedService feedService;
	
	@Autowired
	FeedValidator feedValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(feedValidator);
	}
	
//	@Autowired
//	RestValidationErrorHandler restValidationErrorHandler;
	
	public void setFeedService(FeedService feedService) {
		this.feedService = feedService;
	}

	
	public void setFeedValidator(FeedValidator feedValidator) {
		this.feedValidator = feedValidator;
	}
	public ArrayList<FeedModel> getFeedLst(String city) {
		// TODO Auto-generated method stub
		return feedService.getFeedLst( city);
	}

	public FeedModel getFeed(long id) {
		// TODO Auto-generated method stub
		return feedService.getFeed(id);
	}

	public String createFeed(@ModelAttribute FeedModel catdata, BindingResult result) {
		// TODO Auto-generated method stub
		return feedService.createFeed(catdata);
//		feedValidator.validate(catdata, result);
//		    if (result.hasErrors()) {
//		    	List<FieldError> fieldErrors = result.getFieldErrors();
//		    	 
//		       // return restValidationErrorHandler.processFieldErrors(fieldErrors); 
//		    } else {
//		    	return feedService.createFeed(catdata);
//		    }
//			return null;
			
		
		
	}

	public String editFeed(FeedModel catdata) {
		// TODO Auto-generated method stub
		return feedService.editFeed(catdata);
	}

	public String deleteFeed(long id) {
		// TODO Auto-generated method stub
		return feedService.deleteFeed(id);
	}

	public String editFeedCounter(long id, String counterType) {
		FeedModel feed=feedService.getFeed(id);
		
		//condition also required to check current user
		if(counterType.equalsIgnoreCase("like")){
			feed.setFeedLikesCount(feed.getFeedLikesCount()+1);
		}else if(counterType.equalsIgnoreCase("dislike")){
			feed.setFeedDislikesCount(feed.getFeedDislikesCount()+1);
		}else{
			//logging 
		}
		return feedService.editFeed(feed);
	}

	
}
