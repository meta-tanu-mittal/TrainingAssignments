var userApp = angular.module('userApp', []);

// Define the `PhoneListController` controller on the `phonecatApp` module
userApp.controller('userListController', function userListController($scope) {
    $scope.users = [
        {
            name: 'Tanu',
            contact: '789456123',
            location: 'jaipur'
    }, {
            name: 'Richa',
            contact: '789456123',
            location: 'ajmer'
    }, {
            name: 'namrata agarwal',
            contact: '789456123',
            location: 'alwar'
    }, {
            name: 'arjita',
            contact: '789456123',
            location: 'shadol'
    }
  ];
});
