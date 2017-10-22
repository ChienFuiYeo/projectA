var app = angular.module('payrollApp', ['ui.router', 'ngResource', 'ngMaterial', 'ngMessages', 'angularUtils.directives.dirPagination']);

app.config(['$stateProvider', '$urlRouterProvider', '$mdDateLocaleProvider',
    function ($stateProvider, $urlRouterProvider, $mdDateLocaleProvider) {

        // DatePicker setup
        $mdDateLocaleProvider.formatDate = function(date) {
            return moment(date).format('YYYY/MM/DD');
        };
        $mdDateLocaleProvider.parseDate = function(dateString) {
            var m = moment(dateString, 'YYYY/MM/DD', true);
            return m.isValid() ? m.toDate() : new Date(NaN);
        };

        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('/', {
                url: '/',
                views: {
                    '': { templateUrl: 'index.html' }
                }
            })
            .state('staffMgmt', {
                url: '/staffMgmt',
                views: {
                    '': {
                        templateUrl: 'views/staff/staffSearch.html',
                        controller: 'staffController',
                        controllerAs: 'staffCtrl'

                        //templateUrl: 'views/staff.html',
                        //controller: 'staffController',
                        //controllerAs: 'staffCtrl'
                    }
                }
            })
            .state('branchMgmt', {
                url: '/branchMgmt',
                views: {
                    '': {
                        templateUrl: 'views/branch/branchSearch.html',
                        controller: 'branchController',
                        controllerAs: 'branchCtrl'
                    }
                }
            })
            .state('jobMgmt', {
                url: '/jobMgmt',
                views: {
                    '': {
                        templateUrl: 'views/job/jobSearch.html',
                        controller: 'jobController',
                        controllerAs: 'jobCtrl'
                    }
                }
            })
            .state('deductionMgmt', {
                url: '/deductionMgmt',
                views: {
                    '': {
                        templateUrl: 'views/deduction/deductionSearch.html',
                        controller: 'deductionController',
                        controllerAs: 'deductionCtrl'
                    }
                }
            })
            /*.state('staffMgmt.staffSearch', {
                url: '/staffSearch',
                views: {
                    '': {
                        templateUrl: 'views/staffSearch.html',
                        controller: 'staffController',
                        controllerAs: 'staffCtrl'
                    }
                }
            })
            .state('staffMgmt.staffCreateNew', {
                url: '/staffCreateNew',
                views: {
                    '': {
                        templateUrl: 'views/staffCreateNew.html',
                        controller: 'staffController',
                        controllerAs: 'staffCtrl'
                    }
                }
            })*/
            .state('error', {
                url: '/error',
                templateUrl: 'views/error.html'
            });
    }
]);
