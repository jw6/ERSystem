/**
 *	Introduction to JavaScript 
 *	JS:
 *
 *	Is interpreted vs compiled
 *
 *	Loosely Type vs Strictly/Strongly 
 *		variables can be reassign to different datatypes
 *
 *	Variables can be functions
 *		&
 *	Functions can take another function as an argument
 *	
 *	To invoke a function use () 
 *
 *	No Method/Function Overloading: last defined is replacing previous declarations
 *		Methods - belong to objects
 *		Functions - do not belong to objects
 *	
 *	2 Scopes in JS:
 *		-Global
 *		-Function
 *
 *	Truthy/Falsy
 *	
 *	Semicolon Injection
 *	
 *	Hoisting
 *	
 *	!!42 = true !!!42false
 *
 *	== vs ===
 *
 *	implicit argument array object
 */

var a = 10;		//Number
var b = "10";	//String
var c = true;	//boolean
var d = {}		//Object - mainly key/value pairs
var e = null;	//null
//var f			//undefined
var g = (0/0);	//NaN - Not a number
var h = [];		//Array
var i = function(){
	var x = "inside a function"
	console.log('Hello World from i and a ' + a);
	console.log(' x ' + x);
}

function helloWorld() {
	console.log('Hello World');
	//no return = undefined
}

/*
 * 	No method overloading
 */

function sayThisWord(myWord) {
	console.log('Your word is my word ' + myWord());
}

function sayThisWord(myWord, myOtherWord) {
	console.log('Your word is my word ' + myWord + " my other word " + myOtherWord);
}














/*
 * 		Hoisting: undefined variables are brought to the top of the scope 
 */
function HoistingExample(num) {
//	var xyz;
	xyz = num;
	console.log('The xyz: ' + xyz);
//	var xyz; hoisted to the top of the scope
}

/*
 * Semicolon Injection - breaks our code more often than helping 
 */
function carefulWithCurlys() {
	var x = "hello";
	return; //Failure at trying to be a semicolonless language
			x;
}

function testMyNumber(num) {
	/*
	 * == performs type coercion - converts one of the two datatypes to match
	 * 								the other then checks the value
	 */
	if(num == 5){
		console.log("My num is 5");
	}		
	if(num === 5) {
		console.log("My num is definitely 5");
	}
}

/*
 * 	Truthy - {}, functions, -/+ numbers, Strings
 * 	Falsy - undefine, 0 NaN, "", null
 */
function amItrue(test){
	
//	var x = new String("hello");
	var x = new Boolean(false); //is actually true/truthy!
	if(x) {
		console.log('true');
	} else {
		console.log('false');
	}
}

/*
*	JS objects are not JSON
*		JSON is based on JS Objects
*
*/

var book = {
		key: "value",
		title: "Lord of the Rings",
		author: {
			name:"jk",
			dob: 1965,
			hobbies: "writting good books",
		},
		foo: function() {
			console.log("foo bar: a method of an object");
		}
}	

function iTakeNoArgs() {
	//print out all the args
	var x = arguments[0];
	console.log(arguments[0]);	
	//arguments - implicit Array object that holds the arguments passed
}

function guardOperator(myVar){
	return myVar && "2nd";
	/*first condition is enough then it returns first variable
	 *	if not then return the 2nd
	 * e.g. 
	 *	myVar = 10;
	 *  10 && "2nd" return true
	 * it evaluate entire statement if first arg is true
	 *	
	 * &&
	 *  left side true return right side
	 *  left side false return left side
	 */
}

function defaultOperator(myVar){
	return myVar || "2nd";
	/* 
	 * The opposite of && but same concept applies:
	 *  if first argument true return left side 
	 *  if first argument false return right side
	 */
}





var countCars = 0;
var countBirds = 0;

function countCar(){
	countCars++;
	console.log("Number of cars: " + countCars);
	return countCars;
}

function countBird(){
	countBird++;
	console.log("Number of cars: " + countBirds);
	return countBirds;
}

/**
 *  Closure will solve this problem!
 *  		Nested functions will hold the outside Function's state
 */
//Better but still only creates counters for birds not cars 
function makeBirdCounter(){
	var birdCount = 0;
	return function(){
		console.log('The count is ' + ++birdCount);
		return birdCount;
	}
}

//JavaScript encapsulation

//Now we can make counters for anything
function makeCounter(noun){
	var count = 0;
	return function(){
		console.log('The count of ' + noun + ' is ' + ++count);
		return count;
	}
}

function sum() {
	var x = arguments[0];
	for(i = 1; i < arguments.length; i++) {
		x += arguments[i];
	}
	
	if(arguments.length == 1) {
		return function(a) {
			return x + a;
		}
	}
	return x;
}

function sum1(x, y) {
	if(y !== undefined) {
		return x + y;
	} else {
		return function(y) {
			return x + y;
		}
	}
}