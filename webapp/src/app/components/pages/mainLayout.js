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
        .controller('MainLayoutController', MainLayoutController);

    MainLayoutController.$inject = ['$scope', '$state', 'sessionService'];

    function MainLayoutController($scope, $state, sessionService) {

        $scope.onClickNaslovna = onClickNaslovna;
        $scope.onClickPredmeti = onClickPredmeti;
        $scope.onClickFinansije = onClickFinansije;

		onInit()
		
		function onInit(){
			onClickNaslovna;
		}
		
        function onClickNaslovna() {
            $state.go('MainLayout.naslovnaPage');
        }

        function onClickPredmeti() {
            $state.go('MainLayout.predmetiPage');
        }

        function onClickFinansije() {
            $state.go('MainLayout.finansijePage');
        }

    }
})();