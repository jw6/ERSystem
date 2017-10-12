package com.revature.pojo;

import com.revature.abstracts.SuperAwesome;

//POJO
public abstract class Pokemon implements SuperAwesome{

	//state
	private int pokemonId;
	public String name;
	protected final String type;
	int level;
	
	//no-args
	public Pokemon(){
		super();
		this.type = "Fire";
		System.out.println("Instantiating a Pokemon");
	}
	
	public Pokemon(int level) {
		super();
		this.level = level;
		this.type = "Fire";
	}



	//behavior
	public final int getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}

	public void talk(){}
	
	//toString
	@Override
	public String toString() {
		return "Pokemon [pokemonId=" + pokemonId + ", name=" + name + ", type=" + type + ", level=" + level + "]";
	}

	
}
