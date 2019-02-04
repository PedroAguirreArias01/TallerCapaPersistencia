'use strict';


// Declare app level module which depends on filters, and services
var app = angular.module('adminUniversidad', [
    'ngRoute',
    'ngMaterial',
    'ngMessages',
    'adminUniversidad.controllers'
]);
app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'partials/menu.html'});
        $routeProvider.when('/Carrera', {templateUrl: 'partials/Carrera.html', controller: 'CarreraCtrl'});
        $routeProvider.when('/Municipio', {templateUrl: 'partials/Municipio.html', controller: 'MunicipioCtrl'});
        $routeProvider.when('/Facultad', {templateUrl: 'partials/Facultad.html', controller: 'FacultadCtrl'});
        $routeProvider.when('/Estudiante', {templateUrl: 'partials/Estudiante.html', controller: 'EstudiantesCtrl'});
        $routeProvider.when('/Profesores', {templateUrl: 'partials/Profesores.html', controller: 'ProfesoresCtrl'});
        $routeProvider.when('/Materia', {templateUrl: 'partials/Materia.html', controller: 'MateriaCtrl'});
        $routeProvider.when('/Matricula', {templateUrl: 'partials/Matricula.html', controller: 'MatriculaCtrl'});
        $routeProvider.otherwise({redirectTo: '/'});
    }]);

var module = angular.module("adminUniversidad.controllers", []);

