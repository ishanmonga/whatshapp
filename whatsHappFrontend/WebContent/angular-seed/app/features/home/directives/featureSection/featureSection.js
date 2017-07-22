angular.module('myapp.home')
.controller('FeatureSectionCtrl', function ($scope,eventService,RESOURCE_DOMAIN_FRONTEND) {
	 
	
	var refreshPage = function() {
		$scope.event = {};
		$scope.events = [];
		$scope.getEvents();
	}
	
	$scope.getEvents = function() {
		var promise = eventService.getEvents();
		promise.then(function(payload) {
			$scope.events = payload.data;
				$scope.events.forEach(function(element) {
					element.eventThumbnail = RESOURCE_DOMAIN_FRONTEND+ element.eventThumbnail;
				});
		}, function(errorPayload) {
			console.error('authentication failed' + errorPayload);
		})
	};
	
	$scope.getEventDetail = function(eventId) {
		$location.path('/event/'+'category'+'/'+eventId);
	};
	
	refreshPage();
	
}).directive('whFeatureSection', function() {
	  return {
		  scope : {
			  properties:'=?properties'
			},
			restrict : 'EA',
			controller : 'FeatureSectionCtrl',
			controllerAs : 'ctrl',
			templateUrl : 'angular-seed/app/features/home/directives/featureSection/featureSection.html'
		  };
	});