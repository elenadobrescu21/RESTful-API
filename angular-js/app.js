var uniPlatform = angular.module("uniPlatform", ['ui.router']);

uniPlatform.config(function($stateProvider, $urlRouterProvider) {
    //
    // For any unmatched url, redirect to /state1
    $urlRouterProvider.otherwise("/");
    //
    // Now set up the states
    $stateProvider
        .state('default', {
            url: "/",
            templateUrl: "partials/firstpage.html"
        })

    .state('login', {
        url: "/login",
        templateUrl: "partials/login.html"
    })

    .state('register', {
        url: "/register",
        templateUrl: "partials/register.html"
    })

    .state('products', {
        url: "/products",
        templateUrl: "partials/products.html"
    })

    .state('product', {
        url: "/products/:id",
        templateUrl: "partials/product.html"
    })

    .state('cart', {
        url: "/cart",
        templateUrl: "partials/cart.html"
    })

});
