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
        .factory('translationService', translationService);

    translationService.$inject = ['$translate'];

    function translationService($translate) {
        return {
            listLanguages: listLanguages,
            currentLanguage: currentLanguage,
            changeLanguage: changeLanguage
        };

        function listLanguages() {
            return ['en'];
        }

        function currentLanguage() {
            return $translate.use();
        }

        function changeLanguage(key) {
            $translate.use(key);
        }
    }

    angular
        .module('webapp')
        .config(function($translateProvider) {

            $translateProvider.translations('en', {
                ALERT_CLOSE: 'Close',
                CANCEL: 'Cancel',
                CREATE_NEW_NOTE: 'Create new note',
                CREATE_NEW_NOTE_PREDMET_ID: 'Predmet id',
                CREATE_NEW_NOTE_PREDMET_ID_IS_REQUIRED: 'Predmet id is required',
                CREATE_NEW_NOTE_STUDENT_ID: 'Student id',
                CREATE_NEW_NOTE_STUDENT_ID_IS_REQUIRED: 'Student id is required',
                CREATE_NEW_NOTE_SUBMIT: 'Submit',
                DATA_SET_EMPTY_NO_DATA: 'No data',
                ERROR_MESSAGE: 'There was an error executing operation.',
                ERROR_TITLE: 'Error',
                MODAL_WINDOW_CLOSE: 'Close',
                NO: 'No',
                NOTES_PAGE_ADD_NOTE: 'Add note',
                OK: 'Ok',
                STUDE_PREDS_ID: 'Id',
                STUDE_PREDS_PREDMET_ID: 'Predmet id',
                STUDE_PREDS_STUDENT_ID: 'Student id',
                YES: 'Yes'
            });

            $translateProvider.preferredLanguage('en');

            $translateProvider.useSanitizeValueStrategy('sanitizeParameters');

            $translateProvider.useLocalStorage();
        });
})();