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
        .provider('studentApi', studentApi)
        .config(studentApiProvider);

    function studentApi() {
        var isMocked = false;

        var $get = ['studentApiService', 'studentApiMockService', 'clientConfigurationValues', function(studentApiService, studentApiMockService, clientConfigurationValues) {
            if (this.isMocked) {
                return studentApiMockService;
            } else {
                if (clientConfigurationValues.remoteBackendUrl) {
                    studentApiService.init(clientConfigurationValues.remoteBackendUrl);
                }
                return studentApiService;
            }
        }];

        return {
            isMocked: isMocked,
            $get: $get
        };
    }

    function studentApiProvider(clientConfigurationValues, studentApiProvider) {
        studentApiProvider.isMocked = clientConfigurationValues.useServerMock;
    }

    angular
        .module('webapp')
        .provider('studPredApi', studPredApi)
        .config(studPredApiProvider);

    function studPredApi() {
        var isMocked = false;

        var $get = ['studPredApiService', 'studPredApiMockService', 'clientConfigurationValues', function(studPredApiService, studPredApiMockService, clientConfigurationValues) {
            if (this.isMocked) {
                return studPredApiMockService;
            } else {
                if (clientConfigurationValues.remoteBackendUrl) {
                    studPredApiService.init(clientConfigurationValues.remoteBackendUrl);
                }
                return studPredApiService;
            }
        }];

        return {
            isMocked: isMocked,
            $get: $get
        };
    }

    function studPredApiProvider(clientConfigurationValues, studPredApiProvider) {
        studPredApiProvider.isMocked = clientConfigurationValues.useServerMock;
    }

})();