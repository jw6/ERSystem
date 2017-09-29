package com.revature;
import com.revature.BananaAgeAmountToBigException;
import com.revature.exception.InvalidBananaColorException;

//POJO - Plain Old Java Object
public class Banana {

	//state 
	boolean isPeeled;
	private String color;
	double weight;
	
	//NO-ARGS Constructor
	public Banana() {
		
	}
	
	public void age() {
		System.out.println("banana ages");
		this.weight = this.weight * 0.5;
	}
	
	public void age(int ageAmount) throws com.revature.BananaAgeAmountToBigException {
		if(ageAmount > this.weight)
			throw new BananaAgeAmountToBigException();
		System.out.println("banana ages");
		this.weight = this.weight - ageAmount;
	}
	//Override toString()
	// @ Symbol is annotation
	@Override
	public String toString() {
		return "Banana [isPeeled=" + isPeeled + ", color=" + getColor() + ", weight=" + weight + "]";
	}

	String getColor() throws IllegalArgumentException {
		return color;
	}
	
	void setColor(String color) throws InvalidBananaColorException {
		if(this.color.equals("blue")) {	
			throw new InvalidBananaColorException();
		}
		this.color = color;
	}
}
