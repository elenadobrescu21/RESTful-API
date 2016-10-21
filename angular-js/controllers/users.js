var app = angular.module('uniPlatform', [ ]);

app.controller('UserController', ['$scope', '$http', function($scope, $http) {
  $scope.helloWorld = 'Welcome to our platform';

  $scope.users = [];
  $scope.keys = [];


  $http.get('http://localhost:8080/user').then(
    function successCallback(response) {

    $scope.users = response;
    $scope.keys = Object.keys(response.data[0]);
  });


}]);
