angular.module('myApp.whDirectives')
.controller('EventListingCtrl', function ($scope) {
	
	
  
}).directive('whEventListing', function() {
	  return {
		  scope : {
			  properties:'=?properties',
			  onClickListing:'&onClickListing'
			},
			restrict : 'EA',
			controller : 'EventListingCtrl',
			controllerAs : 'ctrl',
			templateUrl : 'angular-seed/app/features/events/directives/eventListing/eventListing.html'
		  };
	});