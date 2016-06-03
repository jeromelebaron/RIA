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

moduleControler.controller('ajaxCtrl', ['$scope', '$http', function($scope, $http) {

	$scope.retour = 'Chargement en cours';
	$scope.lesChiens = [];
	$scope.chienClick = {};
	$scope.afficherModal = false;
	$scope.lesRaces = {};

	$http.get('http://localhost:18080/RIA-RestServer/ria-rest/chien/chiens').then(function(reponse) {
		$scope.lesChiens = reponse.data;
		$scope.lesChiens.forEach(function(element, index) {
			if (!$scope.lesRaces.hasOwnProperty(element.race)) {
				$scope.lesRaces[element.race] = 1;
			} else {
				$scope.lesRaces[element.race]++;
			};
		});
	});

	$scope.detailChien = function(idChien) {
		$http.get('http://localhost:18080/RIA-RestServer/ria-rest/chien/id/' + idChien).then(function(reponse) {
			$scope.chienClick = reponse.data;
			angular.element('#myModal').modal();
		});
	};

}]);