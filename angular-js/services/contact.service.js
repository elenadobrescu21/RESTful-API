angular.module("qshop").factory("Contact", function($http){
  var contact = {};

  contact.sendMessage = function(message) {
    console.log("Message", message);
    $http.post('http://10.59.0.30:3000/posts', message);
  }

  return contact;
})
