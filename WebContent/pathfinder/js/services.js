"use strict";

var SERVICEURL = "http://localhost:8080/ExaltedService/rest/pathfinder/";

app.factory('characterService', function($http) {
	var characterService = {};

	characterService.getCharPlain = function() {
		return $http.get(SERVICEURL + 'character');
	};

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
