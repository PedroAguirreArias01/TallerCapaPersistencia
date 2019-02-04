'use strict';

module.controller('MunicipioCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        $scope.lista = null;
        $scope.datosFormulario = {};
        $scope.panelEditar = false;

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
            console.log("Eliminado " + data.nombre);
            $.ajax({
                url: './webresources/ServicioMunicipio/' + data.nombre,
                type: 'DELETE'
            });
        };

        $scope.getMunicipios = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioMunicipio", {})
                    .then(function (response) {
                        console.log(response.data);
                        $scope.lista = response.data;
                    }, function () {
                        alert("Error al consultar el Municipios");
                    });
        };

        $scope.guardarMunicipio = function () {
            $http.post("./webresources/ServicioMunicipio", $scope.datosFormulario)
                    .then(function (response) {
                        $scope.getMunicipios();
                
                    });
            $scope.panelEditar = false;
        };
        $scope.getMunicipios();
    }]);
