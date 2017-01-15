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

    angular.module('webapp').factory('modalWindows', modalService);

    modalService.$inject = ['$uibModal'];

    function modalService($uibModal) {

        function openModal(input, template, size) {
            return $uibModal.open({
                template: template,
                controller: 'ModalController',
                bindToController: true,
                backdrop: "static",
                size: size,
                resolve: {
                    input: function() {
                        if (input) {
                            return input;
                        }
                        return {};
                    }
                }
            });
        }

        return {

        };
    }

    angular.module('webapp').controller('ModalController', ModalController);
    ModalController.$inject = ['$scope', 'input', 'eventBus', '$uibModalInstance'];

    function ModalController($scope, input, eventBus, $uibModalInstance) {
        $scope.input = input;
        $scope.close = function() {
            $uibModalInstance.dismiss();
        };

        eventBus.onEvent('ModalClose', function() {
            $uibModalInstance.close();
        });
    }
})();