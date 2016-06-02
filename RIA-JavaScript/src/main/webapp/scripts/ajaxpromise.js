/**
 * Pour encapsuler les appels AJAX du TP
 * On initialise les différentes options si aucun des paramètres n'est précisé.
 * Utilisation des promises
 */
function doAjax(parametres) {
	return new Promise(function(success, error) {

		var options = {
			url: '',
			methode: 'GET',
			asynchrone: true,
			typeRetour: 'text',
			data: ''
		};
		assignerOptions(options, parametres);

		var ajax = new XMLHttpRequest();
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4) {
				if (ajax.status == 200) {
					if (options.typeRetour === 'text') {
						success(ajax.responseText);
					} else {
						success(ajax.responseXML);
					}
				} else {
					error(ajax.status + ' -- ' + ajax.statusText);
				}
			}
		};
		ajax.open(options.methode, options.url, options.asynchrone);
		ajax.send(options.data);
	});
}

/**
 * Pour assigner les options des paramètres AJAX.
 * On utilise le for in qui permet de parcourir un objet.
 * Si l'une des valeurs est présente dans options alors on l'assigne.
 */
function assignerOptions(options, parametres) {
	for (var clefParametre in parametres) {
		if (options.hasOwnProperty(clefParametre)) {
			options[clefParametre] = parametres[clefParametre];
		}
	}
}