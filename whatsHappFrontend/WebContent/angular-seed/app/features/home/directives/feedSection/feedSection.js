angular.module('myapp.home')
.controller('FeedSectionCtrl', function ($scope, homeService,RESOURCE_DOMAIN_FRONTEND) {
	 
	
	var refresh= function(){
		$scope.feeds=[];
		$scope.feed={};
		getFeeds();
	}
	
	$scope.feedLikeCounter= function(feed){
		feed.feedLikesCount=feed.feedLikesCount +1;
		homeService.feedsCounter(feed.id,'like');
	}
	
	$scope.feedDislikesCounter= function(feed){
		feed.feedDislikesCount=feed.feedDislikesCount +1;
		homeService.feedsCounter(feed.id,'dislike');
	}
	
	var getFeeds = function() {
		var promise = homeService.getFeeds();
		promise.then(function(payload) {
			$scope.feeds = payload.data;
			$scope.feeds.forEach(function(element) {
				if(element.feedMediaUrlList){
					var arrayOfStrings = element.feedMediaUrlList.split(',');
					arrayOfStrings=	arrayOfStrings.map(function(element){
						return RESOURCE_DOMAIN_FRONTEND+element;
					});
					element.feedMediaUrlList = arrayOfStrings;
				}
			
			});
		}, function(errorPayload) {
			console.error('event not found by the id:' + eventId);
		})
	};
	
	
	refresh();
  
}).directive('whFeedSection', function() {
	  return {
		  scope : {
			  properties:'=?properties'
			},
			restrict : 'EA',
			controller : 'FeedSectionCtrl',
			controllerAs : 'ctrl',
			templateUrl : 'angular-seed/app/features/home/directives/feedSection/feedSection.html'
		  };
	});