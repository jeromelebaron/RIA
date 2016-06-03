var chienVue = (function() {

    /**
     * Fonction appelée pour créer le tableau de chiens.
     */
    function render() {
        creerTableauChien(controlerChien.getChiens());
    };

    /**
     * Pour construire le tableau avec les chiens.
     * @param  {une liste de chien} la liste des chiens.
     * @return {[type]}
     */
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

    /**
     * Pour créer une cellule du tableau.
     * @param  {String} l'élement à ajouter dans le tableau.
     * @return {[type]}
     */
    function creerCellule(element) {
        var cellule = $('<td>');
        cellule.text(element);
        return cellule;
    };

    var ul;

    /**
     * Pour afficher le détail d'un chien.
     * @return {function}
     */
    function detailChien() {
        $('#titre').text(controlerChien.getChien().nom);
        var detailChien = $('#detailChien');
        if (ul !== undefined) {
            ul.remove();
        };
        detailChien.append(construireDetailChien());
        $("#myModal").modal();
    };

    /**
     * Pour fabriquer la liste de détails du chien.
     * @return {ul}
     */
    function construireDetailChien() {
        ul = $('<ul>');
        ul.append(contruireElementDetailChien('Race', controlerChien.getChien().race));
        ul.append(contruireElementDetailChien('Age', controlerChien.getChien().age));
        ul.append(contruireElementDetailChien('Est inscrit au lof', controlerChien.getChien().lof));
        return ul;
    };

    /**
     * Pour ajouer une puce à la liste de détails du chien.
     * @param  {String} le libellé du détail.
     * @param  {String} le détail.
     * @return {function}
     */
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