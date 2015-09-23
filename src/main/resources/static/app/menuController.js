(function(angular){
	
	var MenuController = function($scope, Item) {
		$scope.menuItems = [ {
			"label" : "items",
			"title" : "See items",
			"accesskey":"i",
			"route" : "items"
		}, {
			"label" : "users",
			"title" : "Manage users",
			"accesskey":"u",
			"route" : "users"
		} ];
	};
	MenuController.$inject = [ '$scope', 'User' ];
	angular.module("myApp.controllers").controller("MenuController",
			MenuController);
}(angular));