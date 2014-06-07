/* Controllers */
"use strict";

var exaltedAppController = angular.module('exaltedAppController', [ 'exaltedAppServices' ]);
exaltedAppController.controller('hahmoController', function($scope, characterService) {

	function getCharList() {
		characterService.getCharList().success(function(response) {
			$scope.characterList = response.exaltedCharacter;
			$scope.status = 'Hahmolista ladattu';
		}).error(function(error) {
			$scope.status = 'Ei pysty lataamaan hahmolistaa';
		});
	};

	function getChar(name) {
		characterService.getChar(name).success(function(response) {
			$scope.character = response.exaltedCharacter;
			$scope.status = 'Ladattiin hahmo ' + name;
		}).error(function(error) {
			$scope.status = 'Ei pysty lataamaan hahmoa ' + name;
		});
	};
	
	function deleteChar(name) {
		characterService.deleteChar(name).success(function(response) {
			$scope.status = 'Hahmo tuhottu: ' + name;
		}).error(function(error) {
			$scope.status = 'Jokin ongelma hahmon tuhoamisessa...';
		});
	};
	
	function postChar() {
		var request = {};
		request.exaltedCharacter = $scope.character;
		characterService.postChar(request).success(function(response) {
			$scope.character = response.exaltedCharacter;
			$scope.status = 'Hahmo tallennettu: ' + $scope.character.name;
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
	
	$scope.deleteChar = function() {
		deleteChar($scope.character.name);
	};
	
	$scope.updateCharacterSelection = function(name) {
		getChar(name);
	};

	$scope.reset = function() {
		$scope.character = angular.copy($scope.master);
	};
});
