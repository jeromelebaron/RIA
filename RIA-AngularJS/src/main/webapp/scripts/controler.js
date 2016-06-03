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

	$http.get('http://localhost:18080/RIA-RestServer/ria-rest/test/salut').then(function (reponse) {
		$scope.retour = reponse.data;
	});

}]);