/**
 * [moduleControler permier controleur Angular]
 * @type {[type]}
 */
var moduleControler = angular.module('moduleControler', []);

moduleControler.controller('premierCtrl', ['$scope', 'premierService', function($scope, premierService) {

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

	console.log(premierService.salut());

}]);

moduleControler.controller('ajaxCtrl', ['$scope', 'chienService', function($scope, chienService) {

	$scope.retour = 'Chargement en cours';
	$scope.lesChiens = [];
	$scope.chienClick = {};
	$scope.afficherModal = false;
	$scope.lesRaces = {};
	$scope.order = 'nom';
	$scope.sens = false;
	$scope.chien = chienService.chienModele;
	$scope.newChien = chienService.chienModele;

	chienService.getAllChien().then(function(reponse) {
		$scope.lesChiens = reponse;
		peuplerChiens();
	});

	function peuplerChiens() {
		$scope.lesChiens.forEach(function(element, index) {
			if (!$scope.lesRaces.hasOwnProperty(element.race)) {
				$scope.lesRaces[element.race] = 1;
			} else {
				$scope.lesRaces[element.race]++;
			};
		});
	};

	$scope.detailChien = function(idChien) {
		chienService.getChienById(idChien).then(function(reponse) {
			$scope.chienClick = reponse;
			angular.element('#myModal').modal();
		});
	};

	$scope.classement = function(element) {
		if (element !== $scope.order) {
			$scope.sens = false;
			$scope.order = element;
		} else {
			$scope.sens = !$scope.sens;
		};
	};

	$scope.ajouterChien = function() {
		chienService.insertChien($scope.newChien).then(function(reponse) {
			$scope.lesChiens.push(reponse);
		}).catch(function(reponse) {
			console.log(reponse);
		});
	};

}]);