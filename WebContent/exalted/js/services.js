var exaltedAppServices = angular.module('exaltedAppServices', [ 'ngResource' ]);
// var SERVICEURL="http://185.17.252.40:8080/ExaltedService/rest/";
var SERVICEURL = "http://localhost:8080/ExaltedService/rest/exalted/";

exaltedAppServices.factory('characterService', function($http) {
	var characterService = {};

	characterService.getChar = function(charName) {
		return $http.get(SERVICEURL + 'character?name=' + charName);
	};

	characterService.getCharList = function() {
		return $http.get(SERVICEURL + 'characterlist');
	};

	characterService.postChar = function(character) {
		return $http.post(SERVICEURL + 'character', character);
	};

	characterService.deleteChar = function(character) {
		return $http['delete'](SERVICEURL + 'character?name=' + charName); // koska delete on varattu sana JavaScriptissä
	};

	return characterService;
});
