var myApp = angular.module("groceryCart", ['ngRoute']);
myApp.config(function ($locationProvider, $routeProvider) {
	$locationProvider.hashPrefix('!');
	$routeProvider
		.when("/", {
			templateUrl: "pages/home.html",
			controller: "itemController"
		})
		.when("/category/:categoryName", {
			templateUrl: "pages/home.html",
			controller: "itemController"
		})
		.when("/cart", {
			templateUrl: "pages/cartItemPage.html",
			controller: "cartController"
		})
		.when("/shipping", {
			templateUrl: "pages/shippingPage.html",
			controller: "cartController"
		})
		.when("/orderStatus", {
			templateUrl: "pages/orderStatusPage.html",
			controller: "orderStatusController"
		})


});

myApp.controller("itemController", function ($scope, $http, $routeParams, $rootScope) {
	$rootScope.cartItemCount;
	$scope.categoryName = $routeParams.categoryName;
	$http.get('http://localhost:3000/items').then(function (response) {
		$scope.items = response.data;

	});
	$http.get('http://localhost:3000/categories').then(function (response) {
		$scope.categories = response.data;
	});
	$http.get("http://localhost:3000/carts").then(function (response) {
		$scope.carts = response.data;
		var count = 0;
		for (var item in $scope.carts) {
			count += $scope.carts[item].quantity;
		}
		$rootScope.cartItemCount = count;
	});


	$scope.addToCart = function (item) {
		$rootScope.cartItemCount++;
		$http.get('http://localhost:3000/carts/' + item.id).then(function successCallBack(response) {
				response.data.quantity += 1;

				$http({
					method: "PUT",
					url: "http://localhost:3000/carts/" + item.id,
					data: response.data,
					datatype: "json",
				});
			},
			function errorCallBack(response) {
				var cartData = {
					"id": item.id,
					"name": item.name,
					"price": item.price,
					"imagePath": item.imagePath,
					"category": item.category,
					"quantity": 1
				}
				$http({
					method: "POST",
					url: "http://localhost:3000/carts/",
					data: cartData,
					datatype: "json",
				});

			});

	};

});




myApp.controller("cartController", function ($scope, $http, $rootScope) {
	$rootScope.cartItemCount;
	$scope.totalCartAmount;
	$http.get("http://localhost:3000/carts").then(function (response) {
		$scope.carts = response.data;
		var total = 0;
		for (var item in $scope.carts) {
			total += ($scope.carts[item].quantity * $scope.carts[item].price);
		}
		$scope.totalCartAmount = total;
	});

	$scope.increaseItem = function (item) {
		$http.get("http://localhost:3000/carts/" + item.id).then(function (response) {
			response.data.quantity += 1;
			$http({
				method: "PUT",
				url: "http://localhost:3000/carts/" + item.id,
				data: response.data,
				datatype: "json"
			});
		});

		$http.get("http://localhost:3000/carts").then(function (response) {
			$scope.carts = response.data;
			console.log($scope.carts);

			var count = 0;
			var total = 0;
			for (var cartItem in $scope.carts) {
				count += $scope.carts[cartItem].quantity;
				total += (($scope.carts[cartItem].quantity) * ($scope.carts[cartItem].price));
			}
			$rootScope.cartItemCount = count;
			$scope.totalCartAmount = total;
		});

	};

	$scope.decreaseItem = function (item) {
		$http.get("http://localhost:3000/carts/" + item.id).then(function (response) {
			if (response.data.quantity >= 2) {
				response.data.quantity -= 1;
				$http({
					method: "PUT",
					url: "http://localhost:3000/carts/" + item.id,
					data: response.data,
					datatype: "json"
				})
			} else {
				$http.delete("http://localhost:3000/carts/"+item.id).then(function(response){});
				window.location.reload();

			}
		})

		$http.get("http://localhost:3000/carts").then(function (response) {
			$scope.carts = response.data;
			console.log($scope.carts);

			var count = 0;
			var total = 0;
			for (var cartItem in $scope.carts) {
				count += $scope.carts[cartItem].quantity;
				total += (($scope.carts[cartItem].quantity) * ($scope.carts[cartItem].price));
			}
			$rootScope.cartItemCount = count;
			$scope.totalCartAmount = total;
		});

	};




	$scope.clearShoppingCart = function () {
		$http.get("http://localhost:3000/carts").then(function (response) {
			$scope.carts = response.data;
			for (var item in $scope.carts) {
				$http.delete("http://localhost:3000/carts/" + $scope.carts[item].id).then(function (response) {

				})
			}
			window.location.reload();
		});
	};


});


myApp.controller("orderStatusController", function ($scope, $http, $rootScope) {
	$http.get("http://localhost:3000/carts").then(function (response) {
		$scope.carts = response.data;
		if (response.data.length != 0) {
			for (var item in $scope.carts) {
				$http.delete("http://localhost:3000/carts/" + $scope.carts[item].id).then(function (response) {

				})
			}
			$scope.message = "Thank you!";
			$scope.status = "We received your order and it will process in next 24 hours";
		} else {
			$scope.message = "Sorry!";
			$scope.status = "Please try next time";
		}
		$rootScope.cartItemCount = 0;
	});
});
