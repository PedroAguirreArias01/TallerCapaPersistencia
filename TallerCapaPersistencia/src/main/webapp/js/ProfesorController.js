'use strict';

module.controller('ProfesoresCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
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

        $scope.eliminar = function (data) {
            for (var i = 0; i < $scope.lista.length; i++) {
                if ($scope.lista[i] === data) {
                    $scope.lista.splice(i, 1);
                    break;
                }
            }
            console.log("Eliminado " + data);
            $.ajax({
                url: './webresources/ServicioProfesor/' + data.nombres,
                type: 'DELETE'
            });
        };

        $scope.getProfesores = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioProfesor", {})
                    .then(function (response) {
                        console.log(response.data);
                        $scope.lista = response.data;
                    }, function () {
                        alert("Error al consultar el Profesores");
                    });
        };

        $scope.guardarProfesor = function () {
            $http.post("./webresources/ServicioProfesor", $scope.datosFormulario)
                    .then(function (response) {
                        $scope.getProfesores();
                    });
            $scope.panelEditar = false;
        };
        $scope.getProfesores();
    }]);
