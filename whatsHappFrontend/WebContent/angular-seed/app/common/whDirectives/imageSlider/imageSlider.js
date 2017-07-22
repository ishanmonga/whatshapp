var app = angular.module('myApp.whDirectives');

app.controller('imageSliderController', function($scope) {

  
  $scope.group = $scope.group || 1;
  $scope.currentIndex = 0;
  $scope.direction = 'left';

  var init = function () {
    var images = [];
    var source = [];

    angular.copy($scope.images, source);

    for (var i = 0; i < source.length; i + $scope.group) {
      if (source[i]) {
        images.push(source.splice(i, $scope.group));
      }
    }
    $scope.setCurrent(0);
    $scope.slides = images;
  };

  $scope.$watch('group', init);
 // $scope.$watch('images', init);
  $scope.$watch('images', function (val) {
	  init();                   
	 }, true);

  $scope.setCurrent = function (index) {
    $scope.direction = (index > $scope.currentIndex) ? 'left' : 'right';
    $scope.currentIndex = index;
  };

  $scope.isCurrent = function (index) {
    return $scope.currentIndex === index;
  };

  $scope.next = function () {
    $scope.direction = 'left';
    $scope.currentIndex = $scope.currentIndex < $scope.slides.length-1 ? ++$scope.currentIndex : 0;
  };

  $scope.prev = function () {
    $scope.direction = 'right';
    $scope.currentIndex = $scope.currentIndex > 0 ? --$scope.currentIndex : $scope.slides.length-1;
  };
});

app.directive('whSlider', function () {
  return {
    restrict: 'EA',
    scope: {
      images: '=images',
      group: '=group'
    },
    templateUrl: 'angular-seed/app/common/whDirectives/imageSlider/imageSlider.html',
    controller : 'imageSliderController',
	controllerAs : 'ctrl',
    link: function (scope, element, attrs) {
      scope.$watch('currentIndex', function (value, previousValue) {
        console.log(value, previousValue);

      });
    }
  };
});

app.animation('.slide-animation', function () {
  return {
    beforeAddClass: function (element, className, done) {
      var scope = element.scope();

      if (className === 'ng-hide') {
        var finishPoint = element.parent().width();
        if(scope.direction !== 'right') {
          finishPoint = -finishPoint;
        }
        TweenMax.to(element, 0.5, {left: finishPoint, onComplete: done });
      } else {
        done();
      }
    },
    removeClass: function (element, className, done) {
      var scope = element.scope();

      if (className === 'ng-hide') {
        element.removeClass('ng-hide');

        var startPoint = element.parent().width();
        if(scope.direction === 'right') {
          startPoint = -startPoint;
        }

        TweenMax.fromTo(element, 0.5, { left: startPoint }, {left: 0, onComplete: done });
      } else {
        done();
      }
    }
  };
});
