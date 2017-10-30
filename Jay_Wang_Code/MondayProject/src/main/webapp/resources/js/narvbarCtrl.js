/**
 * 
 */

angular.module('HomeApp')
	.directive('Navbar', function() {
		return {
			templateUrl: "resources/fragment/navbar.html"
		};
	}).controller('navbarCtrl', function($scope) {
		$scope.isUserValid = false;
})