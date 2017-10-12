/**
 *  Generate table rows as students enter their info
 */

/*
 * AddEventListener
 * 	takes 2 arguments
 * 		1st is the type of event we are listening for
 * 			e.g. click 
 * 		2nd is the function that will be INVOKED when the event occurs
 */
document.getElementById('studBtn').addEventListener('click', processStudentForm() )

function processStudentForm(){
	
	//Grab the data from the form
	var studName = document.getElementById('studName').value;
	var studMajor = document.getElementById('studMajor').value;
	var studAge = document.getElementById('studAge').value;
	
	console.log('The studs info is: ' + studName + ' ' + studMajor + ' ' + studAge);
	
	//create the cells - td
	var tdName = document.createElement('td');
	var tdMajor = document.createElement('td');
	var tdAge = document.createElement('td');
	
	//give the value to the cells
	tdName.innerHTML = studName;
	tdMajor.innerHTML = studMajor;
	tdAge.innerHTML = studAge;
	
	//create the row -tr
	var row = document.createElement('tr');
	
	//append the cells to the tr
	row.appendChild(tdName);
	row.appendChild(tdMajor);
	row.appendChild(tdAge);
	
	//add the row to the table
	var table = document.getElementById('studTable');
	table.appendChild(row);
	
	//clear the fields
	document.getElementById('studName').value = "";
	document.getElementById('studMajor').value = "";
	document.getElementById('studAge').value = "";
	
	return processStudentForm;
	
}