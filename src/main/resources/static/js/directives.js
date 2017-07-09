angular.module('payrollApp')
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
        }
    );