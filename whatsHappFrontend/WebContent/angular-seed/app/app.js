'use strict';

// Declare app level module which depends on views, and components
angular.module('myapp', [
  'myapp.core',
  'myapp.constant',
  'myApp.version',
  'myapp.home',
  'myapp.user',
  'myapp.login',
  'myapp.event',
  'ngDisqus',
  'pascalprecht.translate',
  'socialLogin'
]).
config(['$locationProvider', '$routeProvider','$httpProvider','$disqusProvider','$translateProvider','socialProvider', function($locationProvider, $routeProvider, $httpProvider, $disqusProvider, $translateProvider, socialProvider) {
  $locationProvider.hashPrefix('!');
  $disqusProvider.setShortname('angulardisqusdemo');
 
  socialProvider.setGoogleKey("YOUR GOOGLE CLIENT ID");
  socialProvider.setLinkedInKey("YOUR LINKEDIN CLIENT ID");
  socialProvider.setFbKey({appId: "1111926468936986", apiVersion: "v2.8"});
  var en_translations = {
		    "language" : "Selected Language English",
		    "greeting" : "Welcome Dinesh" 
		  }
		  
		  var sp_translations = {
		    "language" : "Selected Language Spanish",
		    "greeting" : "Bienvenida Dinesh"  
		  }
		  
		  $translateProvider.translations('en',en_translations);
		  
		  $translateProvider.translations('sp',sp_translations);
		  
		  $translateProvider.preferredLanguage('en');
  //navigation
  $routeProvider.
	when('/login', {
		templateUrl : 'angular-seed/app/features/login/pages/login.html',
		controller : 'loginController'
	}).
	when('/logout', {
		templateUrl : 'angular-seed/app/features/login/pages/login.html',
		controller : 'loginController'
	}).
	when('/register', {
		templateUrl : 'angular-seed/app/features/user/pages/userRegister.html',
		controller : 'userController'
	}).
	when('/home', {
		templateUrl : 'angular-seed/app/features/home/pages/home.html',
		controller : 'homeController'
	}).
	when('/createFeed', {
		templateUrl : 'angular-seed/app/features/home/pages/home.html',
		controller : 'homeController'
	}).
	when('/event/:category/:eventId', {
		templateUrl : 'angular-seed/app/features/events/pages/eventDashboard.html',
		controller : 'eventDashboardController'
	}).
	when('/events', {
		templateUrl : 'angular-seed/app/features/events/pages/eventList.html',
		controller : 'eventListController'
	}).
	when('/dashboard', {
		templateUrl : 'angular-seed/app/features/user/pages/userDashboard.html',
		controller : 'userDashboardController'
	}).
	
  otherwise({redirectTo: '/'});
  
 
}]);
