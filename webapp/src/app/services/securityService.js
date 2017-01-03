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
        .service('securityService', securityService);

    securityService.$inject = ['sessionService', '$location', '$q', '$http', 'clientConfigurationValues'];

    function securityService(sessionService, $location, $q, $http, clientConfigurationValues) {

        return {
            securedCall: securedCall
        };

        function securedCall(httpRequest) {
            if (!sessionService.isValidAccessToken()) {
                return refreshToken({
                    refreshToken: sessionService.getSessionData().refreshToken
                }).then(
                    function(data) {
                        sessionService.save(data.data);
                        return httpRequest();
                    },
                    function(data) {
                        console.log(data);
                        $location.path('/signIn');
                        return $q.reject(data);
                    }
                );
            }
            return httpRequest();
        }

        /** refreshToken 
         * request - RefreshTokenRequest {
         *   refreshToken: String
         * }
         *
         * response - RefreshTokenResponse {
         *   accessToken: String
         *   refreshToken: String
         *   id: Int
         *   ime: String
         *   prezime: String
         *   index: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         *   role: UserRole
         *   username: String
         * }
         *
         */
        function refreshToken(model) {
            return $http({
                method: 'POST',
                url: clientConfigurationValues.remoteBackendUrl + '/api/refresh-token',
                data: {
                    refreshToken: model.refreshToken
                },
                headers: {
                    'Content-Type': 'application/json'
                }
            });

        }

    }

})();