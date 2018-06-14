/// <reference path="../resources/angular/angular.js" />

angular.module('moduleA', ['moduleB', 'moduleC']);

angular.module('moduleA').controller('InvoiceController', function($rootScope, $scope){
    console.log('Invoice Controller Initiated');
    $rootScope.developer = 'Santosh Rajpoot';
    console.log($rootScope.developer);
    $scope.invoice = {
        date: '10-4-2018',
        cost: 2000
    }
});

angular.module('moduleB', []);
angular.module('moduleB').controller('AddressController', function($rootScope, $scope){
    console.log('Address Controller Initiated');
    console.log($rootScope.developer);
    $scope.address = {
        city: 'Mumbai',
        state: 'Maharashtra',
        pincode: 400068
    }
});

angular.module('moduleC', []);
angular.module('moduleC').controller('OrderController', function($scope){
    console.log('Order Controller Initiated');
    $scope.order = {
        date: '10-4-2018',
        quantity: 2,
        shippingCost: 50
    }
});