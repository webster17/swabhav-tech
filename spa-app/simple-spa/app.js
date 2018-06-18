
angular.module('swabhavControllers', [])
.controller('homeController', ['$scope', '$log', '$sce', function($scope, $log, $sce){
    $log.info("Home controller initiated!");
    $scope.homeData = $sce.trustAsHtml('You are now on the <kbd>HOME</kbd> page');
}])
.controller('aboutController', ['$scope', '$log', '$sce', function($scope, $log, $sce){
    $log.info("About controller initiated!");
    $scope.aboutData = $sce.trustAsHtml('We are here to provide you details <kbd>ABOUT US</kbd>');
}])
.controller('careerController', ['$scope', '$log', '$sce', function($scope, $log, $sce){
    $log.info("Career controller initiated!");
    $scope.careerData = $sce.trustAsHtml('Here, you gonna find the <kbd>CAREER</kbd> related stuff');
}]);


angular.module('spa-app', ['ngRoute', 'swabhavControllers'])
.config(['$routeProvider', function($routeProvider){
    $routeProvider.when(
        '/',{
        templateUrl: 'partial/home.html',
        controller: 'homeController'
    }).when(
        '/about', {
        templateUrl: 'partial/about.html',
        controller: 'aboutController'
    }).when(
        '/career', {
        templateUrl: 'partial/career.html',
        controller: 'careerController'
    }).when(
        '/home', {
        templateUrl: 'partial/home.html',
        controller: 'homeController'
    }).otherwise({
        template: '<h3>Not found!</h3>'
    });
}]);