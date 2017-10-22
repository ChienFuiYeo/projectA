/*
 'use strict';
 */

var payrollApp = angular.module('payrollApp');

payrollApp
    .controller('branchController',
        ['$scope', '$state', '$mdDialog', 'branchService',
            function ($scope, $state, $mdDialog, branchService) {



                // Ready function (BootstrapValidator)
                angular.element(document).ready(function () {
                    $('#createBranchForm').bootstrapValidator({
                        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        excluded: [':disabled'],
                        fields: {
                            branchCode: {
                                validators: {
                                    stringLength: {
                                        min: 5,
                                    },
                                    notEmpty: {
                                        message: 'Please enter branch code.'
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
                $scope.sortKey = 'branchId';
                $scope.reverse = false;
                $scope.sort = function (key) {
                    $scope.reverse = ($scope.sortKey == key) ? !$scope.reverse : $scope.reverse;
                    $scope.sortKey = key;
                }

                // Status
                $scope.branchData = {
                    availableStatus: [
                        {name: "Active", value: "Active"},
                        {name: "InActive", value: "InActive"}
                    ],
                    selectedStatus: {name: 'Active', value: "Active"} //This sets the default value of the select in the ui
                };

                // Define Controller variable
                var self = this;
                self.branches = [];
                self.deleteStatus = '';
                self.selectedBranch = null;
                self.editBranch = null;
                self.newBranch = {};
                $scope.dt = new Date();

                self.setSelectedBranch = function (selectedBranch) {
                    self.selectedBranch = selectedBranch;
                    self.editBranch = JSON.parse(JSON.stringify(selectedBranch));
                }

                // Define Controller Function
                self.getBranches = function () {
                    console.log('Fetching all branches');
                    self.branches = branchService.query();
                }

                self.deleteBranch = function (branch) {
                    console.log('Deleting branch ' + branch.branchId);
                    var dialogId = "#deleteDialog";

                    branchService.DELETE_BRANCH({branchId: branch.branchId})
                        .$promise.then(
                        function (response) {
                            console.log("Deleted Branch: " + branch.branchId);
                            console.log("response body: " + response);
                            var msg = "Branch [" + branch.name + "] deleted success.";

                            // Refresh Branch table listing
                            self.getBranches();

                            $(dialogId).modal('hide');

                            self.showAlert(branch, msg, null);
                        },
                        function (error) {
                            console.log("Error Delete Branch. " + error.status);
                            var msg = "Error in deleting Branch [" + branch.name + "].";
                            $(dialogId).modal('hide');
                            self.showAlert(branch, msg, dialogId);
                        }
                    );
                }

                self.updateBranch = function (branch) {
                    console.log('Updating branch ' + branch.branchId);
                    var dialogId = "#editDialog";

                    branchService.UPDATE_BRANCH({branchId: branch.branchId}, branch)
                        .$promise.then(
                        function (response) {
                            console.log("Updated Branch: " + branch.branchId);
                            console.log("response body: " + response);
                            var msg = "Branch [" + branch.name + "] updated success.";

                            // Refresh Branch table listing
                            self.getBranches();

                            $(dialogId).modal('hide');
                            self.showAlert(branch, msg, null);
                        },
                        function (error) {
                            console.log("Error Update Branch. " + error.status);
                            var msg = "Error in updating Branch [" + branch.name + "].";
                            $(dialogId).modal('hide');
                            self.showAlert(branch, msg, dialogId);
                        }
                    );
                }

                /*
                 BranchInsertDTO:
                 {"icNo":null,"branchCode":null,"name":null,"basicPay":null,"epfNo":null,"epfRate":null,"joinDate":null,"terminationDate":null,"workExp":null,"status":null}
                 */
                self.insertBranch = function () {
                    if ($('#createBranchForm').data('bootstrapValidator').isValid()) {
                        console.log('Inserting branch ' + self.newBranch.name);
                        var dialogId = "#createDialog";

                        branchService.INSERT_BRANCH(self.newBranch)
                            .$promise.then(
                            function (response) {
                                self.newBranch = response;
                                console.log("Inserted New Branch: " + self.newBranch.branchId);
                                var msg = "Branch [" + self.newBranch.name + "] created success.";

                                // Refresh Branch table listing
                                self.getBranches();

                                $(dialogId).modal('hide');

                                self.showAlert(self.newBranch, msg, null);
                            },
                            function (error) {
                                console.log("Error Create Branch. " + error.status);
                                var msg = "Error in Creating New Branch [" + self.newBranch.name + "]. " + error.data.description;
                                self.showAlert(self.newBranch, msg, dialogId);
                            }
                        ).reject(new Error("foo"));
                    }
                }

                self.reset = function () {
                    console.log("reset");
                    self.newBranch = {};
                    $('#createBranchForm').data('bootstrapValidator').resetForm();
                };

                self.showAlert = function (branch, msg, dialogId) {
                    var parent = "branchMgmtDiv"
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
                            .targetEvent(branch)
                    );
                };
            }
        ]
    )