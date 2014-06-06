var exaltedAppServices = angular.module('exaltedAppServices', [ 'ngResource' ]);
// var SERVICEURL="http://185.17.252.40:8080/ExaltedService/rest/";
var SERVICEURL = "http://localhost:8080/ExaltedService/rest/";

exaltedAppServices.factory('myService', function($http) {
	return {
		getFoos : function(charName) {
			// return the promise directly.
			console.log(charName);
			return $http.get(SERVICEURL + 'getchar?name=' + charName).then(
					function(result) {
						// resolve the promise as the data
						return result.data;
					});
		}

	}

});

exaltedAppServices.factory('mySecondService', function($http) {
	return {
		getFoos : function() {
			// return the promise directly.
			console.log('haetaan hahmo taulukko');
			return $http
					.get(
							SERVICEURL + ' TODO haehahmotaulukko='
									+ angular.copy(char)) // TODO
					.then(function(result) {
						// resolve the promise as the data
						return result.data;
					});
		}

	}

});
exaltedAppServices.factory('myThirdService', function($http) {
	return {
		postFoos : function(charName, character) {
			// return the promise directly.
			console.log('tallennetaan hahmo');
			$http.post(SERVICEURL + 'postchar?name=' + angular.copy(charName), character); // TODO

		}

	}

});