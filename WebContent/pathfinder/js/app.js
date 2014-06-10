"use strict";

var app = angular.module('exaltedApp', [ 'ngRoute', 'ngResource' ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider
	.when('/main', {
		templateUrl : 'html/mainpage.html',
		controller : 'mainController'
	})
	.when('/char', {
		templateUrl : 'html/characterpage.html',
		controller : 'mainController'
	})
	.otherwise({
		redirectTo : '/main'
	});
} ]);
