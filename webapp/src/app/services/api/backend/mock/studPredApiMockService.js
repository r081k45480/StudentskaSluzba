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
        .service('studPredApiMockService', studPredApiMockService);

    studPredApiMockService.$inject = ['$timeout'];

    function studPredApiMockService($timeout) {

        return {
            readStudPred: readStudPred,
            createStudPred: createStudPred,
            updateStudPred: updateStudPred,
            deleteStudPred: deleteStudPred,
            studPreds: studPreds,
            nepolozeniPredmeti: nepolozeniPredmeti,
            prijavljeniPredmeti: prijavljeniPredmeti,
            polozeniPredmeti: polozeniPredmeti,
            neslusaniPredmeti: neslusaniPredmeti,
            prijaviPredmet: prijaviPredmet,
            slusajPredmet: slusajPredmet
        };

        /** readStudPred 
         * request - Unit
         *
         * response - ReadStudPredResponse {
         *   id: Int
         *   studentId: Int
         *   predmetId: Int
         *   ocena: Optional[Int]
         *   datumPolozeno: Optional[DateTime]
         *   semestarPrvogSlusanja: Int
         *   semestarPoslednjeSlusanja: Int
         * }
         *
         */
        function readStudPred(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** createStudPred 
         * request - CreateStudPredRequest {
         *   studentId: Int
         *   predmetId: Int
         *   ocena: Optional[Int]
         *   datumPolozeno: Optional[DateTime]
         *   semestarPrvogSlusanja: Int
         *   semestarPoslednjeSlusanja: Int
         * }
         *
         * response - CreateStudPredResponse {
         *   id: Int
         *   studentId: Int
         *   predmetId: Int
         *   ocena: Optional[Int]
         *   datumPolozeno: Optional[DateTime]
         *   semestarPrvogSlusanja: Int
         *   semestarPoslednjeSlusanja: Int
         * }
         *
         */
        function createStudPred(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** updateStudPred 
         * request - RestUpdateStudPredRequest {
         *   studentId: Int
         *   predmetId: Int
         *   ocena: Optional[Int]
         *   datumPolozeno: Optional[DateTime]
         *   semestarPrvogSlusanja: Int
         *   semestarPoslednjeSlusanja: Int
         * }
         *
         * response - UpdateStudPredResponse {
         *   id: Int
         *   studentId: Int
         *   predmetId: Int
         *   ocena: Optional[Int]
         *   datumPolozeno: Optional[DateTime]
         *   semestarPrvogSlusanja: Int
         *   semestarPoslednjeSlusanja: Int
         * }
         *
         */
        function updateStudPred(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** deleteStudPred 
         * request - DeleteStudPredRequest {
         *   id: Int
         * }
         *
         * response - Unit
         *
         */
        function deleteStudPred(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** studPreds 
         * request - Unit
         *
         * response - List [
         *   StudPredsResponse {
         *     id: Int
         *     studentId: Int
         *     predmetId: Int
         *     ocena: Optional[Int]
         *     datumPolozeno: Optional[DateTime]
         *     semestarPrvogSlusanja: Int
         *     semestarPoslednjeSlusanja: Int
         *   }
         * ]
         *
         */
        function studPreds() {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** nepolozeniPredmeti 
         * request - Unit
         *
         * response - List [
         *   NepolozeniPredmetiResponse {
         *     predmetId: Int
         *   }
         * ]
         *
         */
        function nepolozeniPredmeti(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** prijavljeniPredmeti 
         * request - Unit
         *
         * response - List [
         *   PrijavljeniPredmetiResponse {
         *     id: Int
         *     studentId: Int
         *     predmetId: Int
         *     ocena: Optional[Int]
         *     datumPolozeno: Optional[DateTime]
         *     semestarPrvogSlusanja: Int
         *     semestarPoslednjeSlusanja: Int
         *   }
         * ]
         *
         */
        function prijavljeniPredmeti(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** polozeniPredmeti 
         * request - Unit
         *
         * response - List [
         *   PolozeniPredmetiResponse {
         *     id: Int
         *     studentId: Int
         *     predmetId: Int
         *     ocena: Optional[Int]
         *     datumPolozeno: Optional[DateTime]
         *     semestarPrvogSlusanja: Int
         *     semestarPoslednjeSlusanja: Int
         *   }
         * ]
         *
         */
        function polozeniPredmeti(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** neslusaniPredmeti 
         * request - Unit
         *
         * response - List [
         *   NeslusaniPredmetiResponse {
         *     id: Int
         *     studentId: Int
         *     predmetId: Int
         *     ocena: Optional[Int]
         *     datumPolozeno: Optional[DateTime]
         *     semestarPrvogSlusanja: Int
         *     semestarPoslednjeSlusanja: Int
         *   }
         * ]
         *
         */
        function neslusaniPredmeti(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** prijaviPredmet 
         * request - PrijaviPredmetRequest {
         *   userId: Int
         *   predmetId: Int
         * }
         *
         * response - Unit
         *
         */
        function prijaviPredmet(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }

        /** slusajPredmet 
         * request - SlusajPredmetRequest {
         *   userId: Int
         *   predmetId: Int
         * }
         *
         * response - Unit
         *
         */
        function slusajPredmet(model) {
            $timeout(function() {
                successCallback({
                    //TODO fill up mocked data values
                }, 500);
            });
        }
    }
})();