/**
 * 
 */
window.onload = function() {
	loadNavbar();
	loadEmployeeHomeView()
}

function loadNavbar() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			navbar = xhr.responseText;
			document.getElementById('employeeNavbar').innerHTML = navbar;
			
			document.getElementById('employeeHomePage').addEventListener('click', loadEmployeeHomeView, false);
			document.getElementById('AccountInfo').addEventListener('click', employeeInfoView, false);
		}
	}

	xhr.open('GET', 'employeeNavBar', true);
	xhr.send();
}

function loadEmployeeHomeView() {
	var xhr = new XMLHttpRequest()
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			homeView = xhr.responseText;
			document.getElementById('employeeHomeView').innerHTML = homeView;
			getEmployeeInfo();
		}
	}
	xhr.open('GET', 'employeeHomeView', true);
	xhr.send();
}

var employee = {};
function getEmployeeInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			employee = JSON.parse(xhr.responseText);
			document.getElementById('employeeFirstName').innerHTML = employee.firstName;
			document.getElementById('employeeLastName').innerHTML = employee.lastName;
		}
	}
	xhr.open('GET', 'getEmployeeInfo', true);
	xhr.send();
}

function employeeInfoView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange =function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			info = xhr.responseText;
			document.getElementById("employeeHomeView").innerHTML = info;
			
			document.getElementById("ersId").innerHTML = employee.ersId;
			document.getElementById("ersFn").innerHTML = employee.firstName;
			document.getElementById("ersLn").innerHTML = employee.lastName;
			document.getElementById("ersUser").innerHTML = employee.username;
			document.getElementById("ersEmail").innerHTML = employee.email;
//			document.getElementById("editEmployeeInfoBtn").addEventListener('click', editEmployeeInfo, false);
		}
	}
	xhr.open('GET', 'employeeInfoView', true);
	xhr.send();
}

//edit EmployeeInfo()
function editEmployeeInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			edit = xhr.responseText;
			document.getElementById("editEmployeeInfoBtn").innerHTML = edit;
		}
	}
	xhr.open('GET', 'editEmployeeInfo', true);
	xhr.send();
}