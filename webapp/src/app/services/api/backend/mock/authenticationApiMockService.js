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
        .service('authenticationApiMockService', authenticationApiMockService);

    authenticationApiMockService.$inject = ['$timeout'];

    function authenticationApiMockService($timeout) {

        return {
            signUp: signUp,
            signIn: signIn,
            changePassword: changePassword
        };

        /** signUp 
         * request - SignUpRequest {
         *   stanjaIds: List[Int]
         *   ime: String
         *   prezime: String
         *   index: String
         *   trenutnoStanjeRacuna: Decimal(10, 4)
         *   budzet: Boolean
         *   tekuciSemestar: Int
         *   osvojeniBodovi: Int
         *   username: String
         *   password: String
         * }
         *
         * response - SignUpResponse {
         *   id: Int
         *   stanjaId: List[Int]
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
        function signUp(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** signIn 
         * request - SignInRequest {
         *   username: String
         *   password: String
         * }
         *
         * response - SignInResponse {
         *   accessToken: String
         *   id: Int
         *   stanjaId: List[Int]
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
        function signIn(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** changePassword (secured)
         * request - ChangePasswordRequest {
         *   oldPassword: String
         *   newPassword: String
         * }
         *
         * response - ChangePasswordResponse {
         *   id: Int
         *   stanjaId: List[Int]
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
        function changePassword(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }
    }
})();