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
        .service('studPredApiService', studPredApiService);

    studPredApiService.$inject = ['$http', 'sessionService'];

    function studPredApiService($http, sessionService) {

        var backendApiUrl = '';

        return {
            init: init,
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

        function init(backendUrl) {
            backendApiUrl = backendUrl;
        }

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
            return $http({
                method: 'GET',
                url: backendApiUrl + '/api/studPred/' + model.id + ''
            }).then(convertReadStudPredResponse);
        }

        function convertReadStudPredResponse(response) {
            response.data.datumPolozeno = response.data.datumPolozeno ? new Date(response.data.datumPolozeno) : null;
            return response;
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
            return $http({
                method: 'POST',
                url: backendApiUrl + '/api/studPred',
                data: {
                    studentId: model.studentId,
                    predmetId: model.predmetId,
                    ocena: model.ocena,
                    datumPolozeno: model.datumPolozeno,
                    semestarPrvogSlusanja: model.semestarPrvogSlusanja,
                    semestarPoslednjeSlusanja: model.semestarPoslednjeSlusanja
                }
            }).then(convertCreateStudPredResponse);
        }

        function convertCreateStudPredResponse(response) {
            response.data.datumPolozeno = response.data.datumPolozeno ? new Date(response.data.datumPolozeno) : null;
            return response;
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
            return $http({
                method: 'PUT',
                url: backendApiUrl + '/api/studPred/' + model.id + '',
                data: {
                    studentId: model.studentId,
                    predmetId: model.predmetId,
                    ocena: model.ocena,
                    datumPolozeno: model.datumPolozeno,
                    semestarPrvogSlusanja: model.semestarPrvogSlusanja,
                    semestarPoslednjeSlusanja: model.semestarPoslednjeSlusanja
                }
            }).then(convertUpdateStudPredResponse);
        }

        function convertUpdateStudPredResponse(response) {
            response.data.datumPolozeno = response.data.datumPolozeno ? new Date(response.data.datumPolozeno) : null;
            return response;
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
            return $http({
                method: 'DELETE',
                url: backendApiUrl + '/api/studPred/' + model.id + '',
                data: {
                    id: model.id
                }
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
            return $http({
                method: 'GET',
                url: backendApiUrl + '/api/stud-preds'
            }).then(convertStudPredsResponse);
        }

        function convertStudPredsResponse(response) {
            response.data.forEach(function(item) {
                item.datumPolozeno = item.datumPolozeno ? new Date(item.datumPolozeno) : null;
            });
            return response;
        }

        /** nepolozeniPredmeti 
         * request - Unit
         *
         * response - List [
         *   NepolozeniPredmetiResponse {
         *     predmetId: Int
         *     predmetNaziv: String
         *     predmetEspb: Int
         *     predmetObavezni: Boolean
         *     predmetPredlozeniSemestar: Int
         *     predmetImeProfesora: String
         *     semestarPrvogSlusanja: Int
         *   }
         * ]
         *
         */
        function nepolozeniPredmeti(model) {
            return $http({
                method: 'GET',
                url: backendApiUrl + '/api/nepolozeni-predmeti',
                params: {
                    userId: model.userId
                }
            });
        }

        /** prijavljeniPredmeti 
         * request - Unit
         *
         * response - List [
         *   PrijavljeniPredmetiResponse {
         *     predmetNaziv: String
         *     predmetEspb: Int
         *     predmetObavezni: Boolean
         *     predmetPredlozeniSemestar: Int
         *     predmetImeProfesora: String
         *     semestarPrvogSlusanja: Int
         *   }
         * ]
         *
         */
        function prijavljeniPredmeti(model) {
            return $http({
                method: 'GET',
                url: backendApiUrl + '/api/prijavljeni-predmeti',
                params: {
                    userId: model.userId
                }
            });
        }

        /** polozeniPredmeti 
         * request - Unit
         *
         * response - List [
         *   PolozeniPredmetiResponse {
         *     predmetId: Int
         *     predmetNaziv: String
         *     predmetEspb: Int
         *     predmetObavezni: Boolean
         *     predmetImeProfesora: String
         *     semestarPrvogSlusanja: Int
         *     ocena: Optional[Int]
         *     datumPolozeno: Optional[DateTime]
         *   }
         * ]
         *
         */
        function polozeniPredmeti(model) {
            return $http({
                method: 'GET',
                url: backendApiUrl + '/api/polozeni-predmeti',
                params: {
                    userId: model.userId
                }
            }).then(convertPolozeniPredmetiResponse);
        }

        function convertPolozeniPredmetiResponse(response) {
            response.data.forEach(function(item) {
                item.datumPolozeno = item.datumPolozeno ? new Date(item.datumPolozeno) : null;
            });
            return response;
        }

        /** neslusaniPredmeti 
         * request - Unit
         *
         * response - List [
         *   NeslusaniPredmetiResponse {
         *     predmetId: Int
         *     predmetNaziv: String
         *     predmetEspb: Int
         *     predmetObavezni: Boolean
         *     predmetPredlozeniSemestar: Int
         *     predmetImeProfesora: String
         *     semestarPrvogSlusanja: Int
         *   }
         * ]
         *
         */
        function neslusaniPredmeti(model) {
            return $http({
                method: 'GET',
                url: backendApiUrl + '/api/neslusani-predmeti',
                params: {
                    userId: model.userId
                }
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
            return $http({
                method: 'POST',
                url: backendApiUrl + '/api/prijavi',
                data: {
                    userId: model.userId,
                    predmetId: model.predmetId
                }
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
            return $http({
                method: 'POST',
                url: backendApiUrl + '/api/slusaj',
                data: {
                    userId: model.userId,
                    predmetId: model.predmetId
                }
            });
        }

    }
})();