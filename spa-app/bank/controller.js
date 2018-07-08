angular.module('bankApiController', [])
    .controller('loginController', ['$rootScope', '$scope', '$sce', 'auth', '$location', '$window', function ($rootScope, $scope, $sce, auth, $location, $window) {
        $rootScope.logedInUser = auth.check();
        if (auth.check().authenticated)
            $location.path('/');

        $scope.credential = {
            userName : '',
            password : ''
        };

        $rootScope.logedInUser.authenticated = 2;
        $scope.loginButtonElement = $sce.trustAsHtml('Login');

        $scope.login = function () {
            $scope.loginButtonElement = $sce.trustAsHtml('<i class="fa fa-spinner fa-spin"></i> Logging in...');
            $scope.disabledLoginButtonElement = true;

            if (auth.attempt($scope.credential)) {
                $window.localStorage['logedInUser'] = JSON.stringify($scope.credential);
                if ($window.localStorage['intendedUrl'] != undefined) {
                    var intendedUrl = $window.localStorage['intendedUrl'];
                    $window.localStorage.removeItem('intendedUrl');
                    $location.path(intendedUrl);
                }
                $location.path('/');
            } else {
                $scope.credential.password = '';
                $scope.loginButtonElement = $sce.trustAsHtml('Login failed');
                $window.localStorage.removeItem('logedInUser');
                $scope.disabledLoginButtonElement = false;
            }
        }
    }])
    .controller('signUpController', ['$rootScope', '$scope', '$sce', 'auth', '$location', '$window', function ($rootScope, $scope, $sce, auth, $location, $window) {
        $rootScope.logedInUser = auth.check();
        if (auth.check().authenticated)
            $location.path('/');

        $scope.credential = {
            userName : '',
            password : '',
            retypePassword : '',
            initialAmount : '' 
        };

        $rootScope.logedInUser.authenticated = 3;
        $scope.loginButtonElement = $sce.trustAsHtml('Sign Up');

    }])
    .controller('statementController', ['$rootScope', '$scope', 'dataService', '$window', '$location', '$sce', 'auth', function ($rootScope, $scope, dataService, $window, $location, $sce, auth) {
        $rootScope.logedInUser = auth.check();

        $scope.loadButtonElement = $sce.trustAsHtml('Load All Student List');
        $scope.loadDisabledButtonElement = false;
        $scope.viewAllStudent = function () {
            $scope.loadButtonElement = $sce.trustAsHtml('<i class="fa fa-spinner fa-spin"></i> Fetching Student List...');
            $scope.loadDisabledButtonElement = true;
            dataService.getAllStudents().then(function (response) {
                $scope.students = response.data;
                $scope.loadButtonElement = $sce.trustAsHtml('Loaded Student List');
            }, function () {
                console.log(' Something went wrong!');
            }).then(function () {
                $scope.loadButtonElement = $sce.trustAsHtml('Load All Student List');
                $scope.loadDisabledButtonElement = false;
            });
        }

        $scope.deleteStudent = function (rollNo) {
            if ($rootScope.logedInUser.authenticated) {
                if ($window.confirm('are you sure to delete ' + rollNo + '?'))
                    $location.path('/delete/' + rollNo);
            }
            else {
                $location.path('/login');
            }
        }
        $scope.viewAllStudent();
    }])
    .controller('addStudentControler', ['$rootScope', '$scope', 'auth', '$window', '$sce', 'dataService', '$timeout', '$location', function ($rootScope, $scope, auth, $window, $sce, dataService, $timeout, $location) {
        $rootScope.logedInUser = auth.check();
        if (!$rootScope.logedInUser.authenticated) {
            $window.localStorage['intendedUrl'] = $location.url();
            $location.path('/login');
        }

        $scope.resetForm = function () {
            $scope.student = {
                rollNo: '',
                name: '',
                email: '',
                isMale: '',
                date: '',
                age: ''
            }
        }

        $scope.addNewStudent = function () {
            $scope.addStudentButtonElement = $sce.trustAsHtml('<i class="fa fa-spinner fa-spin"></i> Adding');
            $scope.addDisabledStudentButtonElement = true;
            var dob = new Date($scope.student.date);
            var currentDate = new Date();
            $scope.student.age = currentDate.getFullYear() - dob.getFullYear()

            dataService.addNewStudent($scope.student).then(function () {
                $scope.addStudentButtonElement = $sce.trustAsHtml('Added');
                $timeout($location.path('/'), 800);
            }, function () {
                $scope.addStudentButtonElement = $sce.trustAsHtml('Retry Again');
            }).then(function () {
                $scope.addDisabledStudentButtonElement = false;
            });
        }

        $scope.addStudentButtonElement = $sce.trustAsHtml('Add New Student');
        $scope.resetForm();
    }])
    .controller('transactionController', ['$rootScope', '$scope', '$window', '$routeParams', 'dataService', '$sce', '$location', '$timeout', 'auth', function ($rootScope, $scope, $window, $routeParams, dataService, $sce, $location, $timeout, auth) {
        $rootScope.logedInUser = auth.check();
        if (!$rootScope.logedInUser.authenticated) {
            $window.localStorage['intendedUrl'] = $location.url();
            $location.path('/login');
        }

        $scope.gender = [
            { value: "", label: "Select a Gender" },
            { value: "true", label: "Male" },
            { value: "false", label: "Female" }
        ];

        $scope.updateStudent = function () {
            $scope.updateButtonElement = $sce.trustAsHtml('<i class="fa fa-spinner fa-spin"></i> Updating...');
            $scope.updateDisabledButtonElement = true;
            var dob = new Date($scope.student.date);
            var currentDate = new Date();
            $scope.student.age = currentDate.getFullYear() - dob.getFullYear()

            dataService.updateStudent($routeParams.Id, $scope.student).then(function () {
                $scope.updateButtonElement = $sce.trustAsHtml('Updated');
                $timeout($location.path('/'), 800);
            }, function () {
                $scope.updateButtonElement = $sce.trustAsHtml('Retry Again');
            }).then(function () {
                $scope.updateDisabledButtonElement = false;
            });
        }

        dataService.getStudent($routeParams.Id).then(function (response) {
            $scope.student = response.data;
            $scope.student.date = new Date($scope.student.date);
            $scope.student.isMale = ($scope.student.isMale) ? $scope.gender[1].value : $scope.gender[2].value;
            $scope.updateButtonElement = $sce.trustAsHtml('Update Student');
        }, function (response) {
            console.log('Something went wrong!');
        });
    }])
    .controller('deleteStudentController', ['$scope', '$window', '$routeParams', '$sce', '$location', 'dataService', 'auth', function ($scope, $window, $routeParams, $sce, $location, dataService, auth) {
        $rootScope.logedInUser = auth.check();

        if (!$rootScope.logedInUser.authenticated) {
            $window.localStorage['intendedUrl'] = $location.url();
            $location.path('/login');
        }

        $scope.deleteDisabledButtonElement = true
        dataService.deleteStudent($routeParams.Id).then(function (response) {
            $location.path('/');
        }, function () {
            console.log(' Something went wrong!');
        }).then(function () {
            $scope.deleteDisabledButtonElement = false;
        });
    }])
    .controller('logoutController', ['$rootScope', 'auth', '$location', function ($rootScope, auth, $location) {
        $rootScope.logedInUser = auth.check();
        if ($rootScope.logedInUser.authenticated)
            auth.release();
        $location.path('/');
    }]);
