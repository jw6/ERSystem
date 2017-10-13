/**
 *	app.js 
 */
window.onload = function() {
	console.log('DOM READY');
	loadNavbar();
	loadRevatureHomeView();
}
var navbar = null;

function loadNavbar() {
	console.log('Loading Navbar');
	//Use AJAX to fetch the navbar.html fragment1
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("received navbar fragment");
		//3
		if(xhr.readyState == 4 && xhr.status == 200){
			navbar = xhr.responseText;
			document.getElementById("navbar").innerHTML = navbar;
			/*
			 * Once the navbar has loaded we want to set Event Listeners for changing the views
			 */
			document.getElementById('revatureHome').addEventListener("click", loadRevatureHomeView, false);
			document.getElementById('tx').addEventListener("click", loadTxView, false);
		} 
	}
	
	//true for asynchronous 2
	xhr.open("GET", "URL_is_ajaxNavbar", true);
	
	xhr.send();
}

function loadRevatureHomeView() {
	console.log('Loading RevatureHome');
	//Use AJAX to fetch the navbar.html fragment1
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("received revatureHome fragment");
		//3
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			getBankUserInfo();
		} 
	}
	
	//true for asynchronous 2
	xhr.open("GET", "URL_is_ajaxRevatureHomeView", true);
	xhr.send();
}

var bankUser =null;

function getBankUserInfo() {
	console.log('Loading Navbar');
	
	//Use AJAX to fetch the a JSON object from server that holds bank user data
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		//3
		if(xhr.readyState == 4 && xhr.status == 200){
			bankUser = JSON.parse(xhr.responseText);
			document.getElementById("bankuser").innerHTML = bankUser.username;
			document.getElementById("baNumber").innerHTML = bankUser.baId;
			document.getElementById("baBalance").innerHTML = bankUser.baBalance;
		} 
	}
	
	//true for asynchronous 2
	xhr.open("GET", "ajaxGetBankUserInfo", true);
	xhr.send();
	
}

function loadTxView() {
	console.log('Loading Navbar');
	//Use AJAX to fetch the navbar.html fragment1
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		//3
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML =xhr.responseText;
		} 
	}
	
	//true for asynchronous 2
	xhr.open("GET", "URL_is_ajaxTxView", true);
	
	xhr.send();
}
