/* App Module */

var exaltedApp = angular.module('exaltedApp', ['ngRoute','ngResource','exaltedAppController','exaltedAppServices']);

exaltedApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/hahmolomake', {
        templateUrl: 'partials/hahmolomake.html',
        controller: 'hahmoController'
      }).
	  when('/', {
        templateUrl: 'partials/welcome.html',
        controller: 'welcomeController'
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);
