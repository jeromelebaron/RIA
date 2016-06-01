function doAjax(parametres) {
	var options = {
		url: '',
		methode: 'GET',
		asynchrone: true,
		typeRetour: 'text',
		data: '',
		callback: function() {},
		callbackError: function() {}
	}
	assignerOptions(options, parametres);

	var ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function() {
		if (ajax.readyState === 4 && ajax.status === 200) {
			if (options.typeRetour === 'text') {
				options.callback(ajax.responseText)
			} else {
				options.callback(ajax.responseXML)
			}
		} else {
			options.callbackError();
		}
	};
	ajax.open(options.methode, options.url, options.asynchrone);
	ajax.send(options.data);
}

function assignerOptions(options, parametres) {
	for (clefParametre in parametres) {
		if (options.hasOwnProperty(clefParametre)) {
			options[clefParametre] = parametres[clefParametre];
		}
	}
}