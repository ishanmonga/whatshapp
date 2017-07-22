var app= angular.module('myApp.whDirectives', ['ngFileUpload']);

app.controller('uploadController', ['$scope', 'Upload', '$timeout', function ($scope, Upload, $timeout) {
	$scope.properties={};
	$scope.uploadPic = function(file) {
		file.upload = Upload.upload({
		  url: 'http://localhost:8080/WhatsHappBackend/rest/media/upload',
		  data: {username: $scope.username, file: file},
		});

	    file.upload.then(function (response) {
	    	
	       $timeout(function () {
	        file.result = response.data;
	        $scope.properties.id=response.data;
	        $scope.onMediaLoadCallback($scope.properties);
	      });
        }, function (response) {
       if (response.status > 0)
        $scope.errorMsg = response.status + ': ' + response.data;
       }, function (evt) {
      // Math.min is to fix IE which reports 200% sometimes
    	   file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
    });
    }
}]);

	app.directive('whFileUpload', function() {
	return {
		scope : {
			properties:'=?properties',
			onMediaLoadCallback:'&onMediaLoadCallback'
		},
		restrict : 'EA',
		controller : 'uploadController',
		controllerAs : 'ctrl',
		templateUrl : 'angular-seed/app/common/uploadFiles/fileUpload.html'
	};
});