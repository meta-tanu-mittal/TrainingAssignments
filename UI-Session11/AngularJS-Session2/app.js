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


});

myApp.controller("itemController", function ($scope, $http, $routeParams) {
    $scope.cartItemCount=0;
    $scope.categoryName = $routeParams.categoryName;
    $http.get('http://localhost:3000/items').then(function (response) {
        $scope.items = response.data;
       
    })
    $http.get('http://localhost:3000/categories').then(function (response) {
        $scope.categories = response.data;
    })
    
//    $http.get('http://localhost:3000/carts').then(function(response)
//                                                 {
//        var cartItems=response.data;
//        var cartItemCount;
//        cartItems.forEach(cartItem)
//        {
//        cartItemCount+=cartItem.quantity;
//        }
//        $scope.cartItemCount=cartItemCount;
//    })
//    

    $scope.addToCart = function(item) {
        $scope.cartItemCount=$scope.cartItemCount+1;
        $http.get('http://localhost:3000/carts/'+item.id).then(function successCallBack(response) {
                response.data.quantity += 1;
                $http({
                    method: "PUT",
                    url: "http://localhost:3000/carts/"+item.id,
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
