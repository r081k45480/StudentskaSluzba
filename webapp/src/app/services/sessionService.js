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
        .service('sessionService', sessionService);

    sessionService.$inject = ['jwtHelper'];

    function sessionService(jwtHelper) {

        /* jshint ignore:start */
        var publicStates = [];
        publicStates['notesPage'] = true;
        publicStates['signInPage'] = true;
        publicStates['signUpPage'] = true;

        /* jshint ignore:end */

        return {
            save: save,
            clear: clear,
            getSessionData: getSessionData,
            isLoggedIn: isLoggedIn,
            canUserAccessState: canUserAccessState,
            isValidAccessToken: isValidAccessToken,
            isValidRefreshToken: isValidRefreshToken
        };

        function save(sessionData) {
            localStorage.setItem('accessToken', sessionData.accessToken);
            localStorage.setItem('refreshToken', sessionData.refreshToken);
            localStorage.setItem('id', sessionData.id);
            localStorage.setItem('ime', sessionData.ime);
            localStorage.setItem('prezime', sessionData.prezime);
            localStorage.setItem('index', sessionData.index);
            localStorage.setItem('trenutnoStanjeRacuna', sessionData.trenutnoStanjeRacuna);
            localStorage.setItem('budzet', sessionData.budzet);
            localStorage.setItem('tekuciSemestar', sessionData.tekuciSemestar);
            localStorage.setItem('osvojeniBodovi', sessionData.osvojeniBodovi);
            localStorage.setItem('role', sessionData.role);
            localStorage.setItem('username', sessionData.username);
        }

        function clear() {
            localStorage.removeItem('accessToken');
            localStorage.removeItem('refreshToken');
            localStorage.removeItem('id');
            localStorage.removeItem('ime');
            localStorage.removeItem('prezime');
            localStorage.removeItem('index');
            localStorage.removeItem('trenutnoStanjeRacuna');
            localStorage.removeItem('budzet');
            localStorage.removeItem('tekuciSemestar');
            localStorage.removeItem('osvojeniBodovi');
            localStorage.removeItem('role');
            localStorage.removeItem('username');
        }

        function getSessionData() {
            return {
                accessToken: localStorage.getItem('accessToken'),
                refreshToken: localStorage.getItem('refreshToken'),
                id: localStorage.getItem('id'),
                ime: localStorage.getItem('ime'),
                prezime: localStorage.getItem('prezime'),
                index: localStorage.getItem('index'),
                trenutnoStanjeRacuna: localStorage.getItem('trenutnoStanjeRacuna'),
                budzet: localStorage.getItem('budzet'),
                tekuciSemestar: localStorage.getItem('tekuciSemestar'),
                osvojeniBodovi: localStorage.getItem('osvojeniBodovi'),
                role: localStorage.getItem('role'),
                username: localStorage.getItem('username')
            };
        }

        function isValidAccessToken() {
            var accessToken = localStorage.getItem('accessToken');
            if (accessToken == undefined) return false;

            var validUntil = jwtHelper.getTokenExpirationDate(accessToken);
            return validUntil.getTime() > new Date().getTime() + 5000;
        }

        function isValidRefreshToken() {
            var refreshToken = localStorage.getItem('refreshToken');
            if (refreshToken == undefined) return false;

            var validUntil = jwtHelper.getTokenExpirationDate(refreshToken);
            return validUntil.getTime() > new Date().getTime();
        }

        function isLoggedIn() {
            return localStorage.getItem("accessToken") !== null;
        }

        function canUserAccessState(stateName) {
            if (publicStates[stateName]) {
                return true;
            }

            var user = getSessionData();
            if (!user.role) {
                return false;
            }

            return isValidRefreshToken() && stateAccessRights[stateName][user.role];
        }

    }

})();