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
        .directive('neslusani', function() {
            return {
                restrict: 'E',
                scope: {
                    userId: '='
                },
                templateUrl: 'src/app/components/tables/neslusani.html',
                controller: 'NeslusaniController'
            };
        });

    angular
        .module('webapp')
        .controller('NeslusaniController', NeslusaniController);

    NeslusaniController.$inject = ['$scope', 'eventBus', 'studPredApi'];

    function NeslusaniController($scope, eventBus, studPredApi) {
        $scope.model = [];
        $scope.errorCode = null;
        $scope.onpredmetChangedEvent = eventBus.onEvent('predmetChangedEvent', onpredmetChangedEvent);
        $scope.onClickSlusaj = onClickSlusaj;

        if ($scope.userId) load($scope.userId);

        function load(userId) {
            var request = {
                userId: userId
            };
            studPredApi.neslusaniPredmeti(request).then(onSuccess, onError);

            function onSuccess(response) {
                $scope.model = response.data;
            }

            function onError(response) {
                if (response.status && response.statusText) {
                    $scope.errorCode = response.statusText;
                } else {
                    $scope.errorCode = 'Unknown error';
                }
            }

        }

        function onpredmetChangedEvent(event, payload) {
            load();
        }

        function onClickSlusaj(item) {
            slusajPredmet($scope.userId);
        }

        function slusajPredmet(userId, predmetId) {
            var request = {
                userId: userId,
                predmetId: predmetId
            };
            studPredApi.slusajPredmet(request).then(onSuccess, onError);

            function onSuccess(response) {
                response.data.forEach(function(item) {
                    item.datumPolozeno = new Date(item.datumPolozeno);
                });
                eventBus.emitEvent('predmetChangedEvent');
                $scope.errorCode = null;
            }

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