'use strict';

module.controller('CarreraCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        
        //listar
        $scope.lista = null;
        $scope.datosFormulario = {};
        $scope.panelEditar = false;
        $scope.listaFacultad = null;

        //guardar
        $scope.nuevo = function () {
            $scope.panelEditar = true;
            $scope.datosFormulario = {};
        };

        $scope.cancelar = function () {
            $scope.panelEditar = false;
            $scope.datosFormulario = {};
        };
        
        //editar
        $scope.editar = function (data) {
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
        };

        //eliminar
        $scope.eliminar = function (data) {
            for (var i = 0; i < $scope.lista.length; i++) {
                if ($scope.lista[i] === data) {
                    $scope.lista.splice(i, 1);
                    break;
                }
            }
            $.ajax({
                url: './webresources/ServicioCarrera/' + data.nombre,
                type: 'DELETE'
            });
        };

        $scope.getCarrera = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioCarrera", {})
                    .then(function (response) {
                        $scope.lista = response.data;
                    }, function () {
                        alert("Error al consultar el Carreras");
                    });
        };

        $scope.guardarCarrera = function () {
            $http.post("./webresources/ServicioCarrera", $scope.datosFormulario)
                    .then(function (response) {
                        $scope.getCarrera();
                    });
            $scope.panelEditar = false;
        };

        $scope.getFacultades = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioFacultad", {})
                    .then(function (response) {
                        $scope.listaFacultad = response.data;
                    }, function () {
                        alert("Error al consultar el Facultad");
                    });
        };

        $scope.getCarrera();
        $scope.getFacultades();
    }]);
