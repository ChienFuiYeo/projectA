var payrollApp = angular.module('payrollApp');

payrollApp

    .directive('toogleClose', function () {
        return {
            restrict: 'AC',
            link: function ($scope, $element) {
                $element.bind('click', function () {
                    var d = document.querySelector('.mdl-layout');
                    d.MaterialLayout.toggleDrawer();
                });
            }
        };
    })

    .directive('mdDatepicker', function () {
        function link(scope, element, attrs, ngModel) {
            var parser = function (val) {
                val = moment(val).format('YYYY/MM/DD');
                return val;
            };
            var formatter = function (val) {
                if (!val) return val;
                val = moment(val).toDate();
                return val;
            };
            ngModel.$parsers.push(parser);
            ngModel.$formatters.push(formatter);
        }

        return {
            require: 'ngModel',
            link: link,
            restrict: 'EA',
            priority: 1
        }
    });