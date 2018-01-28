var pageBaseApp = angular.module('pageBaseApp', ['ui.router']);
pageBaseApp.config(function ($stateProvider, $urlRouterProvider) {
    var contextPath = angular.element("#contextPath").text();
    var pageName = angular.element("#pageName").text();
    $urlRouterProvider.otherwise('/' + pageName);
    $stateProvider
        .state('setting', {
            url: '/setting',
            templateUrl: contextPath + '/doctor/page/setting'
        })
        .state('modifyPassword', {
            url: '/modifyPassword',
            templateUrl: contextPath + '/doctor/page/modifyPassword'
        });
});

pageBaseApp.controller('pageBaseCtrl', function ($scope) {
    $scope.showErrorCss = function (errorName) {
        return {
            error: errorName.$invalid && errorName.$touched,
            success: errorName.$valid && errorName.$touched
        }
    };
    $scope.showErrorMessage = function (errorName, error) {
        return errorName.$error[error] && errorName.$touched;
    };
    $scope.showSuccessIcon = function (successName) {
        return successName.$valid && successName.$touched
    };
});