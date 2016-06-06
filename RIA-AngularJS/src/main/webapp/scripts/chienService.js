monApp.factory('chienService', ['$http', function($http) {

	var urlWS = 'http://localhost:18080/RIA-RestServer/ria-rest/chien';

	var chienModele = {
		id: null,
		nom: null,
		race: null,
		age: null,
		lof: null
	};

	function getAllChien() {
		return $http.get(urlWS + '/chiens').then(function(reponse) {
			return reponse.data;
		});
	};

	function getChienById(idChien) {
		return $http.get(urlWS + '/id/' + idChien).then(function(reponse) {
			return reponse.data;
		});
	};

	function insertChien(chien) {
		return $http.post(urlWS + '/ajout', chien).then(function(reponse) {
			return reponse.data;
		});
	};

	return {
		chienModele: chienModele,
		getAllChien: getAllChien,
		getChienById: getChienById,
		insertChien: insertChien
	};
}]);