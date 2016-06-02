var chienVue = (function() {

	function render() {
		creerTableauChien(controlerChien.getChiens());
	};

	function creerTableauChien(listeChien) {
		var corpsTableau = $('#contenuTableau');
		$.each(listeChien, function(index, element) {
			var nouvelleLigne = $('<tr>');
			nouvelleLigne.click(controlerChien.afficherDetail.bind(null, element.id));
			nouvelleLigne.append(creerCellule(element.id));
			corpsTableau.append(nouvelleLigne);
			nouvelleLigne.append(creerCellule(element.nom));
			corpsTableau.append(nouvelleLigne);
			nouvelleLigne.append(creerCellule(element.race));
			corpsTableau.append(nouvelleLigne);
			nouvelleLigne.append(creerCellule(element.age));
			corpsTableau.append(nouvelleLigne);
			nouvelleLigne.append(creerCellule(element.lof));
			corpsTableau.append(nouvelleLigne);
		});
	};

	function creerCellule(element) {
		var cellule = $('<td>');
		cellule.text(element);
		return cellule;
	};

	var ul;

	function detailChien() {
		$('#titre').text(controlerChien.getChien().nom);
		var detailChien = $('#detailChien');
		if (ul !== undefined) {
			ul.remove();
		};
		detailChien.append(construireDetailChien());
		$("#myModal").modal();
	};

	function construireDetailChien() {
		ul = $('<ul>');
		ul.append(contruireElementDetailChien('Race', controlerChien.getChien().race));
		ul.append(contruireElementDetailChien('Age', controlerChien.getChien().age));
		ul.append(contruireElementDetailChien('Est inscrit au lof', controlerChien.getChien().lof));
		return ul;
	};

	function contruireElementDetailChien(type, element) {
		var li = $('<li>');
		li.text(type + ' : ' + element);
		return li;
	};

	return {
		render: render,
		detailChien: detailChien
	};

})();