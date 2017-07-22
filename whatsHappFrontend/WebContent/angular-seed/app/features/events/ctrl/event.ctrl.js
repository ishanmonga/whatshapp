'use strict';

angular.module('myapp.event', [])



.controller('eventDashboardController', function (eventService, $routeParams, RESOURCE_DOMAIN_FRONTEND) {
	 
	var param1 = $routeParams.category;
	var eventId = $routeParams.eventId; 
	var ctrl=  this;
	
	ctrl.discussURL='#!/event/category/'+eventId;
	ctrl.id='#!/event/category/'+eventId;
	
	var refresh= function(){
		
		ctrl.event={};
		ctrl.images = [];
		ctrl.imagesUrl = [];
		getEvent();
	}
	
	
	var getEvent = function() {
		var promise = eventService.getEvent(eventId);
		promise.then(function(payload) {
			ctrl.event = payload.data;
			ctrl.imagesUrl=ctrl.event.mediaUrlList.split(',');
			ctrl.imagesUrl.forEach(function(element){
				ctrl.images.push({image:RESOURCE_DOMAIN_FRONTEND+element});
			});
		}.bind(this), function(errorPayload) {
			console.error('event not found by the id:' + eventId);
		})
	};
	
	
//	ctrl.getImageById = function() {
//		var promise = eventService.getEvents();
//		promise.then(function(payload) {
//			ctrl.events = payload.data;
//		}.bind(this), function(errorPayload) {
//			console.error('authentication failed' + errorPayload);
//		})
//	};
	
	refresh();
	});
