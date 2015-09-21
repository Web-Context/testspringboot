(function(angular) {
  var ItemFactory = function($resource) {
    return $resource('/items/:id', {
      id: '@id'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };

  var UserFactory = function($resource) {
	    return $resource('/users/:id', {
	      id: '@id'
	    }, {
	      create: {
	        method: "POST"
	      },
	      remove: {
	        method: "DELETE"
	      },
	      update: {
	        method: "PUT"
	      },
	    });
	  };
  
  
	  ItemFactory.$inject = ['$resource'];
	  angular.module("myApp.services").factory("Item", ItemFactory);
	  UserFactory.$inject = ['$resource'];
	  angular.module("myApp.services").factory("User", UserFactory);
}(angular));