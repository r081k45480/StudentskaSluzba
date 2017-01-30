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
        .directive('nepolozeni', function() {
            return {
                restrict: 'E',
                scope: {
                    userId: '='
                },
                templateUrl: 'src/app/components/tables/nepolozeni.html',
                controller: 'NepolozeniController'
            };
        });

    angular
        .module('webapp')
        .controller('NepolozeniController', NepolozeniController);

    NepolozeniController.$inject = ['$scope', 'eventBus', 'studPredApi'];

    function NepolozeniController($scope, eventBus, studPredApi) {
        $scope.model = [];
        $scope.errorCode = null;
        $scope.onpredmetChangedEvent = eventBus.onEvent('predmetChangedEvent', onpredmetChangedEvent);
        $scope.onClickPrijavi = onClickPrijavi;

        if ($scope.userId) load($scope.userId);

        function load(userId) {
            var request = {
                userId: userId
            };
            studPredApi.nepolozeniPredmeti(request).then(onSuccess, onError);

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
            load($scope.userId);
        }

        function onClickPrijavi(item) {
            prijaviPredmet($scope.userId, item.predmetId);
        }

        function prijaviPredmet(userId, predmetId) {
            var request = {
                userId: userId,
                predmetId: predmetId
            };
            studPredApi.prijaviPredmet(request).then(onSuccess, onError);

            function onSuccess(response) {
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
