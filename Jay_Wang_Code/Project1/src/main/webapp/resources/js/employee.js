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
			document.getElementById("editAccountInfo").addEventListener('click', editEmployeeInfo, false);
			
			document.getElementById("newReimbursementbRequest").addEventListener('click', newReimbursementView, false);
			document.getElementById("viewReimbursementHistory").addEventListener('click', viewReimbursement, false)
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
			document.getElementById("employeeHomeView").innerHTML = edit;
			
			document.getElementById("ersId").value = employee.ersId;
			document.getElementById("firstName").placeholder = employee.firstName;
			document.getElementById("lastName").placeholder = employee.lastName;
			document.getElementById("username").placeholder = employee.username;
			document.getElementById("password").placeholder = employee.password;
			document.getElementById("email").placeholder = employee.email;
			document.getElementById("confirmBtn").addEventListener('click', updateEmployeeInfo, false); 
		}
	}
	xhr.open('GET', 'editEmployeeInfo', true);
	xhr.send();
}

//unverified, switch to work on reimbursement
function updateEmployeeInfo() {
	var id = document.getElementById("ersId").value;
	var firstName = document.getElementById("firstName").value;
	var lastName = document.getElementById("lastName").value;
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var email = document.getElementById("email").value;
	
	while(password == null && username == null) {
		editEmployeeInfo();
	}
	
	employee.ersId = id;
	employee.firstName = firstName;
	employee.lastName = lastName;
	employee.username = username;
	employee.password = password;
	employee.email = email;
	
	var str = JSON.stringify(employee);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			if(xhr.responseText == "") {
				employeeInfoView();
			} else {
				document.getElementById('employeeHomeView').innerHTML = xhr.responseText;
				editEmployeeInfo()
			}
		}
	}
	
	xhr.open('POST', 'updateEmployeeInfo', true);
	xhr.setRequestHeader('key', str);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(str);
}

function newReimbursementView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('employeeHomeView').innerHTML = xhr.responseText;
			document.getElementById('submitRequestBtn').addEventListener('click', submitRequestBtn, false);
		}
	}
	xhr.open('GET', 'newReimbursementbRequest', true);
	xhr.send();
}

var request = null;
function submitRequestBtn() {
	var xhr = new XMLHttpRequest();
	
	var ersId = document.getElementById('ersId').value;
	var amount = document.getElementById('amount').value;
	var rbType = document.getElementById('rbType').value;
	
	for(var i = 0; i < rbType.length; i++){
		if(rbType[i].selected){
			rbType = rbType[i].innerText;
			break;
		}
	}
	if(rbType == "Fee") {
		rbType = 1;
	} else if(rbType == "Hotel") {
		rbType = 2;
	} else if(rbType == "Food") {
		rbType = 3;
	} else if(rbType == "Travel") {
		rbType = 4;
	} else {
		rbType = 0;
	}
	
	var description = document.getElementById("rbDescription").value;
	var rbRequest = {
			ersId: ersId,
			rbAmount: amount,
			rbtId: rbType,
			description: description
	}
	console.log(rbRequest);
	var str = JSON.stringify(rbRequest);
	console.log(str);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			if(xhr.responseText == ""){
				loadEmployeeHomeView();
			}else{
				document.getElementById('employeeHomeView').innerHTML = xhr.responseText;
				newReimbursementView();
			}
		}
	}

	xhr.open('POST', 'submitRequestBtn', true);
	xhr.setRequestHeader('key', str);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(str);
}


function viewReimbursement() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200) {
			var info =xhr.responseText;
			document.getElementById('employeeHomeView').innerHTML = info;
			console.log("testing1");
			loadReimbursement();
			
		}
	}
	xhr.open('GET', 'viewReimbursement', true);
	xhr.send();
}
var rbHistory;
function loadReimbursement() {
	console.log("testing");
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200) {
		
			rbHistory = JSON.parse(xhr.responseText);
			console.log('test');
			var row = null;
			var rb_Id, rb_Amount, rb_Receipt, ers_Id, st_Id, manager_Id, rbt_Id, rb_Submitted, rb_Resolved, rb_Description;
			for(var i=0; i < rbHistory.length; i++){
				
				rb_Id = document.createElement('TD');
				rb_Id.innerText = rbHistory[i].rbId;
				document.getElementById("rb_Id").appendChild(rb_Id);
				document.getElementById("rb_Id").appendChild(document.createElement("br"));
				
				rb_Amount = document.createElement('TD');
				rb_Amount.innerText = rbHistory[i].rbAmount;
				document.getElementById("rb_Amount").appendChild(rb_Amount);
				document.getElementById("rb_Amount").appendChild(document.createElement("br"));
				
				rbt_Id = document.createElement('TD');
				switch(rbHistory[i].rbtId){
				case 1:
					rbt_Id.innerText = "Fee";
					break;
				case 2:
					rbt_Id.innerText = "Hotel";
					break;
				case 3:
					rbt_Id.innerText = "Food";
					break;
				case 4:
					rbt_Id.innerText = "Travel";
					break;
				default:
					rbt_Id.innerText = "N/A";
					break;
				}
				document.getElementById("rbt_Id").appendChild(rbt_Id);
				document.getElementById("rbt_Id").appendChild(document.createElement("br"));
				
				st_Id = document.createElement('TD');
				switch(rbHistory[i].stId){
				case 1: 
					st_Id.innerText = "Pending";
					break;
				case 2: 
					st_Id.innerText = "Approved";
					break;
				case 3:
					st_Id.innerText = "Denied";
					break;
				default:
					st_Id.innerText = "N/A";
					break;
				}
				document.getElementById("st_Id").appendChild(st_Id);
				document.getElementById("st_Id").appendChild(document.createElement("br"));
				
				manager_Id = document.createElement('TD');
				manager_Id.innerText = rbHistory[i].managerId;
				document.getElementById("manager_Id").appendChild(manager_Id);
				document.getElementById("manager_Id").appendChild(document.createElement("br"));
				
				
				rb_Submitted = document.createElement('TD');
				rb_Submitted.innerText = rbHistory[i].rbSubmitted;
				document.getElementById("rb_Submitted").appendChild(rb_Submitted);
				document.getElementById("rb_Submitted").appendChild(document.createElement("br"));
				
				rb_Resolved = document.createElement('TD');
				rb_Resolved.innerText = rbHistory[i].rbResolved;
				document.getElementById("rb_Resolved").appendChild(rb_Resolved);
				document.getElementById("rb_Resolved").appendChild(document.createElement("br"));
				
				rb_Receipt = document.createElement('TD');
				rb_Receipt.innerText = rbHistory[i].rbReceipt;
				document.getElementById("rb_Receipt").appendChild(rb_Receipt);
				document.getElementById("rb_Receipt").appendChild(document.createElement("br"));
				
				
				rb_Description = document.createElement('TD');
				rb_Description.innerText = rbHistory[i].description;
				document.getElementById("rb_Description").appendChild(rb_Description);
				document.getElementById("rb_Description").appendChild(document.createElement("br"));
				
			}
		}
	}
	xhr.open('GET', 'loadReimbursement', true);
	xhr.send();
}