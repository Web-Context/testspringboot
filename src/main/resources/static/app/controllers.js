(function(angular) {
	//Item for checklist
	var ItemController = function($scope, Item) {
		Item.query(function(response) {
			$scope.items = response ? response : [];
		});

		$scope.addItem = function(description) {
			new Item({
				description : description,
				checked : false
			}).$save(function(item) {
				$scope.items.push(item);
			});
			$scope.newItem = "";
		};

		$scope.updateItem = function(item) {
			item.$update();
		};

		$scope.deleteItem = function(item) {
			item.$remove(function() {
				$scope.items.splice($scope.items.indexOf(item), 1);
			});
		};
	};
	ItemController.$inject = [ '$scope', 'Item' ];
	angular.module("myApp.controllers").controller("ItemController",
			ItemController);

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