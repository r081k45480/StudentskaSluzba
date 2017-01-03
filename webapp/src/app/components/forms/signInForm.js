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
        .directive('signInForm', function() {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'src/app/components/forms/signInForm.html',
                controller: 'SignInFormController'
            };
        });

    angular
        .module('webapp')
        .controller('SignInFormController', SignInFormController);

    SignInFormController.$inject = ['$scope', 'authenticationApi', 'sessionService'];

    function SignInFormController($scope, authenticationApi, sessionService) {

        $scope.model = {};
        $scope.errorCode = null;

        $scope.onClickSubmit = onClickSubmit;

        function onClickSubmit(form) {
            if (form.$invalid) {
                form.$setSubmitted();
                return false;
            }
            var request = {
                username: $scope.model.username,
                password: $scope.model.password
            };
            signIn(request, function(response) {
                $scope.errorCode = null;
                sessionService.save(response.data);

            });

        }

        function signIn(request, successCallback) {
            authenticationApi.signIn(request).then(successCallback, onError);

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