/*
'use strict';
*/

angular
    .module('payrollApp')
    .factory('staffService', ['$http', 'apiUrl', '$resource',
        function ($http, apiUrl, $resource) {

            return $resource('/staff/:staffId', {staffId: '@staffId'},
                {
                    INSERT_STAFF: {method: 'POST'},
                    UPDATE_STAFF: {method: 'PUT'},
                    DELETE_STAFF: {method: 'DELETE'}

                    // Sample for cuatomized url
                    // UPDATE: {method: 'PUT', url: 'http://localhost\\:3000/realmen/:entryId' },
                    // ACTION: {method: 'PUT', url: 'http://localhost\\:3000/realmen/:entryId/action' }
                }
            );
        }
    ])