package com.revature.pojo;

import com.revature.abstracts.HumanAble;
import com.revature.abstracts.SuperHero;
import com.revature.exceptions.AttitudeProblemException;
import com.revature.exceptions.MakeItYourOwnException;
import com.revature.exceptions.TooRichProblemException;

public class BatMan extends SuperHero implements HumanAble{
	private boolean isFlyAbout = false;
	private boolean isRich = true;
	private boolean isSuperHero = true;
	
	public BatMan() {
		super("Bat", "Cool kits");
	}
	
	public BatMan(String enemyName) {
		System.out.println("Batman's enemy is " + enemyName);
	}
	
	public void beingBatMan() throws AttitudeProblemException{
		throw new AttitudeProblemException();
	}
	
	public void equiment() {
		if(isRich) {
			try {
				throw new TooRichProblemException();
			} catch (TooRichProblemException e) {
				e.printStackTrace();
			}
		} else {
			try {
				throw new MakeItYourOwnException();
			} catch (MakeItYourOwnException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void jump() {
		System.out.println("Batman jumps pretty high");
	}
	
	void sideKick() {
		System.out.println("The name is Robin");
	}
	

	@Override
	public boolean isFlyAbout() {
		return this.isFlyAbout;
	}

	@Override
	public boolean isRich() {
		return this.isRich;
	}


	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("I'M BATMAN!");
	}

}
