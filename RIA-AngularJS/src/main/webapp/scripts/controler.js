/**
 * [moduleControler permier controleur Angular]
 * @type {[type]}
 */
var moduleControler = angular.module('moduleControler', []);

moduleControler.controller('premierCtrl', ['$scope', function($scope) {

	$scope.fromControler = 'bloup';

	$scope.civilite = 'mineur';

	$scope.majeurMineur = function() {
		if ($scope.age >= 18) {
			$scope.civilite = 'majeur';
		} else {
			$scope.civilite = 'mineur';
		};
	};

	$scope.liste = ['un élément', 'un autre'];
	var liste = $scope.liste;

	$scope.ajouterALaListe = function() {
		var nouvelAjout = $scope.ajout;
		liste.push(nouvelAjout);
	};

}]);