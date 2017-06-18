var app = angular.module('payrollApp', ['ui.router', 'ngResource', 'ngMaterial']);

app.config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('staffMgmt', {
                url: '/staffMgmt',
                views: {
                    '': {
                        templateUrl: 'views/staff.html',
                        controller: 'staffController',
                        controllerAs: 'staffCtrl'
                    },
                    'staffSearch@staffMgmt': {templateUrl: 'views/staffSearch.html'}
                }
            })
            .state('error', {
                url: '/error',
                templateUrl: 'views/error.html'
            });
    }
]);
