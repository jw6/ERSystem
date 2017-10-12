/**
 * Generate table rows as students enter their info
 */


/**
 * AddEventListener
 * 	takes 2 arguments
 * 	first is the type event we are listening for
 * 	e.g click 
 * 	second is the function that will invoked when the event occurs 
 */
document.getElementById('studBtn').addEventListener('click', processStudenForm)

function processStudenForm() {
	//First step, fetch data from the form
	var studName = document.getElementById('studName').value;
	var studMajor = document.getElementById('studMajor').value;
	var studAge = document.getElementById('studAge').value;
	
	console.log('The stud s info is: ' + studName + ' ' + studMajor + ' ' + studAge);
	
	//create the cell - td
	var tdName = document.createElement('td');
	var tdMajor = document.createElement('td');
	var tdAge = document.createElement('td');

	//give the value to the cells
	tdName.innerHTML = studName;
	tdMajor.innerHTML = studMajor;
	tdAge.innerHTML = studAge;
	
	//create the row - tr
	var row = document.createElement('tr');
	
	//append the cells to tr
	row.appendChild(tdName);
	row.appendChild(tdMajor);
	row.appendChild(tdAge);
	
	//add the row to the table
	var table = document.getElementById('studTable');
	table.appendChild(row);
	
	//clear the fields
	document.getElementById('studName').value="";
	document.getElementById('studMajor').value="";
	document.getElementById('studAge').value="";
}
