/*
'use strict';
*/

angular
    .module('payrollApp')
    .factory('staffService',
        ['$http', 'apiUrl', '$resource',
            function ($http, apiUrl, $resource) {

                return $resource('http://localhost\\:8080/staff/:staffId', {staffId: '@staffId'},
                    {
                        INSERT_STAFF: {method: 'POST'},
                        UPDATE_STAFF: {method: 'PUT'},
                        DELETE_STAFF: {method: 'DELETE'}
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