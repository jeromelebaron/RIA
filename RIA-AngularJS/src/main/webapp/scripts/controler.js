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
	$scope.erreurs = {
		nom: false,
		race: false,
		age: false
	};

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
		if (!verifChien()) {
			chienService.insertChien($scope.newChien).then(function(reponse) {
				$scope.lesChiens.push(reponse);
				$scope.newChien = chienService.chienModele;
			}).catch(function(reponse) {
				console.log(reponse);
			});
		};
	};

	function verifChien() {
		resetErreurs();
		var enErreur = false;
		if ($scope.newChien.nom.length <= 2) {
			$scope.erreurs.nom = true;
			enErreur = true;
		};
		if ($scope.newChien.race.length <= 2) {
			$scope.erreurs.race = true;
			enErreur = true;
		};
		if ($scope.newChien.age < 0) {
			$scope.erreurs.age = true;
			enErreur = true;
		};
		return enErreur;
	};

	function resetErreurs() {
		$scope.erreurs = {
			nom: false,
			race: false,
			age: false
		};
	};

}]);