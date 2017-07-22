angular.module('myapp.home')
.controller('ProfileSectionCtrl', function ($scope, LoginService, userService, twitter) {
	 
	var refreshPage = function() {
		$scope.user = {};
		$scope.user.userFirstName = '';
		$scope.user.userLastName = '';
		$scope.user.userEmail = '';
		$scope.user.userPassword = '';
		$scope.users = [];
		$scope.hasError = false;
		$scope.messages = [];
		getUser();
		$scope.hashtag = 'football';
	};
	
	var getUser = function() {
		var userName=LoginService.getCredentials();
		var promise = userService.getUserByUsername(userName);
		promise.then(function(payload) {
			$scope.user = payload.data;
		}, function(errorPayload) {
			console.error('authentication failed' + errorPayload);
		})
	};

	refreshPage();
  
}).directive('whProfileSection', function() {
	  return {
		  scope : {
			  properties:'=?properties'
			},
			restrict : 'EA',
			controller : 'ProfileSectionCtrl',
			controllerAs : 'ctrl',
			templateUrl : 'angular-seed/app/features/home/directives/profileSection/profileSection.html'
		  };
	});