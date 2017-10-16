/**
 * 1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
 */
function getUSA(){
	var element = document.querySelector("div div h1 span[data-customAttr='USA']");
	var text = element.innerHTML;
	console.log(element);
	console.log(text);
}
/**
 * 2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
 */
function getPeopleInSales(){
	var table = document.getElementById("helloWorld");
	for (var i = 0, row; row = table.rows; i++) {
		   //iterate through rows
		   //rows would be accessed using the "row" variable assigned in the for loop
		console.log(table.rows);
		   for (var j = 0, col; col = row.cells[j]; j++) {
		     //iterate through columns
		     //columns would be accessed using the "col" variable assigned in the for loop
			   if(document.getElementByTagName('SPAN')[0].textContent === "Sales"){
				   console.log(document.getElementByTagName('SPAN')[0].textContent.innerHTML);
			   }
		   }  
	}
}
/**
 * 3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
 */
function getAnchorChildren(){
    var temp = []
    var l = document.getElementsByTagName('tr');
    for(var i = 0; i < l.length; i++){
    
        var dep = l[i].getElementsByTagName('td')[1];
        var name = l[i].getElementsByTagName('td')[0];
        if(dep != undefined){
            if(dep.innerHTML == "Sales"){
                temp.push(name.innerHTML)
            }
        }
    }
    return temp;
}
/**
 * 4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
 */
function getHobbies(){
	var x = document.getElementsByName('hobbies')
	var options = x[0].options
	for(var i =0; i < options.length; i++){
		console.log(options[i].innerHTML)
	}
}
/**
 * 5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
 */
function getCustomAttribute(){
	var elementsWithCustomAttr = document.querySelectorAll('[data-customAttr]')
	for(var i = 0; i< elementsWithCustomAttr.length; i++){
		var elementName = elementsWithCustomAttr[i].tagName
		var customAttrValue = elementsWithCustomAttr[i].getAttribute('data-customattr')
		console.log("element with data-customAttr: "+elementName + " has customAttr= " + customAttrValue);
	}
}
/**
 * 6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>
	
Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
 */
document.getElementById("num1").addEventListener('change', addNumbers);
document.getElementById("num2").addEventListener('change', addNumbers);
function addNumbers(){
	var num1 = document.GetElementsById("num1").value;
	var num2 = document.GetElementsById("num2").value;
	var sum;
	if(isNaN(num1) || isNan(num2)){
		result = "Cannot add";
	} else{
		result = num1 + num2;
	}
	
	document.getElementById("sum").innerHTML = result;
}
	
	
/**
 * 
7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.

 */

document.getElementsByName("skills")[0].addEventListener("change", askSkills);

function askSkills(){
	var x = document.getElementsByName("skills")[0].value;
	
	window.alert("Are you sure" + x + "is one of your skills?");
}

/**
 * 8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

 */
var list_of_colors = document.getElementsByName("favoriteColor");

for(i = 0; i < list_of_colors.length; i++){
	list_of_colors[i].addEventListener("change", changeColor);
}
var old_color = "red";

function changeColor(){
	for(i = 0; i < list_of_colors.length; i++){
		if(list_of_colors[i].checked){
			window.alert("So you like " + list_of_colors[i].value + "\nmore than " + old_color + " now?" );
			
			old_color = list_of_colors[i].value;
			
		}
	
	}
	for(i = 0; i < list_of_colors.length; i++){
		var x = list_of_colors[i];
		x.style.backgroundColor = old_color;
	}
	
}


/**
 * 9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.
 */

/**
 * 
10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
 */
window.onload = 
function startTime(){
	var date = new Date();
	var hour =date.getHours();
	var minute = addZeroes(date.getMinutes());
	var seconds = addZeroes(date.getSeconds());
	
	document.getElementById('currentTime').innerHTML = hour + ":"+ minute + ":" + second;
	
	var t = setTimeout(startTime, 3000);
}

function addZeroes(time){
	if(time < 10){
		i = "0" + time;
	}
	return time
}
/**
 * 11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
 */
document.getElementById("helloWorld").addEventListener("click");

function setColorChange(){
	setTimeout(changeTimedColor, 3000);
}

function changeColor(){
	var colors =["blue", "red", "black", "orange", "white", "green", "brown", "gray", "purple"];
	var x = Math.floor(Math.random() * 10);
	document.getElementById("helloWorld").style.color = colors[p]
}


/**
 * 12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
 */

function walkTheDOM(node, func){
	func(node);
	node = node.firstchild;
	
	while(node){
		walkTheDom(node, func);
		node = node.nextSibling;	
	}

}

function readNode(node){
	console.log(node.nodeName + ", " + node.nodeValue);
}