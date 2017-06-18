/*
'use strict';
*/

angular
    .module('payrollApp')
    .factory('jobService',
        ['$http', 'apiUrl', '$resource',
            function ($http, apiUrl, $resource) {

                return $resource('http://localhost\\:8080/job/:jobId', {jobId: '@jobId'},
                    {
                        INSERT_JOB: {method: 'POST'},
                        UPDATE_JOB: {method: 'PUT'},
                        DELETE_JOB: {method: 'DELETE'}

                        // Sample for cuatomized url
                        // UPDATE: {method: 'PUT', url: 'http://localhost\\:3000/realmen/:entryId' },
                        // ACTION: {method: 'PUT', url: 'http://localhost\\:3000/realmen/:entryId/action' }
                    }
                );
            }
        ]
    )