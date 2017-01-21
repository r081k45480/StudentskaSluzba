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
        .service('finansijeApiService', finansijeApiService);

    finansijeApiService.$inject = ['$http', 'sessionService'];

    function finansijeApiService($http, sessionService) {

        var backendApiUrl = '';

        return {
            init: init,
            readFinansije: readFinansije,
            createFinansije: createFinansije,
            updateFinansije: updateFinansije,
            deleteFinansije: deleteFinansije,
            finansijeStudenta: finansijeStudenta
        };

        function init(backendUrl) {
            backendApiUrl = backendUrl;
        }

        /** readFinansije 
         * request - Unit
         *
         * response - ReadFinansijeResponse {
         *   id: Int
         *   studentId: Int
         *   iznos: Decimal(10, 4)
         *   prethodnoStanje: Decimal(10, 4)
         *   datum: DateTime
         * }
         *
         */
        function readFinansije(model) {
            return $http({
                method: 'GET',
                url: backendApiUrl + '/api/finansije/' + model.id + ''
            }).then(convertReadFinansijeResponse);
        }

        function convertReadFinansijeResponse(response) {
            response.data.datum = new Date(response.data.datum);
            return response;
        }

        /** createFinansije 
         * request - CreateFinansijeRequest {
         *   studentId: Int
         *   iznos: Decimal(10, 4)
         *   prethodnoStanje: Decimal(10, 4)
         *   datum: DateTime
         * }
         *
         * response - CreateFinansijeResponse {
         *   id: Int
         *   studentId: Int
         *   iznos: Decimal(10, 4)
         *   prethodnoStanje: Decimal(10, 4)
         *   datum: DateTime
         * }
         *
         */
        function createFinansije(model) {
            return $http({
                method: 'POST',
                url: backendApiUrl + '/api/finansije',
                data: {
                    studentId: model.studentId,
                    iznos: model.iznos,
                    prethodnoStanje: model.prethodnoStanje,
                    datum: model.datum
                }
            }).then(convertCreateFinansijeResponse);
        }

        function convertCreateFinansijeResponse(response) {
            response.data.datum = new Date(response.data.datum);
            return response;
        }

        /** updateFinansije 
         * request - RestUpdateFinansijeRequest {
         *   studentId: Int
         *   iznos: Decimal(10, 4)
         *   prethodnoStanje: Decimal(10, 4)
         *   datum: DateTime
         * }
         *
         * response - UpdateFinansijeResponse {
         *   id: Int
         *   studentId: Int
         *   iznos: Decimal(10, 4)
         *   prethodnoStanje: Decimal(10, 4)
         *   datum: DateTime
         * }
         *
         */
        function updateFinansije(model) {
            return $http({
                method: 'PUT',
                url: backendApiUrl + '/api/finansije/' + model.id + '',
                data: {
                    studentId: model.studentId,
                    iznos: model.iznos,
                    prethodnoStanje: model.prethodnoStanje,
                    datum: model.datum
                }
            }).then(convertUpdateFinansijeResponse);
        }

        function convertUpdateFinansijeResponse(response) {
            response.data.datum = new Date(response.data.datum);
            return response;
        }

        /** deleteFinansije 
         * request - DeleteFinansijeRequest {
         *   id: Int
         * }
         *
         * response - Unit
         *
         */
        function deleteFinansije(model) {
            return $http({
                method: 'DELETE',
                url: backendApiUrl + '/api/finansije/' + model.id + '',
                data: {
                    id: model.id
                }
            });
        }

        /** finansijeStudenta 
         * request - Unit
         *
         * response - List [
         *   FinansijeStudentaResponse {
         *     id: Int
         *     studentId: Int
         *     iznos: Decimal(10, 4)
         *     prethodnoStanje: Decimal(10, 4)
         *     datum: DateTime
         *   }
         * ]
         *
         */
        function finansijeStudenta(model) {
            return $http({
                method: 'GET',
                url: backendApiUrl + '/api/finansije-studenta',
                params: {
                    studentId: model.studentId
                }
            }).then(convertFinansijeStudentaResponse);
        }

        function convertFinansijeStudentaResponse(response) {
            response.data.forEach(function(item) {
                item.datum = new Date(item.datum);
            });
            return response;
        }
    }
})();