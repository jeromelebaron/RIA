#RIA

##Introduction

Acronyme pour **R**ich **I**nternet **A**pplication. Il désigne le fait d'enrichir les applications web afin de les faire ressembler à des applications natives, notamment au niveau de confort de navigation. On essayera au maximum d'éviter les rechargements de page et d'utiliser le javaScript pour améliorer l'interface utilisateur.

##JavaScript

###Bases du langage

Le JavaScript n'est pas typé, il n'y aura donc pas déclaration de type au moment de la création d'une variable. On pourra donc réassigner avec n'importe quel type une variable.

- déclaration de variable : `var premierVariable = 2;`
- nouvelle assignation : `premierVariable = "deux;"`
- un tableau : `premiereVariable = ["text", 1, true];`
- pour faire du log : `console.log(premiereVariable);`
- pour connaitre le type : `typeof(premiereVariable)`
- pour accéder à un élement d'un objet : `console.log("Valeur de la première clef " + premiereVariable.clef);`
- pour ajouter une entrée : `premiereVariable.nouvelleClef = "nouvelleClef";`
- si on omet `var` la variable sera globale
- pour déclarer un fonction

		function maFonction(){
			alert('bloup');
		}
- le JS lit le code de haut en bas mais les fonctions sont chargées au chargement du script. On peut les appeler de n'importe où.
- on peut créer des fonctions anonymes qui sont chargées au moment ou elles sont déclarées. On ne peut donc pas les appeler de n'import où.

		var uneFonction = function () {
			console.log('Fonction avec variable');
		};

###Manipulation du DOM

Le DOM contient toujours un objet racine `window`. Lorsqu'on ajoute une variable JS celle-ci est ajoutée à `window`.

- pour éxécuter des éléments à la fin de leur chargement, on utilisatera la fonction `onload` qui permettra d'appeler une fonction JS une fois l'élément chargé.
- pou récupérer un élément via son id on utilisera la fonction `getElementById()`
- pour avoir le contenu d'un élement on utilisera `element.innerHTML` qui renverra tout y compris d'autres éléments HTML. Si on veut seulement le texte, on utilisera `element.textContent`
- pour ajouter un élement dans le DOM on peut le créer via la fonction `document.createElement('p')` puis on l'insère dans le DOM avec la fonction `document.body.appendChild(nouvelElement);`

##AJAX

##AngularJs