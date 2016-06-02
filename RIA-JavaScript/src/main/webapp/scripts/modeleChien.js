var webServiceURL = 'http://localhost:18080/RIA-RestServer/ria-rest/chien';

function listerChiens() {
	return doAjax({
		url : webServiceURL + '/chiens'
	}).then(function(reponse) {
		return JSON.parse(reponse);
	});
}

function getChienById(idChien) {
	 return doAjax({
	 	url : webServiceURL + '/' + idChien
	 }).then(function (reponse) {
	 	return JSON.parse(reponse);
	 });
}