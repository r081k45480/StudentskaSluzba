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
        .service('studentApiService', studentApiService);

    studentApiService.$inject = ['$http'];

    function studentApiService($http) {

        var backendApiUrl = '';

        return {
            init: init,
            readStudent: readStudent,
            createStudent: createStudent,
            updateStudent: updateStudent,
            deleteStudent: deleteStudent
        };

        function init(backendUrl) {
            backendApiUrl = backendUrl;
        }

        /** readStudent 
         * request - Unit
         *
         * response - ReadStudentResponse {
         *   id: Int
         *   ime: String
         *   prezime: String
         *   index: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         * }
         *
         */
        function readStudent(model) {
            return $http({
                method: 'GET',
                url: backendApiUrl + '/api/student/' + model.id + '',
                headers: {
                    'Content-Type': 'application/json'
                }
            });

        }

        /** createStudent 
         * request - CreateStudentRequest {
         *   ime: String
         *   prezime: String
         *   index: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         * }
         *
         * response - CreateStudentResponse {
         *   id: Int
         *   ime: String
         *   prezime: String
         *   index: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         * }
         *
         */
        function createStudent(model) {
            return $http({
                method: 'POST',
                url: backendApiUrl + '/api/student',
                data: {
                    ime: model.ime,
                    prezime: model.prezime,
                    index: model.index,
                    trenutnoStanjeRacuna: model.trenutnoStanjeRacuna,
                    budzet: model.budzet,
                    tekuciSemestar: model.tekuciSemestar,
                    osvojeniBodovi: model.osvojeniBodovi
                },
                headers: {
                    'Content-Type': 'application/json'
                }
            });

        }

        /** updateStudent 
         * request - RestUpdateStudentRequest {
         *   ime: String
         *   prezime: String
         *   index: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         * }
         *
         * response - UpdateStudentResponse {
         *   id: Int
         *   ime: String
         *   prezime: String
         *   index: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         * }
         *
         */
        function updateStudent(model) {
            return $http({
                method: 'PUT',
                url: backendApiUrl + '/api/student/' + model.id + '',
                data: {
                    ime: model.ime,
                    prezime: model.prezime,
                    index: model.index,
                    trenutnoStanjeRacuna: model.trenutnoStanjeRacuna,
                    budzet: model.budzet,
                    tekuciSemestar: model.tekuciSemestar,
                    osvojeniBodovi: model.osvojeniBodovi
                },
                headers: {
                    'Content-Type': 'application/json'
                }
            });

        }

        /** deleteStudent 
         * request - DeleteStudentRequest {
         *   id: Int
         * }
         *
         * response - Unit
         *
         */
        function deleteStudent(model) {
            return $http({
                method: 'DELETE',
                url: backendApiUrl + '/api/student/' + model.id + '',
                data: {
                    id: model.id
                },
                headers: {
                    'Content-Type': 'application/json'
                }
            });

        }

    }
})();