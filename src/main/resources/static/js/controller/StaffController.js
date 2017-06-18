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
                    staffService.DELETE_STAFF({staffId: staff.staffId});
                }

                self.updateStaff = function (staff) {
                    console.log('Updating staff ' + staff.staffId);
                    staff.name = 'updated to yeo chien fui';
                    staffService.UPDATE_STAFF({staffId: staff.staffId}, staff);
                }

                /*
                 StaffInsertDTO:
                    {"icNo":null,"staffCode":null,"name":null,"basicPay":null,"epfNo":null,"epfRate":null,"joinDate":null,"terminationDate":null,"workExp":null,"status":null}
                 */
                self.insertStaff = function (staff) {
                    console.log('Inserting staff ' + staff);
                    var staffInsertDTO = null;

                    if (null != staff){
                        staffInsertDTO = staff;
                    }

                    var staffInsertDTO = {
                        icNo :  "900102123362",
                        staffCode :  "Admin100",
                        name :  "Teo Siew Li",
                        basicPay :  1800,
                        epfNo :  "P787984546",
                        epfRate :  11.5,
                        joinDate :  "10/10/2010",
                        terminationDate :  "Present",
                        workExp :  "5 years",
                        status :  "active"
                    };

                    staffService.INSERT_STAFF(staffInsertDTO);
                }
            }
        ]
    )