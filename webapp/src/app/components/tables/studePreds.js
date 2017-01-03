/**
 * Copyright 2016 dryTools doo
 * Email: contact@drytools.co
 * 
 * This file is part of StudentskaSluzba.
 * 
 * StudentskaSluzba is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * StudentskaSluzba is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with StudentskaSluzba. If not, see <http://www.gnu.org/licenses/>.*
 **/
(function() {
    'use strict';

    angular
        .module('webapp')
        .directive('studePreds', function() {
            return {
                restrict: 'E',
                scope: {

                },
                templateUrl: 'src/app/components/tables/studePreds.html',
                controller: 'StudePredsController'
            };
        });

    angular
        .module('webapp')
        .controller('StudePredsController', StudePredsController);

    StudePredsController.$inject = ['$scope', 'eventBus', 'studPredApi'];

    function StudePredsController($scope, eventBus, studPredApi) {

        $scope.model = [];

        $scope.errorCode = null;
        $scope.onNoteUpdated = eventBus.onEvent('NoteUpdated', onNoteUpdated, $scope);

        onInit();

        function onInit() {

            studPreds(function(response) {
                $scope.errorCode = null;
                $scope.model = response.data.map(function(item) {
                    return {
                        id: item.id,
                        studentId: item.studentId,
                        predmetId: item.predmetId
                    }
                });
            });

        }

        function onNoteUpdated(event, payload) {
            studPreds(function(response) {
                $scope.errorCode = null;
                $scope.model = response.data.map(function(item) {
                    return {
                        id: item.id,
                        studentId: item.studentId,
                        predmetId: item.predmetId
                    }
                });
            });
        }

        function studPreds(successCallback) {
            studPredApi.studPreds().then(successCallback, onError);

            function onError(response) {
                if (response.status && response.statusText) {
                    $scope.errorCode = response.statusText;
                } else {
                    $scope.errorCode = 'Unknown error';
                }
            }
        }

    }
})();