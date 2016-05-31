function render () {
	var ul = document.getElementById('liste');
	ul.innerHTML = '';
	laListe.forEach( function(element, index) {
		var nouvelElement = document.createElement('li');
		nouvelElement.textContent = element;
		nouvelElement.appendChild(creerBouton(index));
		ul.appendChild(nouvelElement);
	});
}

function creerBouton(index){
	var nouveauBouton = document.createElement('button');
	nouveauBouton.onclick = supprimerItem.bind(null, index);
	nouveauBouton.textContent = 'X';
	return nouveauBouton;
}