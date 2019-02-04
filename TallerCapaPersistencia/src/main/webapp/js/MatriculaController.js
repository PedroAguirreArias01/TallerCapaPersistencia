'use strict';

module.controller('MatriculaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        $scope.listaMateria = null;
        $scope.listaEstudia = null;

        $scope.datosFormulario = {materias: []};
        $scope.panelEditar = false;
        $scope.datosMateria = {};

        $scope.matCarr = [];
        //$scope.materia = [];

        $scope.nuevaMateria = function () {
            $scope.datosMateria = {};
            $('#modalMateria').modal('show');
        };

        $scope.searchMat = function (data) {
            $scope.matCarr = [];
            for (var i = 0; i < $scope.listaMateria.length; i++) {
                if ($scope.listaMateria[i].carrera.nombre === data.nombre) {
                    $scope.matCarr.push($scope.listaMateria[i]);
                }
            }
        };

        //guardar
        $scope.nuevo = function () {
            $scope.panelEditar = true;
            //$scope.datosFormulario = {};
            $scope.matCarr = [];
        };

        $scope.guardar = function () {
            console.log('annio: ' + $scope.datosFormulario.annio);
            $scope.errores = {};
            var error = false;
            if (error)
                return;
            $http.post("./webresources/ServicioMatricula", $scope.datosFormulario)
                    .then(function (response) {
                        $scope.getMatriculas();
                    });
            $scope.panelEditar = false;
        };

        $scope.cancelar = function () {
            $scope.panelEditar = false;
            $scope.datosFormulario = {};
            $scope.matCarr = [];
        };

        //editar
        $scope.editar = function (data) {
            $scope.matCarr = [];
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
        };

        $scope.getMatriculas = function () {
            $http.get("./webresources/ServicioMatricula", {})
                    .then(function (response) {
                        $scope.lista = response.data;
                    }, function () {
                        alert("Error al consultar Matriculas");
                    });
        };

        $scope.getMatriculas();

        $scope.getEstudiantes = function () {
            $http.get("./webresources/ServicioEstudiante", {})
                    .then(function (response) {
                        $scope.listaEstudia = response.data;
                    }, function () {
                        alert("Error al consultar el estudiante");
                    });
        };

        $scope.getEstudiantes();

        $scope.getMaterias = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioMateria", {})
                    .then(function (response) {
                        $scope.listaMateria = response.data;


                    }, function () {
                        alert("Error al consultar Materias");
                    });
        };

        //eliminar
        $scope.eliminar = function (data) {
            if (confirm('\xbfDesea elminar este registro?')) {
                console.log('id de matricula' + data.id);
                $http.delete('./webresources/ServicioMatricula/' + data.id, {})
                        .success(function (data, status, headers, config) {
                            $scope.getMatriculas();
                        }).error(function (data, status, headers, config) {
                    alert('Error al eliminar la informaci\xf3n de Estudiante, por favor intente m\xe1s tarde');
                });
            }
        };

        $scope.getMaterias();

        $scope.guardarMaterias = function () {
            //$scope.datosFormulario = {materias: []};
            for (var i = 0; i < $scope.matCarr.length; i++) {
                if ($scope.matCarr[i].nombre === $scope.datosMateria.nombre) {
                    console.log('esta es la materia seleccionada: ' + $scope.datosMateria.nombre);
                    $scope.datosFormulario.materias.push($scope.matCarr[i]);
                    break;
                }
            }
            $('#modalMateria').modal('hide');
        };

    }]);
