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
        .service('finansijeApiMockService', finansijeApiMockService);

    finansijeApiMockService.$inject = ['$timeout'];

    function finansijeApiMockService($timeout) {

        return {
            readFinansije: readFinansije,
            createFinansije: createFinansije,
            updateFinansije: updateFinansije,
            deleteFinansije: deleteFinansije,
            finansijeStudenta: finansijeStudenta
        };

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
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
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
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
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
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
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
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
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
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }
    }
})();