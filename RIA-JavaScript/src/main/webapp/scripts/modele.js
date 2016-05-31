var laListe = ['ga', 'zo','meu'];

function ajouterALaListe (argument) {
	laListe.push(argument);
}

function supprimerDeLaListe (index) {
	if (typeof laListe[index] != 'undefined') {
		laListe.splice(index, 1);
	}
}

function viderLaListe () {
	laListe = [];
}