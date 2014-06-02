

var exaltedAppServices = angular.module('exaltedAppServices', ['ngResource']);
var SERVICEURL="http://185.17.252.40:8081/ExaltedService/rest/";

exaltedAppServices.factory('myService', function($http) {
   return {
        getFoos: function() {
             //return the promise directly.
             return $http.get(SERVICEURL + 'getchar?name=NAMEBEHERE')
				.then(function(result) {
				        //resolve the promise as the data
				    return result.data;
				});
        }
   }
});