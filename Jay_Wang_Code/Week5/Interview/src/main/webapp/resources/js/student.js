/**
 * 
 */
window.onload = function() {
	loadNavbar();
	loadStudentProfileView();
}

function loadNavbar() {
	console.log("Loading Navbar");
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		console.log("Received navbar fragment");
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			navbar = xhr.responseText;
			document.getElementById("navbar").innerHTML = navbar;
			
			document.getElementById("StudentProfile").addEventListener('click', loadStudentProfileView, false);
		}
	}
	xhr.open("GET", "studentAjaxNavbar", true);
	xhr.send();
}

function loadStudentProfileView() {
	console.log("Loading Student Profile");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("Received student profile fragment");
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			getUserInfo();
		}
	}
	
	xhr.open("GET", "ajaxStudentProfileView", true);
	xhr.send();
}

var user = null;
function getUserInfo() {
	console.log("Loading Navbar");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			user = JSON.parse(xhr.responseText);
			document.getElementById("userId").innerHTML= user.
			document.getElementById("userFn").innerHTML= user.
			document.getElementById("userLn").innerHTML= user.
			document.getElementById("userName").innerHTML= user.
			document.getElementById("email").innerHTML= user.
		}
	}
	
}