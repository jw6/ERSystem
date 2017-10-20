window.onload= function() {
	loadNavbar();
	managerHomeView();
}

function loadNavbar() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('managerNavbar').innerHTML = xhr.responseText;
			document.getElementById('managerHomePage').addEventListener('click', managerHomeView, false);
//			document.getElementById('viewAllRbs').addEventListener('click', loadAllReimbursementsView, false);
//			document.getElementById('viewAllEmployees').addEventListener('click', loadAllEmployeesView, false);
			document.getElementById('searchByEmployee').addEventListener('click', loadSearchByEmployee, false);
//			document.getElementById('allPending').addEventListener('click', loadAllPendingView, false);
//			document.getElementById('allResolved').addEventListener('click', loadAllResolvedView, false);
		
		}
	}
	xhr.open('GET', 'loadManagerNavbar', true);
	xhr.send();
}

function loadSearchByEmployee(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('managerHomeView').innerHTML = xhr.responseText;
//			document.getElementById('searchBtn').addEventListener('click', loadSearchResults, false);
		}
	}
	xhr.open('GET', 'searchByEmployee', true);
	xhr.send();
}

function managerHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('managerHomeView').innerHTML = xhr.responseText;
			getManagerInfo();
		}
	}
	xhr.open('GET', 'managerHomeView', true);
	xhr.send();
}

function getManagerInfo(){
	var xhr = new XMLHttpRequest();
	var manager = null;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			manager = JSON.parse(xhr.responseText);
			document.getElementById('managerFirstName').innerHTML = manager.firstName;
			document.getElementById('managerLastName').innerHTML = manager.lastName;
		}
	}
	xhr.open('GET', 'getManagerInfo', true);
	xhr.send();
	return manager;
}