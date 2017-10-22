/*
 'use strict';
 */

var payrollApp = angular.module('payrollApp');

payrollApp
    .controller('deductionController',
        ['$scope', '$state', '$mdDialog', 'deductionService',
            function ($scope, $state, $mdDialog, deductionService) {



                // Ready function (BootstrapValidator)
                angular.element(document).ready(function () {
                    $('#createDeductionForm').bootstrapValidator({
                        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        excluded: [':disabled'],
                        fields: {
                            deductionCode: {
                                validators: {
                                    stringLength: {
                                        min: 5,
                                    },
                                    notEmpty: {
                                        message: 'Please enter deduction code.'
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
                $scope.sortKey = 'deductionId';
                $scope.reverse = false;
                $scope.sort = function (key) {
                    $scope.reverse = ($scope.sortKey == key) ? !$scope.reverse : $scope.reverse;
                    $scope.sortKey = key;
                }

                // Define Controller variable
                var self = this;
                self.deductions = [];
                self.selectedDeduction = null;
                self.editDeduction = null;
                self.newDeduction = {};
                $scope.dt = new Date();

                self.setSelectedDeduction = function (selectedDeduction) {
                    self.selectedDeduction = selectedDeduction;
                    self.editDeduction = JSON.parse(JSON.stringify(selectedDeduction));
                }

                // Define Controller Function
                self.getDeductions = function () {
                    console.log('Fetching all deductions');
                    self.deductions = deductionService.query();
                }

                self.deleteDeduction = function (deduction) {
                    console.log('Deleting deduction ' + deduction.deductionId);
                    var dialogId = "#deleteDialog";

                    deductionService.DELETE_DEDUCTION({deductionId: deduction.deductionId})
                        .$promise.then(
                        function (response) {
                            console.log("Deleted Deduction: " + deduction.deductionId);
                            console.log("response body: " + response);
                            var msg = "Deduction [" + deduction.name + "] deleted success.";

                            // Refresh Deduction table listing
                            self.getDeductions();

                            $(dialogId).modal('hide');

                            self.showAlert(deduction, msg, null);
                        },
                        function (error) {
                            console.log("Error Delete Deduction. " + error.status);
                            var msg = "Error in deleting Deduction [" + deduction.name + "].";
                            $(dialogId).modal('hide');
                            self.showAlert(deduction, msg, dialogId);
                        }
                    );
                }

                self.updateDeduction = function (deduction) {
                    console.log('Updating deduction ' + deduction.deductionId);
                    var dialogId = "#editDialog";

                    deductionService.UPDATE_DEDUCTION({deductionId: deduction.deductionId}, deduction)
                        .$promise.then(
                        function (response) {
                            console.log("Updated Deduction: " + deduction.deductionId);
                            console.log("response body: " + response);
                            var msg = "Deduction [" + deduction.name + "] updated success.";

                            // Refresh Deduction table listing
                            self.getDeductions();

                            $(dialogId).modal('hide');
                            self.showAlert(deduction, msg, null);
                        },
                        function (error) {
                            console.log("Error Update Deduction. " + error.status);
                            var msg = "Error in updating Deduction [" + deduction.name + "].";
                            $(dialogId).modal('hide');
                            self.showAlert(deduction, msg, dialogId);
                        }
                    );
                }

                /*
                 DeductionInsertDTO:
                 {"icNo":null,"deductionCode":null,"name":null,"basicPay":null,"epfNo":null,"epfRate":null,"joinDate":null,"terminationDate":null,"workExp":null,"status":null}
                 */
                self.insertDeduction = function () {
                    if ($('#createDeductionForm').data('bootstrapValidator').isValid()) {
                        console.log('Inserting deduction ' + self.newDeduction.name);
                        var dialogId = "#createDialog";

                        deductionService.INSERT_DEDUCTION(self.newDeduction)
                            .$promise.then(
                            function (response) {
                                self.newDeduction = response;
                                console.log("Inserted New Deduction: " + self.newDeduction.deductionId);
                                var msg = "Deduction [" + self.newDeduction.name + "] created success.";

                                // Refresh Deduction table listing
                                self.getDeductions();

                                $(dialogId).modal('hide');

                                self.showAlert(self.newDeduction, msg, null);
                            },
                            function (error) {
                                console.log("Error Create Deduction. " + error.status);
                                var msg = "Error in Creating New Deduction [" + self.newDeduction.name + "]. " + error.data.description;
                                self.showAlert(self.newDeduction, msg, dialogId);
                            }
                        ).reject(new Error("foo"));
                    }
                }

                self.reset = function () {
                    console.log("reset");
                    self.newDeduction = {};
                    self.newDeduction.invoiceDate =  moment(new Date()).format('YYYY/MM/DD');
                    $('#createDeductionForm').data('bootstrapValidator').resetForm();
                };

                self.showAlert = function (deduction, msg, dialogId) {
                    var parent = "deductionMgmtDiv"
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
                            .targetEvent(deduction)
                    );
                };
            }
        ]
    )