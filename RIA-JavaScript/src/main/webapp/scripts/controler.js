function nouvelItem () {
	ajouterALaListe(document.getElementById('newItem').value);
	render();
}

function supprimerItem (index) {
	supprimerDeLaListe(index);
	render();
}

function viderItems () {
	 viderLaListe();
	 render();
}