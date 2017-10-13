/**
 * 
 */

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