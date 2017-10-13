/**
 * 
 */
window.onload = function() {
	console.log("DOM ready!");
	loadNavbar();
}


var navbar = null;
function loadNavbar() {
	console.log("Loading Navbar");
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		console.log("Received navbar fragment");
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			navbar = xhr.responseText;
			document.getElementById("navbar").innerHTML = navbar;
		}
	}
	xhr.open("GET","ajaxNavbar", true);
	xhr.send();
}


function loadPiedPiperHomeView() {
	console.log("Loading Pied Piper Home View");
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		console.log("Received Home View fragment");
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			//something here
		}
	}
	xhr.open("GET","ajaxPiedPiperHomeView", true);
	xhr.send();
}

