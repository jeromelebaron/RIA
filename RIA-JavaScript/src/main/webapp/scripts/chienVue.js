function render() {
	creerTableauChien(controlerChien.getChiens());
}

function creerTableauChien(listeChien) {
	var corpsTableau = document.getElementById('contenuTableau');
	listeChien.forEach(function(element, index) {
		var nouvelleLigne = document.createElement('tr');
		nouvelleLigne.onclick = controlerChien.afficherDetail.bind(null, element.id);
		nouvelleLigne.appendChild(creerCellule(element.id));
		corpsTableau.appendChild(nouvelleLigne);
		nouvelleLigne.appendChild(creerCellule(element.nom));
		corpsTableau.appendChild(nouvelleLigne);
		nouvelleLigne.appendChild(creerCellule(element.race));
		corpsTableau.appendChild(nouvelleLigne);
		nouvelleLigne.appendChild(creerCellule(element.age));
		corpsTableau.appendChild(nouvelleLigne);
		nouvelleLigne.appendChild(creerCellule(element.lof));
		corpsTableau.appendChild(nouvelleLigne);
	});
}

function creerCellule(element) {
	var cellule = document.createElement('td');
	cellule.textContent = element;
	return cellule;
}

var ul;

function detailChien() {
	document.getElementById('titre').innerHTML = controlerChien.getChien().nom;
	var detailChien = document.getElementById('detailChien');
	if (ul !== undefined) {
		ul.remove();
	};
	detailChien.appendChild(construireDetailChien());
	$("#myModal").modal();
}

function construireDetailChien() {
	ul = document.createElement('ul');
	ul.appendChild(contruireElementDetailChien('Race', controlerChien.getChien().race));
	ul.appendChild(contruireElementDetailChien('Age', controlerChien.getChien().age));
	ul.appendChild(contruireElementDetailChien('Est inscrit au lof', controlerChien.getChien().lof));
	return ul;
}

function contruireElementDetailChien(type, element) {
	var li = document.createElement('li');
	li.textContent = type + ' : ' + element;
	return li;
}