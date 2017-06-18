/*
'use strict';
*/

angular
    .module('payrollApp')
    .factory('staffService',
        ['$http', 'apiUrl', '$resource',
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
        ]
    )

// angular
//     .module('payrollApp')
//     .factory('staffService',
//         ['$http', 'apiUrl',
//             function ($http, apiUrl) {
//
//                 // Define Service Function
//                 var factory = {
//                     getStaffs: getStaffs,
//                     deleteStaff: deleteStaff
//                 };
//                 return factory;
//
//                 // Implement Service Function
//                 function getStaffs() {
//                     console.log('Fetching all staffs');
//
//                     return $http.get(apiUrl.STAFF).then(
//                         function success(response) {
//                             console.log('Success Fetching all staffs');
//                             return response.data;
//                         },
//                         function error(errResponse) {
//                             console.log('Error while Fetching all staffs');
//                         }
//                     );
//                 }
//
//                 function deleteStaff(staffId) {
//                     console.log('Deleting staff ' + staffId);
//
//                     return $http.delete(apiUrl.STAFF_DELETE, {staffId: '@staffId'}).then(
//                         function success(response) {
//                             console.log('Success Deleting staff ' + staffId);
//                             return response.data;
//                         },
//                         function error(errResponse) {
//                             console.log('Error while Deleting staff');
//                         }
//                     );
//                 }
//             }
//         ]
//     )