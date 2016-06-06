monApp.factory('premierService', [function() {

	var exemple = 'boulp';

	function salut() {
		return 'salut ' + exemple;
	};

	return {
		salut: salut
	};
}]);