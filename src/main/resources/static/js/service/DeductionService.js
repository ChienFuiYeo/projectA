/*
'use strict';
*/

angular
    .module('payrollApp')
    .factory('deductionService', ['$http', 'apiUrl', '$resource',
        function ($http, apiUrl, $resource) {

            return $resource('/deduction/:deductionId', {deductionId: '@deductionId'},
                {
                    INSERT_DEDUCTION: {method: 'POST'},
                    UPDATE_DEDUCTION: {method: 'PUT'},
                    DELETE_DEDUCTION: {method: 'DELETE'}
                }
            );
        }
    ])