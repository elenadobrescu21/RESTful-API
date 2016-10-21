angular.module("qshop").factory("ProductsRepository", function($http) {
    var repo = {};
    var fileName = "/data/products.json";
    repo.getProductList = function() {
        return $http.get(fileName);
    }

    return repo;

});
