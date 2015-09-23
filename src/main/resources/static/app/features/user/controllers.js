(function(angular) {
	// User Lists

	var UserController = function($scope, User) {
		User.query(function(response) {
			$scope.users = response ? response : [];
		});
	};
	UserController.$inject = [ '$scope', 'User' ];
	angular.module("myApp.controllers").controller("UserController",
			UserController);
}(angular));