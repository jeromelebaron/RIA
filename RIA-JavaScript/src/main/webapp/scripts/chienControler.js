var controlerChien = (function() {

	var chiens = [];
	var chien;

	function listerTousLesChiens() {
		chiens.splice(0, chiens.length);
		listerChiens().then(function(reponse) {
			chiens = reponse;
			chienVue.render();
		});
	};

	function afficherDetail(idChien) {
		getChienById(idChien).then(function(reponse) {
			chien = reponse;
			chienVue.detailChien();
		});
	};

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