'use strict';

module.controller('MateriaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        $scope.listaCarrera = null;
        $scope.listaProfes = null;

        $scope.datosFormulario = {horario: []};
        $scope.panelEditar = false;
        $scope.datosHorario = {};
        //guardar
        $scope.nuevo = function () {
        $scope.panelEditar = true;
        };

        $scope.nuevoHorario = function () {
            $scope.datosHorario = {};
            $('#modalHorario').modal('show');
        };

        $scope.editarHorario = function (datos) {
            $scope.datosHorario = datos;
            $('#modalHorario').modal('show');
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
            if (confirm('\xbfDesea elminar este registro?')) {
                console.log('id de materia' + data.id);
                $http.delete('./webresources/ServicioMateria/' + data.id, {})
                        .success(function (data, status, headers, config) {
                            $scope.getMaterias();
                        }).error(function (data, status, headers, config) {
                    alert('Error al eliminar la informaci\xf3n de Materia, por favor intente m\xe1s tarde');
                });
            }
        };

        $scope.getMaterias = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioMateria", {})
                    .then(function (response) {
                        $scope.lista = response.data;
                        for (var i = 0; i < $scope.lista.length; i++) {
                            for (var j = 0; j < $scope.lista[i].horario.length; j++) {
                                console.log('este es el horario obtenido: '+$scope.lista[i].horario[j]);
                                var dat = $scope.lista[i].horario[j].horaFin.toString();
                                $scope.lista[i].horario[j].horaFin = dat.slice(0, dat.length - 5);
                                var datIni = $scope.lista[i].horario[j].horaInicio.toString();
                                $scope.lista[i].horario[j].horaInicio = datIni.slice(0, datIni.length - 5);
                            }
                        }
                    }, function () {
                        alert("Error al consultar Materias");
                    });
        };

        $scope.guardarMateria = function () {
            $http.post("./webresources/ServicioMateria", $scope.datosFormulario)
                    .then(function (response) {
                        $scope.getMaterias();
                    });
            $scope.panelEditar = false;
        };

        $scope.getCarrera = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioCarrera", {})
                    .then(function (response) {
                        $scope.listaCarrera = response.data;
                    }, function () {
                        alert("Error al consultar el Carreras");
                    });
        };

        $scope.getProfesores = function () {
            $scope.lista = null;
            $http.get("./webresources/ServicioProfesor", {})
                    .then(function (response) {
                        $scope.listaProfes = response.data;
                    }, function () {
                        alert("Error al consultar el Profesores");
                    });
        };

        $scope.guardarHorario = function () {
            $scope.datosFormulario.horario.push($scope.datosHorario);
            $('#modalHorario').modal('hide');
        };
      
        $scope.eliminarHorario = function (data) {
            if (confirm('\xbfDesea elminar este registro?')) {
                for (var i = 0; i < $scope.lista.length; i++) {
                    for (var j = 0; j < $scope.lista[i].horario.length; j++) {
                        if ($scope.lista[i].horario[j] === data) {
                            $scope.datosFormulario.horario.splice(j, 1);
                            $scope.datosFormulario.horario = $scope.lista[i].horario;
                            break;
                        }
                    }
                }
            }
            $.ajax({
                url: './webresources/ServicioEstudiante/eliminarHorario' + data,
                type: 'DELETE'
            });
        };
        
        //Llamada a metodos para obtener las listas
        $scope.getProfesores();
        $scope.getCarrera();
        $scope.getMaterias();

    }]);