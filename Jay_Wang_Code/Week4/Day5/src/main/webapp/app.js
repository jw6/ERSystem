/**
 * angularjs main module
 */

var app = angular.module('revApp', []) //empty [] tells angular to create a module
								//no [] says one already exists
								//Build a customr directive (html element or attribute

app.directive('helloWorld',
		function() {
	//helloWorld is the html element or attribute of hello-world on AngularApp
	//helloWorld needs to be camel case to match the hello-world
			console.log('hello world from the hello-world directive');
			return {
				template: '<h1> hello world guy</h1>',
				restrict: 'A'
					//restrict to attribute only
			}
	}
);

app.controller('aboutMe', function($scope) {
	console.log('About me controller');
	$scope.myVar = "lol";
});
