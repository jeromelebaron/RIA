/**
 * Pour déclarer un module Angular.
 * [monApp premier module Angular]
 * @type {[type]}
 */
var monApp = angular.module('monApp', ['moduleControler',
	'ngRoute'
]);

monApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/premier', {
		templateUrl: 'templates/premier.html',
		controller: 'premierCtrl'
	}).when('/404', {
		templateUrl: 'templates/404.html'
	}).when('/ajax', {
		templateUrl: 'templates/appelajax.html',
		controller: 'ajaxCtrl'
	}).otherwise({
		redirectTo: '/404'
	});
}]);