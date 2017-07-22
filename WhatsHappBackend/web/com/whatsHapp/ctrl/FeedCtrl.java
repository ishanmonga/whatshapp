package com.whatsHapp.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whatsHapp.event.EventFacade;
import com.whatsHapp.feed.FeedFacade;
import com.whatsHapp.feed.FeedModel;
import com.whatsHapp.feed.FeedValidator;
import com.whatsHapp.user.UserModel;
import com.whatsHapp.user.UserService;
@Validated
@RestController
@RequestMapping("/feed") 
public class FeedCtrl {

	@Autowired
	FeedValidator feedValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(feedValidator);
	}

	@Autowired
	FeedFacade feedFacade;
	
	@Autowired
	UserService userService;
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setFeedValidator(FeedValidator feedValidator) {
		this.feedValidator = feedValidator;

	}

	public void setFeedFacade(FeedFacade feedFacade) {
		this.feedFacade = feedFacade;
	}

	@RequestMapping( value = "/city/{city}",method = RequestMethod.GET)
	public ResponseEntity<List<FeedModel>> getfeeds(@PathVariable("city") String city) {
		ArrayList<FeedModel> feeds = feedFacade.getFeedLst(city);
		return new ResponseEntity<List<FeedModel>>(feeds, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FeedModel> getFeedByID(@PathVariable("id") long id) {
		FeedModel feed = feedFacade.getFeed(id);
		return  new ResponseEntity<FeedModel>(feed, HttpStatus.OK);

	}

	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void>  createNewFeed(@Valid @RequestBody FeedModel feedData, BindingResult bindingResult) {
		//
		feedData.setCreateDate(new Date());
		UserModel user= userService.getUserByUsername("ishanmonga@gmail.com");
		feedData.setEventCreater(user);
		
		String status = feedFacade.createFeed(feedData, bindingResult);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<FeedModel>  updateFeed(@Valid @RequestBody FeedModel feedData, BindingResult bindingResult) {
		feedData.setLastUpdate(new Date());
		String status = feedFacade.editFeed(feedData);
		return new ResponseEntity<FeedModel>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<FeedModel> deleteFeedById(@PathVariable("id") long id) {
		String status = feedFacade.deleteFeed(id);
		return new ResponseEntity<FeedModel>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/counterType/{counterType}/id/{id}", method = RequestMethod.PUT)
	public ResponseEntity<FeedModel> editFeedCounter(@PathVariable("id") long id,@PathVariable("counterType") String counterType) {
		String status = feedFacade.editFeedCounter(id,counterType);
		return new ResponseEntity<FeedModel>(HttpStatus.NO_CONTENT);
	}
}
