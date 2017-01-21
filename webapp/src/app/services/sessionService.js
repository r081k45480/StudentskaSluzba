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

    function sessionService() {

        /* jshint ignore:start */
        var publicStates = [];
        publicStates['MainLayout'] = true;
        publicStates['MainLayout.naslovnaPage'] = true;
        publicStates['MainLayout.PredmetiPage'] = true;
        publicStates['MainLayout.PredmetiPage.nepolozeniPage'] = true;
        publicStates['MainLayout.PredmetiPage.polozeniPage'] = true;
        publicStates['MainLayout.PredmetiPage.neslusaniPage'] = true;
        publicStates['MainLayout.finansijePage'] = true;
        publicStates['signInPage'] = true;
        publicStates['signUpPage'] = true;

        /* jshint ignore:end */

        return {
            save: save,
            clear: clear,
            getSessionData: getSessionData,
            isLoggedIn: isLoggedIn,
            canUserAccessState: canUserAccessState
        };

        function save(sessionData) {
            localStorage.setItem('accessToken', sessionData.accessToken);
            localStorage.setItem('id', sessionData.id);
            localStorage.setItem('ime', sessionData.ime);
            localStorage.setItem('prezime', sessionData.prezime);
            localStorage.setItem('indeks', sessionData.indeks);
            localStorage.setItem('trenutnoStanjeRacuna', sessionData.trenutnoStanjeRacuna);
            localStorage.setItem('budzet', sessionData.budzet);
            localStorage.setItem('tekuciSemestar', sessionData.tekuciSemestar);
            localStorage.setItem('osvojeniBodovi', sessionData.osvojeniBodovi);
            localStorage.setItem('role', sessionData.role);
            localStorage.setItem('username', sessionData.username);
        }

        function clear() {
            localStorage.removeItem('accessToken');
            localStorage.removeItem('id');
            localStorage.removeItem('ime');
            localStorage.removeItem('prezime');
            localStorage.removeItem('indeks');
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
                id: localStorage.getItem('id'),
                ime: localStorage.getItem('ime'),
                prezime: localStorage.getItem('prezime'),
                indeks: localStorage.getItem('indeks'),
                trenutnoStanjeRacuna: localStorage.getItem('trenutnoStanjeRacuna'),
                budzet: localStorage.getItem('budzet'),
                tekuciSemestar: localStorage.getItem('tekuciSemestar'),
                osvojeniBodovi: localStorage.getItem('osvojeniBodovi'),
                role: localStorage.getItem('role'),
                username: localStorage.getItem('username')
            };
        }

        function isLoggedIn() {
            return localStorage.getItem("accessToken") !== null;
        }

        function canUserAccessState(stateName) {
            if (publicStates[stateName]) {
                return true;
            }

            var user = getSessionData();
            if (!user) {
                return false;
            }

            return stateAccessRights[stateName][user.role];
        }

    }

})();