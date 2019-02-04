'use strict';

module.controller('FacultadCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        $scope.datosFormulario = {};
        $scope.id = 3;
        $scope.panelEditar = false;

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
                url: './webresources/ServicioFacultad/' + data.nombre,
                type: 'DELETE'
            });
        };

        $scope.getFacultades = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioFacultad", {})
                    .then(function (response) {
                        $scope.lista = response.data;
                    }, function () {
                        alert("Error al consultar el Facultad");
                    });
        };

        $scope.guardarFacultad = function () {
            $http.post("./webresources/ServicioFacultad", $scope.datosFormulario)
                    .then(function (response) {
                        $scope.getFacultades();
                    });
            $scope.panelEditar = false;
        };
        
        $scope.getFacultades();
        
    }]);
