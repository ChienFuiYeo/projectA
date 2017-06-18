/*
 'use strict';
 */

angular
    .module('payrollApp')
    .controller('jobController',
        ['$scope', 'jobService',
            function ($scope, jobService) {

                // Define Controller variable
                var self = this;
                self.jobs = [];
                self.deleteStatus = '';

                // Define Controller Function
                self.getjobs = function () {
                    console.log('Fetching all jobs');
                    self.jobs = jobService.query();
                }

                self.deletejob = function (job) {
                    console.log('Deleting job ' + job.jobId);
                    jobService.DELETE_JOB({jobId: job.jobId});
                }

                self.updatejob = function (job) {
                    console.log('Updating job ' + job.jobId);
                    job.jobDescription = 'updated sample job description';
                    jobService.UPDATE_JOB({jobId: job.jobId}, job);
                }

                /*
                 JobInsertDTO:
                 {"jobCode":null,"jobDescription":null,"rate":null,"oum":null,"remarks":null}
                 */
                self.insertStaff = function (staff) {
                    console.log('Inserting staff ' + staff);
                    var staffInsertDTO = null;

                    if (null != staff) {
                        staffInsertDTO = staff;
                    }

                    var staffInsertDTO = {
                        jobCode: "JobCode01",
                        jobDescription: "Lorry",
                        oum: "",
                        remarks: "job remakrs"
                    };

                    staffService.INSERT_STAFF(staffInsertDTO);
                }
            }
        ]
    )