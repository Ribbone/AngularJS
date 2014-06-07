/* Controllers */
"use strict";

var exaltedAppController = angular.module('exaltedAppController', [ 'exaltedAppServices' ]);
exaltedAppController.controller('hahmoController', function($scope, characterService) {

	function getCharList() {
		characterService.getCharList().success(function(response) {
			$scope.characterList = response.exaltedCharacter;
		}).error(function(error) {
			$scope.status = 'Ei pysty lataamaan hahmolistaa';
		});
	};

	function getChar(name) {
		characterService.getChar(name).success(function(response) {
			$scope.character = response.exaltedCharacter;
		}).error(function(error) {
			$scope.status = 'Ei pysty lataamaan hahmoa ' + name;
		});
	};

	function postChar() {
		var request = {};
		request.exaltedCharacter = $scope.character;
		characterService.postChar(request).success(function(response) {
			$scope.character = response.exaltedCharacter;
		}).error(function(error) {
			$scope.status = 'Ei pysty tallentamaan hahmoa ' + name;
		});
	};

	
	function init() {
		getCharList();
		getChar("asd");
	};

	init();


	$scope.save = function() {
		postChar();
	};
	
	$scope.updateCharacterSelection = function(name) {
		getChar(name);
	};

	$scope.reset = function() {
		$scope.character = angular.copy($scope.master);
	};
});

exaltedAppController.controller('welcomeController', function($scope, getChar) {

	$scope.hahmot = [ {
		name : 'asd',
		characterClass : 'lolladin'
	}, {
		name : 'Groe',
		characterClass : 'Warrior'
	}, {
		name : 'Risto',
		characterClass : 'Warrior'
	}, {
		name : 'Petteri',
		characterClass : 'Paladin'
	}, {
		name : 'Lari',
		characterClass : 'Priest'
	} ];

	$scope.newCharacter = function() {
		console.log('uusi characteri');
		charName = {};
	};

	$scope.selectCharacter = function(char) {
		console.log('valittu character:');
		console.log(char);
		charName = angular.copy(char);
	};

});
