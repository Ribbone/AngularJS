/* Controllers */


var exaltedAppController = angular.module('exaltedAppController', ['exaltedAppServices']);

exaltedAppController.controller('hahmoController', function($scope, myService) {
	document.domain = "185.17.252.40";
	myService.getFoos().then(function(foos) {
        $scope.character = foos.exaltedCharacter;
    });
	
  });

  exaltedAppController.controller('welcomeController', ['$scope',
  function($scope) {
    $scope.hahmot = [
		{name: 'Risto', characterClass: 'Warrior'},
		{name: 'Petteri', characterClass: 'Paladin'},
		{name: 'Lari', characterClass: 'Priest'}
	]
  }]);