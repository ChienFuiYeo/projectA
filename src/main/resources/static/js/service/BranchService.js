/*
'use strict';
*/

angular
    .module('payrollApp')
    .factory('branchService', ['$http', 'apiUrl', '$resource',
        function ($http, apiUrl, $resource) {

            return $resource('/branch/:branchId', {branchId: '@branchId'},
                {
                    INSERT_BRANCH: {method: 'POST'},
                    UPDATE_BRANCH: {method: 'PUT'},
                    DELETE_BRANCH: {method: 'DELETE'}

                    // Sample for cuatomized url
                    // UPDATE: {method: 'PUT', url: 'http://localhost\\:3000/realmen/:entryId' },
                    // ACTION: {method: 'PUT', url: 'http://localhost\\:3000/realmen/:entryId/action' }
                }
            );
        }
    ])