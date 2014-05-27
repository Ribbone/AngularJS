

var exaltedAppServices = angular.module('exaltedAppServices', ['ngResource']);

exaltedAppServices.factory('myService', function($http) {
   return {
        getFoos: function() {
             //return the promise directly.
             return $http.get('http://185.17.252.40:8081/WebServices/exalted/getchar?name=NAMEBEHERE')
                       .then(function(result) {
                            //resolve the promise as the data
                            return result.data;
                        });
        }
   }
});