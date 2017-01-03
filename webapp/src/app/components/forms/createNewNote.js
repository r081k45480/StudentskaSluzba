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
        .directive('createNewNote', function() {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'src/app/components/forms/createNewNote.html',
                controller: 'CreateNewNoteController'
            };
        });

    angular
        .module('webapp')
        .controller('CreateNewNoteController', CreateNewNoteController);

    CreateNewNoteController.$inject = ['$scope', 'eventBus', 'studPredApi'];

    function CreateNewNoteController($scope, eventBus, studPredApi) {

        $scope.model = {};
        $scope.errorCode = null;

        $scope.onClickSubmit = onClickSubmit;

        function onClickSubmit(form) {
            if (form.$invalid) {
                form.$setSubmitted();
                return false;
            }
            var request = {
                studentId: $scope.model.studentId,
                predmetId: $scope.model.predmetId
            };
            createStudPred(request, function(response) {
                $scope.errorCode = null;
                eventBus.emitEvent('ModalClose');
                eventBus.emitEvent('NoteUpdated', {});
            });

        }

        function createStudPred(request, successCallback) {
            studPredApi.createStudPred(request).then(successCallback, onError);

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