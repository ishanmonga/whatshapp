angular
    .module('myapp.home').service('homeService', function($http, $q, RESOURCE_DOMAIN, RESOURCE_CONFIG) {

	this.createFeed = function(catData) {
		var data = angular.fromJson(angular.toJson(catData));
	return	$http.post(RESOURCE_DOMAIN+ 'feed', data, RESOURCE_CONFIG);
	};
	

	this.editFeed = function(feed) {
		var data = angular.fromJson(angular.toJson(feed));
		return $http.put(RESOURCE_DOMAIN+ 'feed', data, RESOURCE_CONFIG);
	};
	
	this.deleteFeed = function(catId) {
		return $http.delete(RESOURCE_DOMAIN+ 'feed/'+ catId, RESOURCE_CONFIG);
	};
	
	this.getFeed = function(catId) {
		return	$http.get(RESOURCE_DOMAIN+ 'feed/' +catId, RESOURCE_CONFIG);
	};
    	
	this.getFeeds = function(city) {
		return $http.get(RESOURCE_DOMAIN+ 'feed/city/'+city, RESOURCE_CONFIG);
	};
	
	this.feedsCounter = function(id,counterType) {
		return $http.put(RESOURCE_DOMAIN+ 'feed/counterType/'+counterType +'/id/'+id, RESOURCE_CONFIG);
	};
});
