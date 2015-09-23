(function(angular) {
  angular.module("myApp.controllers", []);
  angular.module("myApp.services", []);
  angular.module("myApp", ["ngResource", "ngRoute", "myApp.controllers", "myApp.services"])
  	.config(['$routeProvider',
      function($routeProvider) {
        $routeProvider.
          when('/items', {
            templateUrl: 'app/features/item/templates/list.html',
            controller: 'ItemController'
          }).
          when('/users', {
			templateUrl: 'app/features/user/templates/list.html',
			controller: 'UserController'
          }).
          otherwise({
            redirectTo: '/items'
          });
      }]);
  
  
}(angular));