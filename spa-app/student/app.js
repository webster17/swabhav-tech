
angular.module('studentApiController', [])
    .controller('viewStudentController', ['$scope', 'dataService', '$sce', function ($scope, dataService, $sce) {
        //$scope.studentDataLoadButtonElement = $sce.trustAsHtml('<i class="fa fa-spinner fa-spin"></i> Loading...');
        dataService.getAllStudents().then(function (response) {
            $scope.students = response.data;
            //$scope.studentDataLoadButtonElement = $sce.trustAsHtml('Loaded');
        }, function () {
            console.log(' Something went wrong!');
        }).then(function () {
            //$scope.studentDataLoadButtonElement = $sce.trustAsHtml('Load Student Data');
        });

    }])
    .controller('addStudentControler', ['$scope', '$log', '$sce', 'dataService', '$timeout', '$location', function ($scope, $log, $sce, dataService, $timeout, $location) {

        $scope.hideError = function () {
            $scope.rollNoInputClass = "";
            $scope.nameInputClass = "";
            $scope.dateInputClass = "";
            $scope.emailInputClass = "";
            $scope.genderInputClass = "";
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
            $scope.hideError();
        }

        $scope.isValidStudent = function (student) {
            var hasError = true;

            $scope.hideError();
            if (student.rollNo == "" || isNaN(student.rollNo) || student.rollNo < 1) {
                $scope.rollNoInputClass = 'is-invalid';
                hasError = false;
            }
            if (student.name == "" || !isNaN(student.name)) {
                $scope.nameInputClass = 'is-invalid';
                hasError = false;
            }
            if (student.email == "") {
                $scope.emailInputClass = 'is-invalid';
                hasError = false;
            }
            if (student.isMale == "") {
                $scope.genderInputClass = 'is-invalid';
                hasError = false;
            }
            if (!Date.parse(student.date)) {
                $scope.dateInputClass = 'is-invalid';
                hasError = false;
            }
            return hasError;
        }

        $scope.addNewStudent = function () {
            $scope.addStudentButtonElement = $sce.trustAsHtml('<i class="fa fa-spinner fa-spin"></i> Adding');
            if ($scope.isValidStudent($scope.student)) {
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
            } else {
                $scope.addStudentButtonElement = $sce.trustAsHtml('Retry Again');
            }
        }

        $scope.addStudentButtonElement = $sce.trustAsHtml('Add New Student');
        $scope.resetForm();
    }])
    .controller('updateStudentController', ['$scope', '$log', '$routeParams', 'dataService', '$sce', '$location', '$timeout', function ($scope, $log, $routeParams, dataService, $sce, $location, $timeout) {
        $scope.gender = [
            { value: "", label: "Select a Gender" },
            { value: "true", label: "Male" },
            { value: "false", label: "Female" }
        ];

        $scope.hideError = function () {
            $scope.rollNoInputClass = "";
            $scope.nameInputClass = "";
            $scope.dateInputClass = "";
            $scope.emailInputClass = "";
            $scope.genderInputClass = "";
        }

        $scope.isValidStudent = function (student) {
            var hasError = true;

            $scope.hideError();
            if (student.rollNo == "" || isNaN(student.rollNo) || student.rollNo < 1) {
                $scope.rollNoInputClass = 'is-invalid';
                hasError = false;
            }
            if (student.name == "" || !isNaN(student.name)) {
                $scope.nameInputClass = 'is-invalid';
                hasError = false;
            }
            if (student.email == "") {
                $scope.emailInputClass = 'is-invalid';
                hasError = false;
            }
            if (student.isMale == "") {
                $scope.genderInputClass = 'is-invalid';
                hasError = false;
            }
            if (!Date.parse(student.date)) {
                $scope.dateInputClass = 'is-invalid';
                hasError = false;
            }
            return hasError;
        }

        $scope.updateStudent = function () {
            $scope.updateButtonElement = $sce.trustAsHtml('<i class="fa fa-spinner fa-spin"></i> Updating...');
            if ($scope.isValidStudent($scope.student)) {
                $scope.updateDisabledButtonElement = true;
                var dob = new Date($scope.student.date);
                var currentDate = new Date();
                $scope.student.age = currentDate.getFullYear() - dob.getFullYear()

                dataService.updateStudent($scope.student).then(function () {
                    $scope.updateButtonElement = $sce.trustAsHtml('Updated');
                    $timeout($location.path('/'), 800);
                }, function () {
                    $scope.updateButtonElement = $sce.trustAsHtml('Retry Again');
                }).then(function () {
                    $scope.updateDisabledButtonElement = false;
                });
            } else {
                $scope.updateButtonElement = $sce.trustAsHtml('Retry Again');
            }
        }

        dataService.getStudent($routeParams.Id).then(function (response) {
            $scope.hideError();
            $scope.student = response.data;
            $scope.student.date = new Date($scope.student.date);
            $scope.student.isMale = ($scope.student.isMale) ? $scope.gender[1].value : $scope.gender[2].value;
            $scope.updateButtonElement = $sce.trustAsHtml('Update Student');
        }, function (response) {
            console.log('Something went wrong!');
        });
    }])
    .controller('deleteStudentController', ['$scope', '$log', '$routeParams', '$sce', '$window', '$location', 'dataService', function ($scope, $log, $routeParams, $sce, $window, $location, dataService) {
        console.log($routeParams.Id);
        if ($window.confirm('are you sure to delete '+$routeParams.Id+'?')) {
            $scope.deleteDisabledButtonElement = true
            dataService.deleteStudent($routeParams.Id).then(function (response) {
                $location.path('/');     
            }, function () {
                console.log(' Something went wrong!');
            }).then(function () {
                $scope.deleteDisabledButtonElement = false;           
            });
        }else{
            $location.path('/');
        }
    }]);


angular.module('student-spa-app', ['ngRoute', 'studentApiController'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when(
            '/', {
                templateUrl: 'template/view.html',
                controller: 'viewStudentController'
            }).when(
                '/add', {
                    templateUrl: 'template/add.html',
                    controller: 'addStudentControler'
                }).when(
                    '/update/:Id', {
                        templateUrl: 'template/update.html',
                        controller: 'updateStudentController'
                    }).when(
                        '/view', {
                            templateUrl: 'template/view.html',
                            controller: 'viewStudentController'
                        }).when('/delete/:Id', {
                            template: "",
                            controller: 'deleteStudentController'
                        }).otherwise({
                            template: '<h3>Not found!</h3>'
                        });
    }]);

angular.module('student-spa-app').factory('dataService', function ($http) {
    var obj = {};
    var _url = 'http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students/';
    obj.getAllStudents = function () {
        return $http({ method: 'GET', url: _url });
    };
    obj.getStudent = function (rollNo) {
        return $http({ method: 'GET', url: _url + rollNo })
    }
    obj.deleteStudent = function (rollNo) {
        return $http({ method: 'DELETE', url: _url + rollNo });
    }
    obj.addNewStudent = function (student) {
        return $http({ method: 'POST', data: student, url: _url });
    }
    obj.updateStudent = function (student) {
        return $http({ method: 'PUT', data: student, url: _url + student.rollNo });
    }
    return obj;
});