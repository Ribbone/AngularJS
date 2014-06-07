var exaltedAppServices = angular.module('exaltedAppServices', [ 'ngResource' ]);
// var SERVICEURL="http://185.17.252.40:8080/ExaltedService/rest/";
var SERVICEURL = "http://localhost:8080/ExaltedService/rest/";

exaltedAppServices.factory('characterService', function($http) {
	var characterService = {};
	
	characterService.getChar = function(charName) {
		return $http.get(SERVICEURL + 'getchar?name=' + charName);
	};

	characterService.getCharList = function() {
		return $http.get(SERVICEURL + 'getcharlist');
	};

	characterService.postChar = function(character) {
		return $http.post(SERVICEURL + 'postchar', character);
	};

	
	return characterService;
});
