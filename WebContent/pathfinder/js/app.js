"use strict";

var app = angular.module('exaltedApp', [ 'ngRoute', 'ngResource' ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'html/mainpage.html',
		controller : 'mainController'
	}).otherwise({
		redirectTo : '/'
	});
} ]);
