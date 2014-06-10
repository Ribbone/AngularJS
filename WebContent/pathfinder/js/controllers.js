"use strict";

app.controller('mainController', function($scope, characterService) {

	function getCharList() {
		characterService.getCharList().success(function(response) {
			$scope.characterList = response;
			$scope.status = 'Hahmolista ladattu';
		}).error(function(error) {
			$scope.status = 'Ei pysty lataamaan hahmolistaa';
		});
	}

	function getChar(name) {
		characterService.getChar(name).success(function(response) {
			$scope.character = response;
			$scope.status = 'Ladattiin hahmo ' + name;
		}).error(function(error) {
			$scope.status = 'Ei pysty lataamaan hahmoa ' + name;
		});
	}
	
	function getCharPlain() {
		characterService.getCharPlain().success(function(response) {
			$scope.character = response;
			$scope.status = 'Ladattiin tyhjä hahmo';
		}).error(function(error) {
			$scope.status = 'Ei pysty lataamaan hahmoa';
		});
	}

	function init() {
		getCharList();
		getCharPlain();
	}

	init();
});
