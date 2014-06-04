/* Controllers */


var exaltedAppController = angular.module('exaltedAppController', ['exaltedAppServices']);

exaltedAppController.controller('hahmoController', function($scope, myService) {
	myService.getFoos().then(function(foos) {
        $scope.character = foos.exaltedCharacter;
        $scope.master = $scope.character;
        
        $scope.update = function(user) {
          $scope.master = angular.copy($scope.character);
        };

        $scope.reset = function() {
          $scope.character = angular.copy($scope.master);
        };

        $scope.reset();
      
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