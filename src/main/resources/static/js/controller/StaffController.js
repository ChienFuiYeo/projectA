/*
'use strict';
*/

angular
    .module('payrollApp')
    .controller('staffController',
        ['$scope', 'staffService',
            function ($scope, staffService) {

                // Define Controller variable
                var self = this;
                self.staffs = [];
                self.deleteStatus = '';

                // Define Controller Function
                self.getStaffs = function () {
                    // staffService.getStaffs().then(function (data) {
                    //     self.staffs = data;
                    // });
                    console.log('Fetching all staffs');
                    self.staffs = staffService.query();
                }

                self.deleteStaff = function (staff) {
                    // staffService.deleteStaff(staffId).then(function (data) {
                    //     self.deleteStatus = data;
                    // });
                    console.log('Deleting staff ' + staff.staffId);
                    self.staffs = staffService.DELETE_STAFF({staffId: staff.staffId});
                }

                self.updateStaff = function (staff) {
                    console.log('Updating staff ' + staff.staffId);
                    staff.name = 'yeo chien fui';
                    self.staffs = staffService.UPDATE_STAFF({staffId: staff.staffId}, staff);
                }
            }
        ]
    )