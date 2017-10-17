/**
 * 
 */
window.onload = function() {
	loadNavbar();
}

function loadNavbar() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			navbar = xhr.responseText;
			document.getElementById('employeeNavbar').innerHTML = navbar;
		}
	}
	
	xhr.open('GET', 'employeeNavBar', true);
	xhr.send();
}

function loadEmployeeHomeView() {
	var xhr = new XMLHttpRequest() 
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			homeView = xhr.responseText();
			document.getElementById('employeeHomeView').innerHTML = homeView;
//			getEmployeeInfo();
		}
	}
	xhr.open('GET', 'employeeHomeView', true);
	xhr.send();
}

var employee = {};
function getEmployeeInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			employee = JSON.parse(xhr.responseText);
			document.getElementById('employeeFirstName').innerHTML = employee.firstname;
			document.getElementById('employeeLastName').innerHTML = employee.lastname;
		}
	}
	xhr.get('GET', 'getemployeeinfo', true);
	xhr.send();
}