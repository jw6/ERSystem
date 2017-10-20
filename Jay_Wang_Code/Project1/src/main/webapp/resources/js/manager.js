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
			document.getElementById('viewAllRbs').addEventListener('click', loadAllReimbursementsView, false);
			document.getElementById('viewAllEmployees').addEventListener('click', loadAllEmployeesView, false);
			document.getElementById('searchByEmployee').addEventListener('click', loadSearchByEmployee, false);
			document.getElementById('allPending').addEventListener('click', loadAllPendingView, false);
			document.getElementById('allResolved').addEventListener('click', viewResolvedRequest, false);
		
		}
	}
	xhr.open('GET', 'loadManagerNavbar', true);
	xhr.send();
}

function viewResolvedRequest(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('managerHomeView').innerHTML = xhr.responseText;
			getResolved();
		}
	}
	xhr.open('GET', 'viewAllResolved', true);
	xhr.send();
}

function getResolved(){
	var xhr = new XMLHttpRequest();
	var resolved = null;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			resolved = JSON.parse(xhr.responseText);
			var row = null;
			var rbId, rbAmount, rbReceipt, ersId, status, managerId, rbType, rbSubmit, rbResolve, rbDescription;
			for(var i=0; i < resolved.length; i++){
				row = document.createElement('TR');

				rbId = document.createElement('TD');
				rbId.innerText = resolved[i].rbId;
				row.appendChild(rbId);

				getEmployeeName(resolved[i].ersId, row);

				rbAmount = document.createElement('TD');
				rbAmount.innerText = resolved[i].rbAmount;
				row.appendChild(rbAmount);

				rbType = document.createElement('TD');
				switch(resolved[i].rbtId){
					case 1:
						rbType.innerText = "Fee";
						break;
					case 2:
						rbType.innerText = "Hotel";
						break;
					case 3:
						rbType.innerText = "Food";
						break;
					case 4:
						rbType.innerText = "Travel";
						break;
					default:
						rbType.innerText = "N/A";
						break;
				}
				row.appendChild(rbType);

				status = document.createElement('TD');
				switch(resolved[i].stId){
					case 2:
						status.innerText = "Approved";
						break;
					case 3:
						status.innerText = "Denied";
						break;
					default:
						rbType.innerText = "N/A";
						break;
				}
				row.appendChild(status);

				getManager(resolved[i].managerId, row);

				rbSubmit = document.createElement('TD');
				rbSubmit.innerText = resolved[i].rbSubmitted;
				row.appendChild(rbSubmit);

				rbResolve = document.createElement('TD');
				rbResolve.innerText = resolved[i].rbResolved;
				row.appendChild(rbResolve);

				rbReceipt = document.createElement('TD');
				rbReceipt.innerText = resolved[i].rbReceipt;
				row.appendChild(rbReceipt);

				rbDescription = document.createElement('TD');
				rbDescription.innerText = resolved[i].description;
				row.appendChild(rbDescription);

				document.getElementById('allResolvedEntries').appendChild(row);
			}
		}
	}
	xhr.open('GET', 'getResolvedRequest', true);
	xhr.send();
}


function loadAllPendingView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('managerHomeView').innerHTML = xhr.responseText;
			getAllPendingRequests();

		}
	}
	xhr.open('GET', 'viewAllPendingRequest', true);
	xhr.send();
}

function getAllPendingRequests(){
	var xhr = new XMLHttpRequest();
	var pendingRbs = null;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			pendingRbs = JSON.parse(xhr.responseText);

			var rbId, ersId, rbAmount, rbType, rbSubmit, rbDescription;
			var row = null, aTD = null, dTD = null, s = null;
			var aButton = [], dButton = [];
			for(var i=0; i < pendingRbs.length; i++){
				row = document.createElement('TR');

				rbId = document.createElement('TD');
				rbId.innerText = pendingRbs[i].rbId;
				row.appendChild(rbId);

				getEmployeeName(pendingRbs[i].ersId, row);

				rbAmount = document.createElement('TD');
				rbAmount.innerText = pendingRbs[i].rbAmount;
				row.appendChild(rbAmount);

				rbType = document.createElement('TD');
				switch(pendingRbs[i].rbtId){
					case 1:
						rbType.innerText = "Fee";
						break;
					case 2:
						rbType.innerText = "Hotel";
						break;
					case 3:
						rbType.innerText = "Food";
						break;
					case 4:
						rbType.innerText = "Travel";
						break;
					default:
						rbType.innerText = "N/A";
						break;
				}
				row.appendChild(rbType);

				rbSubmit = document.createElement('TD');
				rbSubmit.innerText = pendingRbs[i].rbSubmitted;
				row.appendChild(rbSubmit);

				rbDescription = document.createElement('TD');
				rbDescription.innerText = pendingRbs[i].description;
				row.appendChild(rbDescription);

				aTD = document.createElement('TD');
				aButton[i] = document.createElement('button');
				aButton[i].innerText = 'Approve';
				aTD.appendChild(aButton[i]);
				row.appendChild(aTD);

				dTD = document.createElement('TD');
				dButton[i] = document.createElement('button');
				dButton[i].innerText = 'Deny';
				dTD.appendChild(dButton[i]);
				row.appendChild(dTD);

				document.getElementById('allPendingEntries').appendChild(row);
				(function(){
				var s = pendingRbs[i];

				aButton[i].addEventListener('click', function(){processApproval(s)}, false);
				dButton[i].addEventListener('click', function(){processDenial(s)}, false);
				console.log(aButton[i]);
				}());
			}
		}
	}
	xhr.open('GET', 'getAllPendingRequests', true);
	xhr.send();
}

function getEmployeeName(ersId, row){
	var xhr = new XMLHttpRequest();
	var employees = null;
	var employee = null;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			employees = JSON.parse(xhr.responseText);
			for(var i=0; i < employees.length; i++){
				if(employees[i].ersId == ersId){
					employee = document.createElement('TD');
					employee.innerText = employees[i].firstName + ' ' + employees[i].lastName;
					row.appendChild(employee);
					break;
				}
			}
		}
	}
	xhr.open('GET', 'getAllEmployees', false);
	xhr.send();
}

function processApproval(a){
	a.stId = 2;

	var approval = JSON.stringify(a);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			loadAllPendingView();
		}
	}
	xhr.open('POST', 'processApproval', true);
	xhr.setRequestHeader('key', approval);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(approval);

}

function processDenial(d){
	d.stId = 3;

	var denial = JSON.stringify(d);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			loadAllPendingView();
		}
	}
	xhr.open('POST', 'processDenial', true);
	xhr.setRequestHeader('key', denial);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(denial);
}

function loadAllReimbursementsView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('managerHomeView').innerHTML = xhr.responseText;
			getAllReimbursements();
		}
	}
	xhr.open('GET', 'viewAllReimbursements', true);
	xhr.send();
}

function getAllReimbursements() {
		var xhr = new XMLHttpRequest();
	var rbs = null;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			rbs = JSON.parse(xhr.responseText);

			var row;
			var rbId, employee, rbAmount, rbType, rbStatus, manager, rbSubmit, rbResolve, rbReceipt, rbDescription;
			for(var i=0; i < rbs.length; i++){
				row = document.createElement('TR');

				rbId = document.createElement('TD');
				rbId.innerText = rbs[i].rbId;
				row.appendChild(rbId);

				getEmployees(rbs[i].ersId, row);

				rbAmount = document.createElement('TD');
				rbAmount.innerText = rbs[i].rbAmount;
				row.appendChild(rbAmount);

				rbType = document.createElement('TD');
				switch(rbs[i].rbtId){
				case 1:
					rbType.innerText = "Fee";
					break;
				case 2:
					rbType.innerText = "Hotel";
					break;
				case 3:
					rbType.innerText = "Food";
					break;
				case 4:
					rbType.innerText = "Travel";
					break;
				default:
					rbType.innerText = "N/A";
					break;
				}
				row.appendChild(rbType);

				rbStatus = document.createElement('TD');
				switch(rbs[i].stId){
				case 1:
					rbStatus.innerText = "Pending";
					break;
				case 2:
					rbStatus.innerText = "Approved";
					break;
				case 3:
					rbStatus.innerText = "Denied";
					break;
				default:
					rbStatus.innerText = "N/A";
					break;
				}
				row.appendChild(rbStatus);


				getManager(rbs[i].managerId, row);

				rbSubmit = document.createElement('TD');
				rbSubmit.innerText = rbs[i].rbSubmitted;
				row.appendChild(rbSubmit);

				rbResolve = document.createElement('TD');
				rbResolve.innerText = rbs[i].rbResolved;
				row.appendChild(rbResolve);

				rbReceipt = document.createElement('TD');
				rbReceipt.innerText = rbs[i].rbReceipt;
				row.appendChild(rbReceipt);

				rbDescription = document.createElement('TD');
				rbDescription.innerText = rbs[i].description
				row.appendChild(rbDescription);

				document.getElementById('allRbEntries').appendChild(row);
			}
		}
	}
	xhr.open('GET', 'getAllReimbursements', true);
	xhr.send();
}

function getEmployees(ersId, row){
	var xhr = new XMLHttpRequest();
	var employees = null;
	var employee = null;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			employees = JSON.parse(xhr.responseText);
			for(var i=0; i < employees.length; i++){
				if(ersId == employees[i].ersId){
					employee = document.createElement('TD');
					employee.innerText = employees[i].firstName + " " + employees[i].lastName;
					row.appendChild(employee);
				}
			}
		}
	}
	xhr.open('GET', 'getAllEmployees', false);
	xhr.send();
}

function loadAllEmployeesView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('managerHomeView').innerHTML = xhr.responseText;
			getAllEmployees();
		}
	}
	xhr.open('GET', 'viewAllEmployees', true);
	xhr.send();
}

function getAllEmployees(){
	var xhr = new XMLHttpRequest();
	var employees = null;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			employees = JSON.parse(xhr.responseText);
			var eId, eFn, eLn, eUn, eEmail;
			var row;
			for(var i=0; i < employees.length; i++){
				row = document.createElement('TR');

				eId = document.createElement('TD');
				eId.innerText = employees[i].ersId;
				row.appendChild(eId);

				eFn = document.createElement('TD');
				eFn.innerText = employees[i].firstName;
				row.appendChild(eFn);

				eLn = document.createElement('TD');
				eLn.innerText = employees[i].lastName;
				row.appendChild(eLn);

				eUn = document.createElement('TD');
				eUn.innerText = employees[i].username;
				row.appendChild(eUn);

				eEmail = document.createElement('TD');
				eEmail.innerText = employees[i].email;
				row.appendChild(eEmail);

				document.getElementById('EmployeeList').appendChild(row);
				row.setAttribute('class', 'emp');
			}
		}
	}
	xhr.open('GET', 'getAllEmployees', true);
	xhr.send();
}

function loadSearchByEmployee(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('managerHomeView').innerHTML = xhr.responseText;
			document.getElementById('searchBtn').addEventListener('click', loadSearchResults, false);
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

function loadSearchResults(){
	var eId = document.getElementById('searchForEmp').value;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('managerHomeView').innerHTML = xhr.responseText;
			getRbByEmployee(eId);
		}
	}
	xhr.open('GET', 'searchResultsView', true);
	xhr.send();
}

function getRbByEmployee(eId) {
	var empObj = {
			ersId: eId,
			firstName: null,
			lastName: null,
			username: null,
			password: null,
			email: null
	}
	var emp = JSON.stringify(empObj);

	var xhr = new XMLHttpRequest();
	var rbs = null;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			if(xhr.responseText == ""){
				loadSearchByEmployee();
			}else{
				rbs = JSON.parse(xhr.responseText);
				var row = null;
				var rbId = "", rbAmount="", rbType="", rbStatus="", rbSubmit="", rbResolve="", rbReceipt="", rbDescription="";
				for(var i=0; i < rbs.length; i++){
					row = document.createElement('TR');
					rbId = document.createElement('TD');
					rbId.innerText = rbs[i].rbId;
					row.appendChild(rbId);

					rbAmount = document.createElement('TD');
					rbAmount.innerText = rbs[i].rbAmount;
					row.appendChild(rbAmount);

					rbType = document.createElement('TD');
					switch(rbs[i].rbtId){
					case 1:
						rbType.innerText = "Fee";
						break;
					case 2:
						rbType.innerText = "Hotel";
						break;
					case 3:
						rbType.innerText = "Food";
						break;
					case 4:
						rbType.innerText = "Travel";
						break;
					default:
						rbType.innerText = "N/A";
						break;
					}
					row.appendChild(rbType);

					rbStatus = document.createElement('TD');
					switch(rbs[i].stId){
					case 1:
						rbStatus.innerText = "Pending";
						break;
					case 2:
						rbStatus.innerText = "Approved";
						break;
					case 3:
						rbStatus.innerText = "Denied";
						break;
					default:
						rbStatus.innerText = "N/A";
						break;
					}
					row.appendChild(rbStatus);

					getManager(rbs[i].managerId, row);

					rbSubmit = document.createElement('TD');
					rbSubmit.innerText = rbs[i].rbSubmitted;
					row.appendChild(rbSubmit);

					rbResolve = document.createElement('TD');
					rbResolve.innerText = rbs[i].rbResolved;
					row.appendChild(rbResolve);

					rbReceipt = document.createElement('TD');
					rbReceipt.innerText = rbs[i].rbReceipt;
					row.appendChild(rbReceipt);

					rbDescription = document.createElement('TD');
					rbDescription.innerText = rbs[i].description
					row.appendChild(rbDescription);

					document.getElementById('empRbEntries').appendChild(row);
				}
			}
		}
	}

	xhr.open('POST', 'getRbByEmployee', true);
	xhr.setRequestHeader('key', emp);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(emp);
}

function getManager(managerId, row){
	var xhr = new XMLHttpRequest();
	var managers = null;
	var manager = null;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			managers = JSON.parse(xhr.responseText);
			for(var i=0; i < managers.length; i++){
				if(managerId == managers[i].ersId){
					manager = document.createElement('TD');
					manager.innerText = managers[i].firstName + ' ' + managers[i].lastName;
					row.appendChild(manager);
				}else{
					manager = document.createElement('TD');
					manager.innerText = 'N/A';
					row.appendChild(manager);
				}

			}
		}
	}
	xhr.open('GET', 'getAllManagers', false);
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