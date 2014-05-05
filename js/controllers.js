/* Controllers */


var exaltedAppController = angular.module('exaltedAppController', []);

exaltedAppController.controller('hahmoController', ['$scope',
  function($scope) {
    $scope.character = [
		{name: 'Fitexi', surname: 'Dobati', playerName: 'Risto', playerSurname: 'Turtiainen', characterConsept: 'Warleader', motivation:'Artifacts', caste: 'Solar', anima:'Dawn'},
	]
  }]);

  exaltedAppController.controller('welcomeController', ['$scope',
  function($scope) {
    $scope.hahmot = [
		{name: 'Risto', characterClass: 'Warrior'},
		{name: 'Petteri', characterClass: 'Paladin'},
		{name: 'Lari', characterClass: 'Priest'}
	]
  }]);