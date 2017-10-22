/*
 'use strict';
 */

var payrollApp = angular.module('payrollApp');

payrollApp
    .controller('jobController',
        ['$scope', '$state', '$mdDialog', 'jobService',
            function ($scope, $state, $mdDialog, jobService) {



                // Ready function (BootstrapValidator)
                angular.element(document).ready(function () {
                    $('#createJobForm').bootstrapValidator({
                        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        excluded: [':disabled'],
                        fields: {
                            jobCode: {
                                validators: {
                                    stringLength: {
                                        min: 5,
                                    },
                                    notEmpty: {
                                        message: 'Please enter job code.'
                                    }
                                }
                            }
                        },
                        onSuccess: function (e, data) {
                            console.log("onsuccess prevent default submission")

                            // Prevent form submission
                            e.preventDefault();
                        }
                    })
                });

                // Sorting table column
                $scope.sortKey = 'jobId';
                $scope.reverse = false;
                $scope.sort = function (key) {
                    $scope.reverse = ($scope.sortKey == key) ? !$scope.reverse : $scope.reverse;
                    $scope.sortKey = key;
                }

                // Status
                $scope.jobOumData = {
                    availableOum: [
                        {name: "Arce", value: "Arce"},
                        {name: "Bag", value: "Bag"},
                        {name: "BTG", value: "BTG"},
                        {name: "Biji", value: "Biji"},
                        {name: "Buah", value: "Buah"},
                        {name: "Buat", value: "Buat"},
                        {name: "Chain", value: "Chain"},
                        {name: "Day", value: "Day"},
                        {name: "Hour", value: "Hour"},
                        {name: "Kaki", value: "Kaki"},
                        {name: "MT", value: "MT"},
                        {name: "Month", value: "Month"},
                        {name: "PC", value: "PC"},
                        {name: "PK", value: "PK"},
                        {name: "Trip", value: "Trip"}
                    ],
                    //selectedOum: {name: "Arce", value: "Arce"} //This sets the default value of the select in the ui
                };

                // Define Controller variable
                var self = this;
                self.jobs = [];
                self.deleteStatus = '';
                self.selectedJob = null;
                self.editJob = null;
                self.newJob = {};
                $scope.dt = new Date();

                self.setSelectedJob = function (selectedJob) {
                    self.selectedJob = selectedJob;
                    self.editJob = JSON.parse(JSON.stringify(selectedJob));
                    $("#editOum").val(self.editJob.oum);
                }

                // Define Controller Function
                self.getJobs = function () {
                    console.log('Fetching all jobs');
                    self.jobs = jobService.query();
                }

                self.deleteJob = function (job) {
                    console.log('Deleting job ' + job.jobId);
                    var dialogId = "#deleteDialog";

                    jobService.DELETE_JOB({jobId: job.jobId})
                        .$promise.then(
                        function (response) {
                            console.log("Deleted Job: " + job.jobId);
                            console.log("response body: " + response);
                            var msg = "Job [" + job.name + "] deleted success.";

                            // Refresh Job table listing
                            self.getJobs();

                            $(dialogId).modal('hide');

                            self.showAlert(job, msg, null);
                        },
                        function (error) {
                            console.log("Error Delete Job. " + error.status);
                            var msg = "Error in deleting Job [" + job.name + "].";
                            $(dialogId).modal('hide');
                            self.showAlert(job, msg, dialogId);
                        }
                    );
                }

                self.updateJob = function (job) {
                    console.log('Updating job ' + job.jobId);
                    var dialogId = "#editDialog";

                    // Map data
                    job.oum = $("#editOum")[0].value;

                    jobService.UPDATE_JOB({jobId: job.jobId}, job)
                        .$promise.then(
                        function (response) {
                            console.log("Updated Job: " + job.jobId);
                            console.log("response body: " + response);
                            var msg = "Job [" + job.name + "] updated success.";

                            // Refresh Job table listing
                            self.getJobs();

                            $(dialogId).modal('hide');
                            self.showAlert(job, msg, null);
                        },
                        function (error) {
                            console.log("Error Update Job. " + error.status);
                            var msg = "Error in updating Job [" + job.name + "].";
                            $(dialogId).modal('hide');
                            self.showAlert(job, msg, dialogId);
                        }
                    );
                }

                /*
                 JobInsertDTO:
                 {"icNo":null,"jobCode":null,"name":null,"basicPay":null,"epfNo":null,"epfRate":null,"joinDate":null,"terminationDate":null,"workExp":null,"status":null}
                 */
                self.insertJob = function () {
                    if ($('#createJobForm').data('bootstrapValidator').isValid()) {
                        console.log('Inserting job ' + self.newJob.name);
                        var dialogId = "#createDialog";

                        // Map data
                        self.newJob.oum = $("#newOum")[0].value;

                        jobService.INSERT_JOB(self.newJob)
                            .$promise.then(
                            function (response) {
                                self.newJob = response;
                                console.log("Inserted New Job: " + self.newJob.jobId);
                                var msg = "Job [" + self.newJob.name + "] created success.";

                                // Refresh Job table listing
                                self.getJobs();

                                $(dialogId).modal('hide');

                                self.showAlert(self.newJob, msg, null);
                            },
                            function (error) {
                                console.log("Error Create Job. " + error.status);
                                var msg = "Error in Creating New Job [" + self.newJob.name + "]. " + error.data.description;
                                self.showAlert(self.newJob, msg, dialogId);
                            }
                        ).reject(new Error("foo"));
                    }
                }

                self.reset = function () {
                    console.log("reset");
                    self.newJob = {};
                    $('#createJobForm').data('bootstrapValidator').resetForm();
                };

                self.showAlert = function (job, msg, dialogId) {
                    var parent = "jobMgmtDiv"
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
                            .targetEvent(job)
                    );
                };
            }
        ]
    )