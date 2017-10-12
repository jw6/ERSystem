package com.revature.pojo;

public class Pikachu extends Pokemon {

	//state
	private String trainer;
	private int peopleZapped;
	private boolean isShiny;
	
	//no-args
	public Pikachu() {
		super(55);//implicitly the first line of every constructor by default
//		this(55, "Ashe", 10, true); //can't have 2 calls to the Super();
		System.out.println("Instantiate Pikachu");
		setPokemonId(55); //Can still set private state of parent through the Setter
	}

	public Pikachu(int level, String trainer, int peopleZapped, boolean isShiny) {
		this.trainer = trainer;
		this.peopleZapped = peopleZapped;
		this.isShiny = isShiny;
	}


	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public int getPeopleZapped() {
		return peopleZapped;
	}

	public void setPeopleZapped(int peopleZapped) {
		this.peopleZapped = peopleZapped;
	}

	public boolean isShiny() {
		return isShiny;
	}

	public void setShiny(boolean isShiny) {
		this.isShiny = isShiny;
	}

	@Override
	public String toString() {
		return "Pikachu [trainer=" + trainer + ", peopleZapped=" + peopleZapped + ", isShiny=" + isShiny + "]";
	}
	
	public void talk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flyFaster() {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void fly() {
//		System.out.println("yes, pikachu can fly...");
//	}

//	@Override
//	public void flyFaster() {
//		System.out.println("even fly really fast..");
//	}
//
//	@Override
//	public void test() {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public double test() {
//		// TODO Auto-generated method stub
//		
//	}

	
	
}
