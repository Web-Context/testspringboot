(function(angular) {
	var UserFactory = function($resource) {
		return $resource('/users/:id', {
			id : '@id'
		}, {
			create : {
				method : "POST"
			},
			remove : {
				method : "DELETE"
			},
			update : {
				method : "PUT"
			},
		});
	};
	UserFactory.$inject = [ '$resource' ];
	angular.module("myApp.services").factory("User", UserFactory);
}(angular));