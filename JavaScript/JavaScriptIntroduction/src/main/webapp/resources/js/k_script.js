/**
 *  Introduction to JavaScript
 *  
 *  JS:
 * 	
 * 	Is interpreted vs compiled?
 * 		JS is interpreted not compiled  
 *  
 *  Loosely/Weakly Type vs Strictly/Strongly
 *  	variables can be reassigned to different datatypes
 *  
 *  Variable can be functions
 *  		&
 *  Functions can take another function as an argument
 *  To invoke a function use () 
 *  
 *  
 *  No Method/function Overloading: last defined is replacing previous declarations
 *  	Methods - belong to objects
 *  	Functions - do not
 *  
 *  2 Scopes in JS:
 *  	-Global
 *  	-function
 *  
 *  Truthy/falsy
 *  
 *  Semicolon Injection
 *  
 *  Hoisting
 *  
 *  !!42 = true !!!42 = false etc
 *  
 *  == vs === 
 *  
 *  implicit argument array object
 *  
 */


var a = 10; //Number
var b = "10"; //String
var c = true; //boolean
var d = {}  //Object - mainly key/value pairs
var e = null; //null 
//var f	//undefine - not even null
var g = (0/0); //NaN - Not A Number
var h = []; //Array
//var i = function(){} //function

/** 
 *  variables can be functions
 */
var i = function(){
	var x = "inside a function";
	console.log('Hello World from i and a: ' + a);
	console.log(' x: ' + x);
}


function helloWorld(){
	console.log('Hello World!');
	//no return = undefined
}

/**
 * 	No method overloading
 */

function sayThisWord(myWord){
	console.log('Your word is: ' + myWord );
}

function sayThisWord(myWord, myOtherWord){
	console.log('Your word is: ' + myWord  + " The other word " + myOtherWord);
}


/**
 *		Hoisting: undeclared variables are brought to the top of the scope  
 */
function hoistingExample(num){
	xyz = num;
	console.log('The xyz: ' + xyz);
//	var xyz; //hoisted to the top of the scope
}

/**
 * Semicolon Injection - breaks our code more often than helping 
 */
function carefulWithCurlys(){
	var x = "hello";
	return;	//Failure at trying to be a semicolon-less language
			x;
}


function testTwoNumber(x, y){
	if( x > y){
		console.log(x);
	}else{
		console.log(y)
	}
}

function testMyNumber(num){
	/*
	 *	== performs type coercion - converts one of the two datatypes to match
	 *									the other then checks the value 
	 *	=== first checks datatypes if they mismatch instantly false
	 *			if matched then checks value
	 */
	if(num == 5){
		console.log("num is 5");
	}
	
	if(num === 5){
		console.log("num is DEFINITELY 5");
	}
}


function amItrue(test){
	
	/*
	 * Truthy - {}, Functions, -/+ numbers, Strings 
	 * Falsy - undefine, 0, NaN, "", null 
	 * 
	 */
	var x = new Boolean(false); //is actually true/truthy!
	if(x){
		console.log('true');
	}else{
		console.log('false')
	}
	
}


/**
 * 		JS Objects are not JSON
 * 			JSON is based on JS Objects
 */
var book = {
		key: "value",
		title: "Lord of the Rings",
		author: {
			name: "jk",
			dob: 1965,
			hobbies: "writting good books"
		},
		foo: function(){
			console.log("foo boo: a method of an object!");
		}
}


function iTakeNoArgs(){
	//print out all the arguments!
	console.log(arguments[2]);
	//arguments - implicit Array object that holds the arguments passed 
}


function gaurdOperator(myVar){
	return (myVar && "2nd");
			/*
			 * &&
			 * 	left side true - return right side
			 * 	left side false - return left side
			 * 
			 * first condition is enough then it return first variable
			 * 	if not then return the 2nd;
			 * 	e.g. 
			 * 		myVar = 10;
			 * 		10 && "2nd"; returns "2nd"
			 * 		0 && "2nd"; returns 0
			 * 		"" && "2nd"; returns ""
			 * 		"hello" && "2nd"; returns "2nd"
			 */
	
}

function defaultOperator(myVar){
	return myVar || "2nd";
		/*
		 * The opposite of && but same concept applies:
		 * 		if first statement true - return the 1st 
		 * 		if first statement false - return the 2nd
		 * 
		 * 	e.g.
		 * 		true || "2nd": returns true
		 * 		false || "2nd": returns "2nd"
		 * 
		 */
}
