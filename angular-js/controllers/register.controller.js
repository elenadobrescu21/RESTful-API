angular.module("uniPlatform").controller("registerController", function($http, $state, $scope){
// $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
  $scope.fields = {
  username:'',
  email: '',
  password: '',
  passwordConfirm: '',
  firstName: '',
  lastName: ''
};

  $scope.createUser= function() {

    var newUser = {};
    newUser.username = $scope.fields.username;
    newUser.email = $scope.fields.email;
    newUser.password = $scope.fields.password;
	newUser.firstName = $scope.fields.firstName;
	newUser.lastName = $scope.fields.lastName;

    $http.post('http://localhost:8080/user', newUser).then(
		function successCallback(response) {
		  $state.go('default');
    }, function errorCallback(response){
      console.log("User counldn't be created");
    });

  }
})