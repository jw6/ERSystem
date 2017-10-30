/**
 * 
 */
angular.module('HomeApp')
	.directive('helloWorld', function(){
		return {
			template: "display message",
			restrict: "A"	
		};
	})	