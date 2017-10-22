/*
 'use strict';
 */

var payrollApp = angular.module('payrollApp');

payrollApp
    .controller('staffController',
        ['$scope', '$state', '$mdDialog', 'staffService',
            function ($scope, $state, $mdDialog, staffService) {



                // Ready function (BootstrapValidator)
                angular.element(document).ready(function () {
                    $('#createStaffForm').bootstrapValidator({
                        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        excluded: [':disabled'],
                        fields: {
                            staffCode: {
                                validators: {
                                    stringLength: {
                                        min: 5,
                                    },
                                    notEmpty: {
                                        message: 'Please enter staff code.'
                                    }
                                }
                            }
                        },
                        onSuccess: function(e, data) {
                            console.log("onsuccess prevent default submission")

                            // Prevent form submission
                            e.preventDefault();
                        }
                    })
                });

                // Sorting table column
                $scope.sortKey = 'staffId';
                $scope.reverse = false;
                $scope.sort = function (key) {
                    $scope.reverse = ($scope.sortKey == key) ? !$scope.reverse : $scope.reverse;
                    $scope.sortKey = key;
                }

                // Status
                $scope.staffData = {
                    availableStatus: [
                        {name: "Active", value: "Active"},
                        {name: "Not Active", value: "Not Active"}
                    ],
                    selectedStatus: {name: "Active", value: "Active"} //This sets the default value of the select in the ui
                };

                // Define Controller variable
                var self = this;
                self.staffs = [];
                self.deleteStatus = '';
                self.selectedStaff = null;
                self.editStaff = null;
                self.newStaff = {};
                $scope.dt = new Date();

                self.setSelectedStaff = function (selectedStaff) {
                    self.selectedStaff = selectedStaff;
                    self.editStaff = JSON.parse(JSON.stringify(selectedStaff));
                    $("#editStatus").val(self.editStaff.status);
                }

                // Define Controller Function
                self.getStaffs = function () {
                    console.log('Fetching all staffs');
                    self.staffs = staffService.query();
                }

                self.deleteStaff = function (staff) {
                    console.log('Deleting staff ' + staff.staffId);
                    var dialogId = "#deleteDialog";

                    staffService.DELETE_STAFF({staffId: staff.staffId})
                        .$promise.then(
                        function (response) {
                            console.log("Deleted Staff: " + staff.staffId);
                            console.log("response body: " + response);
                            var msg = "Staff [" + staff.name + "] deleted success.";

                            // Refresh Staff table listing
                            self.getStaffs();

                            $(dialogId).modal('hide');

                            self.showAlert(staff, msg, null);
                        },
                        function (error) {
                            console.log("Error Delete Staff. " + error.status);
                            var msg = "Error in deleting Staff [" + staff.name + "].";
                            $(dialogId).modal('hide');
                            self.showAlert(staff, msg, dialogId);
                        }
                    );
                }

                self.updateStaff = function (staff) {
                    console.log('Updating staff ' + staff.staffId);
                    var dialogId = "#editDialog";

                    staff.status = $("#newStatus")[0].value;

                    staffService.UPDATE_STAFF({staffId: staff.staffId}, staff)
                        .$promise.then(
                        function (response) {
                            console.log("Updated Staff: " + staff.staffId);
                            console.log("response body: " + response);
                            var msg = "Staff [" + staff.name + "] updated success.";

                            // Refresh Staff table listing
                            self.getStaffs();

                            $(dialogId).modal('hide');
                            self.showAlert(staff, msg, null);
                        },
                        function (error) {
                            console.log("Error Update Staff. " + error.status);
                            var msg = "Error in updating Staff [" + staff.name + "].";
                            $(dialogId).modal('hide');
                            self.showAlert(staff, msg, dialogId);
                        }
                    );
                }

                /*
                 StaffInsertDTO:
                 {"icNo":null,"staffCode":null,"name":null,"basicPay":null,"epfNo":null,"epfRate":null,"joinDate":null,"terminationDate":null,"workExp":null,"status":null}
                 */
                self.insertStaff = function () {
                    if ($('#createStaffForm').data('bootstrapValidator').isValid()) {
                        console.log('Inserting staff ' + self.newStaff.name);
                        var dialogId = "#createDialog";

                        // Map data
                        self.newStaff.oum = $("#newStatus")[0].value;

                        staffService.INSERT_STAFF(self.newStaff)
                            .$promise.then(
                            function (response) {
                                self.newStaff = response;
                                console.log("Inserted New Staff: " + self.newStaff.staffId);
                                var msg = "Staff [" + self.newStaff.name + "] created success.";

                                // Refresh Staff table listing
                                self.getStaffs();

                                $(dialogId).modal('hide');

                                self.showAlert(self.newStaff, msg, null);
                            },
                            function (error) {
                                console.log("Error Create Staff. " + error.status);
                                var msg = "Error in Creating New Staff [" + self.newStaff.name + "]. " + error.data.description;
                                self.showAlert(self.newStaff, msg, dialogId);
                            }
                        ).reject(new Error("foo"));
                    }
                }

                self.reset = function () {
                    console.log("reset");
                    self.newStaff = {};
                    $('#createStaffForm').data('bootstrapValidator').resetForm();
                };

                self.showAlert = function (staff, msg, dialogId) {
                    var parent = "staffMgmtDiv"
                    if (dialogId) {
                        parent = dialogId
                    }

                    $mdDialog.show(
                        $mdDialog.alert()
                            .parent(angular.element(document.querySelector(parent)))
                            .clickOutsideToClose(true)
                            .title("Notification (" + new Date().toUTCString() + ")")
                            .textContent(msg)
                            .ariaLabel("Alert Dialog")
                            .ok("OK")
                            .targetEvent(staff)
                    );
                };
            }
        ]
    )