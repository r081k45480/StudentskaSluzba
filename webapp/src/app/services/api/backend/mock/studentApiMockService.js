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
        .service('studentApiMockService', studentApiMockService);

    studentApiMockService.$inject = ['$timeout'];

    function studentApiMockService($timeout) {

        return {
            readStudent: readStudent,
            createStudent: createStudent,
            updateStudent: updateStudent,
            deleteStudent: deleteStudent,
            trenutnoStanje: trenutnoStanje
        };

        /** readStudent 
         * request - Unit
         *
         * response - ReadStudentResponse {
         *   id: Int
         *   ime: String
         *   prezime: String
         *   indeks: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         *   role: UserRole
         *   username: String
         *   passwordHash: String
         * }
         *
         */
        function readStudent(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** createStudent 
         * request - CreateStudentRequest {
         *   ime: String
         *   prezime: String
         *   indeks: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         *   role: UserRole
         *   username: String
         *   passwordHash: String
         * }
         *
         * response - CreateStudentResponse {
         *   id: Int
         *   ime: String
         *   prezime: String
         *   indeks: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         *   role: UserRole
         *   username: String
         *   passwordHash: String
         * }
         *
         */
        function createStudent(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** updateStudent 
         * request - RestUpdateStudentRequest {
         *   ime: String
         *   prezime: String
         *   indeks: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         *   role: UserRole
         *   username: String
         *   passwordHash: String
         * }
         *
         * response - UpdateStudentResponse {
         *   id: Int
         *   ime: String
         *   prezime: String
         *   indeks: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         *   role: UserRole
         *   username: String
         *   passwordHash: String
         * }
         *
         */
        function updateStudent(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
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
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** trenutnoStanje 
         * request - Unit
         *
         * response - TrenutnoStanjeResponse {
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         * }
         *
         */
        function trenutnoStanje(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }
    }
})();