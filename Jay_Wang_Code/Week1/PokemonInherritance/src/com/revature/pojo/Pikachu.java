package com.revature.pojo;
import com.revature.abstracts.Flyable;
import com.revature.abstracts.Swimable;

public class Pikachu extends Pokemon implements Flyable, Swimable {
	
	//state
	private String trainer;
	private int peopleZapped;
	private boolean isShiny;
	
	//no-args
	public Pikachu() {
		super(1); //Implicitly calling super()
		System.out.println("Instantiate Pikachu");
	}
	
	public Pikachu(String x) {
		super();	
	}
	
	public Pikachu(String trainer, int peopleZapped, boolean isShiny) {
		this();
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

	@Override
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
	
	public boolean isShiny() {
		return false;
		
	}
}
