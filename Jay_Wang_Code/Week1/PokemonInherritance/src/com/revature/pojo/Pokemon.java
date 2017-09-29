package com.revature.pojo;

public abstract class Pokemon {
	//state
	private int pokemonId;
	public String name;
	protected String type;
	int level;
	
	//no-args
	public Pokemon() {
		System.out.println("Instantiating a Pokemon");
	}
	
	public Pokemon(int x) {
		System.out.println("Instantiating a Pokemon");
	}
	
	//behaviors
	public abstract void talk();
	
	public int getPokemonId() {
		return pokemonId;
	}
	
	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}
	//toString

	@Override
	public String toString() {
		return "Pokemon [pokemonId=" + pokemonId + ", name=" + name + ", type=" + type + ", level=" + level + "]";
	}
	
}
