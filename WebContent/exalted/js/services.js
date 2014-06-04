

var exaltedAppServices = angular.module('exaltedAppServices', ['ngResource']);
//var SERVICEURL="http://185.17.252.40:8080/ExaltedService/rest/";
var SERVICEURL="http://localhost:8080/ExaltedService/rest/";

exaltedAppServices.factory('myService', function($http) {
   return {
        getFoos: function() {
             //return the promise directly.
             return $http.get(SERVICEURL + 'getchar?name=asd')
                    .then(function(result) {
				        //resolve the promise as the data
				    return result.data;
				});
        }
   }
});