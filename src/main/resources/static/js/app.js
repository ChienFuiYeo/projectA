var app = angular.module('payrollApp', ['ui.router', 'ngResource', 'ngMaterial']);

app.config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
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
                        templateUrl: 'views/staff.html',
                        controller: 'staffController',
                        controllerAs: 'staffCtrl'
                    },
                    /*'staffSearch@staffMgmt': {
                     templateUrl: 'views/staffSearch.html'
                     },
                     'staffCreateNew@staffMgmt': {
                     templateUrl: 'views/staffCreateNew.html'
                     }*/
                }
            })
            .state('staffMgmt.staffSearch', {
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
            })
            .state('error', {
                url: '/error',
                templateUrl: 'views/error.html'
            });
    }
]);
