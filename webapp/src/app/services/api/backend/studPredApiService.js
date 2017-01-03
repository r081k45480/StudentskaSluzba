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
            studPreds: studPreds
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
         * }
         *
         */
        function readStudPred(model) {
            return $http({
                method: 'GET',
                url: backendApiUrl + '/api/studPred/' + model.id + ''
            });
        }

        /** createStudPred 
         * request - CreateStudPredRequest {
         *   studentId: Int
         *   predmetId: Int
         * }
         *
         * response - CreateStudPredResponse {
         *   id: Int
         *   studentId: Int
         *   predmetId: Int
         * }
         *
         */
        function createStudPred(model) {
            return $http({
                method: 'POST',
                url: backendApiUrl + '/api/studPred',
                data: {
                    studentId: model.studentId,
                    predmetId: model.predmetId
                }
            });
        }

        /** updateStudPred 
         * request - RestUpdateStudPredRequest {
         *   studentId: Int
         *   predmetId: Int
         * }
         *
         * response - UpdateStudPredResponse {
         *   id: Int
         *   studentId: Int
         *   predmetId: Int
         * }
         *
         */
        function updateStudPred(model) {
            return $http({
                method: 'PUT',
                url: backendApiUrl + '/api/studPred/' + model.id + '',
                data: {
                    studentId: model.studentId,
                    predmetId: model.predmetId
                }
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
         *   }
         * ]
         *
         */
        function studPreds() {
            return $http({
                method: 'GET',
                url: backendApiUrl + '/api/stud-preds'
            });
        }

    }
})();