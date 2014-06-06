/* Controllers */

var exaltedAppController = angular.module('exaltedAppController',
		[ 'exaltedAppServices' ]);
var charName;
exaltedAppController.controller('hahmoController', function($scope, myService, mySecondService,myThirdService) {

	myService.getFoos(charName).then(function(foos) {

		/*
		 * if (charName == {}) { $scope.master = {}; } else {
		 */
		$scope.character = foos.exaltedCharacter;
		$scope.master = angular.copy($scope.character);
		// }
	});

	$scope.update = function(character) {
		$scope.master = angular.copy(character);
		myThirdService.postFoos(character.name , character);

	};

	$scope.reset = function() {
		$scope.character = angular.copy($scope.master);
	};
});

exaltedAppController.controller('welcomeController',
		function($scope, myService) {

			/*
			 * mySecondService.getChars().then(function(foos) {
			 * 
			 * $scope.hahmot = foos.hahmotaulukko; //TODO Hahmotaulukkon alustus
			 * 
			 * 
			 * });
			 */

			$scope.hahmot = [ {
				name : 'asd',
				characterClass : 'lolladin'
			},{
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
			} ]

			$scope.newCharacter = function() {
				console.log('uusi characteri');
				charName = {};
			}

			$scope.selectCharacter = function(char) {
				console.log('valittu character:');
				console.log(char);
				charName = angular.copy(char);
			}

		});
