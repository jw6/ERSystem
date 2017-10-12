/**
 * 
 */
window.onload = function(){
	console.log('DOM ready');
	//place anything that needs to wait for the DOM to finish loading
	document.getElementById('pokeBtn').addEventListener("click", getPokemon );
}

var pokemon = null;
function getPokemon(){
	//Get the user's input from the pokeId field
	var pokeId = document.getElementById('pokeId').value;
	console.log('Getting Pokemon: ' + pokeId);
	
	//Send a XHR: XML Http Request is AJAX
	var xhr = new XMLHttpRequest();
	
	//Define what's going to happen upon the response 
	xhr.onreadystatechange = function(){
		/*
		 * 	What do each of the readyState mean? 1-4
		 * 		1 - request is send
		 * 		2 - request has been received by the server
		 * 		3 - request is processing 
		 * 		4 - Response is received and ready
		 * 
		 */
		console.log('The readyState has changed ' + xhr.readyState);
		
		if(xhr.readyState == 4 && xhr.status == 200){
			pokemon = JSON.parse(xhr.responseText);
			updatePageWithPokemon(pokemon);
		}
		
	} 
	//Define where Request is going and how: URL & Type
	/*
	 * Takes 3 parameters:
	 * 		1. Request Type- GET or POST
	 * 		2. URL
	 * 		3. Boolean for Ayschronize - Must be True
	 */
	xhr.open("GET","https://pokeapi.co/api/v2/pokemon/" + pokeId, true );
	
	//Send it, with Post-parameters(optional)
	xhr.send(); //xhr.send(postData); if we were sending POST Request Type
}


function updatePageWithPokemon(pokemon){
	document.getElementById('pokeName').innerHTML = pokemon.name;
	document.getElementById('pokeImg').src = pokemon.sprites.front_shiny;
		document.getElementById('pokeImg').setAttribute('alt', 'A shiny pokemon!'); //another way src could have set
}

