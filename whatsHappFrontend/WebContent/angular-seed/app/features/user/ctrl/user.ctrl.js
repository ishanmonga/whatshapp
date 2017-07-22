'use strict';

angular.module('myapp.user', []).controller('userController', UserController);

function UserController(userService,LoginService , $location) {
	var error = 'ERROR'

	var refreshPage = function() {
		this.hasError = false;
		this.messages = [];
		this.userNewPassword = '';
		this.userConfirmPassword = '';
		this.user = {};
		this.user.userFirstName = '';
		this.user.userLastName = '';
		this.user.userEmail = '';
		this.user.userPassword = '';
		this.users = [];

		//this.getUserDetails();
	}.bind(this);


	this.editUser = function() {
		var promise = userService.editUser(this.user);
		promise.then(function(payload) {
			refreshPage();
		}.bind(this), function(errorPayload) {
			console.error('authentication failed' + errorPayload);
		})
	};
	this.createUser = function(user) {
		var promise = userService.createUser(user);
		promise.then(function(payload) {
			//FlashService.Success('Registration successful', true);
			$location.path('/login');
		}, function(errorPayload) {
			this.hasError = true;
			//FlashService.Error(response.message);
			this.dataLoading = false;
			this.messages.type = error;
			this.messages.content = errorPayload.fieldErrors;

		}.bind(this))
	};
	
	this.changePassword = function() {
		if(this.userNewPassword===this.userConfirmPassword){
			this.user.userPassword = this.userNewPassword;
			var promise = userService.editUser(this.user);
			promise.then(function(payload) {
				refreshPage();
			}.bind(this), function(errorPayload) {
				console.error('authentication failed' + errorPayload);
			})
		}
	};

	this.getUserDetails = function() {
			var userName=LoginService.getCredentials();
			var promise = userService.getUserByUsername(userName);
			promise.then(function(payload) {
				this.user = payload.data;
			}.bind(this), function(errorPayload) {
				console.error('authentication failed' + errorPayload);
			})
	}.bind(this);

	refreshPage();

}