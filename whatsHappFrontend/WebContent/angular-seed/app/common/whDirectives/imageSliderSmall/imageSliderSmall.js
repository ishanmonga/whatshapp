var app = angular.module('plunker', ['ngAnimate']);

app.controller('MainCtrl', function($scope) {
  $scope.images = [{
    image: 'https://c2.staticflickr.com/6/5135/5516993121_10f879e777_b.jpg'
  }, {
    image: 'https://c2.staticflickr.com/6/5057/5493576767_b71d1e71b6_b.jpg'
  }, {
    image: 'https://c2.staticflickr.com/6/5017/5493573511_748c1c86c3_b.jpg'
  }, {
    image: 'https://farm4.staticflickr.com/3861/14631739185_4e8d59b8b6.jpg'
  }, {
    image: 'https://farm3.staticflickr.com/2935/14445331407_6b565dce71.jpg'
  }, {
    image: 'https://farm4.staticflickr.com/3866/14628491121_97658bffc7.jpg'
  }, {
    image: 'https://farm3.staticflickr.com/2902/14631739625_c595bbd99c.jpg'
  }, {
    image: 'https://farm6.staticflickr.com/5471/14445119289_ae85e6f520.jpg'
  }, {
    image: 'https://farm6.staticflickr.com/5482/14628491991_2284e75e33.jpg'
  }];
});

app.directive('slider', function () {
  return {
    restrict: 'EA',
    scope: {
      images: '=images',
      group: '=group'
    },
    controller: function ($scope) {
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
    },
    templateUrl: "slider.html",
//    template: '<div class="slides group-{{group}}"><div ng-repeat="slide in slides"><div ng-show="isCurrent($index)" class="slide slide-animation"><div ng-repeat="item in slide" class="image"><img ng-src="{{item.image}}" /></div></div></div><div class="controls"><div class="navigation"><a ng-click="prev()" class="prev">< Prev</a><a ng-click="next()" class="next">Next ></a></div><ul class="pagination"><li ng-repeat="slide in slides" ng-click="setCurrent($index)"><span>{{$index+1}}</span></li></ul></div></div>',
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
