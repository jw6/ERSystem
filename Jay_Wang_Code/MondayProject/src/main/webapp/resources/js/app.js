angular.module('HomeApp', [])

.controller('mainCtrl', function($scope, dataService) {
	$scope.helloworld = function() {
		console.log("Hello from our mainctrl")
	}

	$scope.myVar = 123123;

	$scope.helloConsole = dataService.helloConsole;

	$scope.getHomes = dataService.getHomes(
	// Passed in the Callback Function
	function(response) {
		console.log(response.data)
		$scope.todos = response.data;
	})

	$scope.saveTodo = function(todo) {
		console.log('About to save ' + todo.name)

		$scope.updateTask = dataService.saveTodo(todo);
	}
})

.service('dataService', function($http, $q) {
	this.helloConsole = function() {
		console.log('this is the service function');
	}
	this.getHomes = function(callback) {
		$http.get('resources/js/note.json').then(callback)
	}

	this.saveTodo = function(todo) {
		var promise = $http.post('rest/save', todo).then(function(response) {
			console.log(response + ' its working');
		}, function(error) {
			console.log($q.reject(error));
		})
	}

})