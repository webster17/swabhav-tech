angular.module('bank-app', ['ngRoute', 'bankApiController'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {
            templateUrl: 'template/login.html',
            controller: 'loginController'
        }).when('/login', {
            templateUrl: 'template/login.html',
            controller: 'loginController'
        }).when('/sign-up', {
            templateUrl: 'template/register.html',
            controller: 'signUpController'
        }).when('/statement/:Id', {
            templateUrl: 'template/statement.html',
            controller: 'statementController'
        }).when('/transaction/:Id', {
            templateUrl: 'template/transaction.html',
            controller: 'transactionControler'
        }).when('/logout', {
            template: '',
            controller: 'logoutController'
        }).otherwise({
            redirectTo: '/login'
        });
    }]);

angular.module('bank-app')
    .service('dataService', ['$http', function ($http) {
        var _url = 'http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/';
        this.getAllStudents = function () {
            return $http({ method: 'GET', url: _url });
        };
        this.getStudent = function (rollNo) {
            return $http({ method: 'GET', url: _url + rollNo })
        }
        this.deleteStudent = function (rollNo) {
            return $http({ method: 'DELETE', url: _url + rollNo });
        }
        this.addNewStudent = function (student) {
            return $http({ method: 'POST', data: student, url: _url });
        }
        this.updateStudent = function (rollNo, student) {
            return $http({ method: 'PUT', data: student, url: _url + rollNo });
        }
        return this;
    }])
    .service('auth', ['$window', function ($window) {
        var registeredUser = {
            'santosh': 'pass@123',
            'sarvesh': 'pass@123'
        }
        this.check = function (userName) {
            var response = {
                userName: 'Guest',
                authenticated: false
            }
            if ($window.localStorage['logedInUser'] != undefined) {
                var loginCredential = JSON.parse($window.localStorage['logedInUser']);
                if (loginCredential.password === registeredUser[loginCredential.userName]) {
                    response.authenticated = true;
                    response.userName= loginCredential.userName;
                }
            }
            return response;
        }
        this.attempt = function (loginCredential) {
            if (loginCredential.password === registeredUser[loginCredential.userName]) {
                $window.localStorage['logedInUser'] = JSON.stringify(loginCredential);
                if(loginCredential.rememberMe)
                    $window.localStorage['rememberUserName'] = loginCredential.userName;
                return true;
            }
            $window.localStorage.removeItem('logedInUser');
            return false;
        }
        this.release = function () {
            $window.localStorage.removeItem('logedInUser');
        }
        return this;
    }])
    .filter('gender', function () {
        return function (isMale) {
            var gender = 'Female';
            if (isMale)
                gender = 'Male';
            return gender;
        }
    })
    .filter('class', function () {
        return function (isValid) {
            var className = 'is-valid';
            if (isValid == 0)
                className = '';
            else if (isValid == 1)
                className = 'is-invalid';
            return className;
        }
    });