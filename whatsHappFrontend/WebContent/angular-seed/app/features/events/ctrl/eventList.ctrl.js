'use strict';

angular.module('myapp.event')



.controller('eventListController', function ( $location, eventService, RESOURCE_DOMAIN_FRONTEND) {
	 
	var ctrl=  this;
	
	var refreshPage = function() {
		ctrl.event = {};
		ctrl.events = [];
		ctrl.getEvents();
	}
	
	ctrl.getEvents = function() {
		var promise = eventService.getEvents();
		promise.then(function(payload) {
			ctrl.events = payload.data;
				ctrl.events.forEach(function(element) {
					element.eventThumbnail = RESOURCE_DOMAIN_FRONTEND+ element.eventThumbnail;
				});
		}.bind(this), function(errorPayload) {
			console.error('authentication failed' + errorPayload);
		})
	};
	
	ctrl.getEventDetail = function(eventId) {
		$location.path('/event/'+'category'+'/'+eventId);
	};
	
	refreshPage();
	});
