var controlerChien = (function() {

	var chiens = [];
	var chien;

	function listerTousLesChiens() {
		listerChiens().then(function(reponse) {
			chiens = reponse;
			render();
		});
	}

	function afficherDetail(idChien) {
		getChienById(idChien).then(function(reponse) {
			chien = reponse;
			detailChien();
		});
	}

	return {
		getChiens: function() {
			return chiens;
		},
		getChien: function() {
			return chien;
		},
		listerTousLesChiens: listerTousLesChiens,
		afficherDetail: afficherDetail
	};
})();