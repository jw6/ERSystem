package com.revature.abstracts;

import com.revature.exceptions.attitudeProblemException;
import com.revature.exceptions.makeItYourOwnException;
import com.revature.exceptions.tooRichProblemException;
import com.revature.pojo.HumanAble;

public class BatMan extends SuperHero implements HumanAble{
	boolean isFlyAbout = false;
	boolean isRich = true;
	boolean isSuperHero = true;
	
	public BatMan() {
		
	}
	
	public BatMan(String enemyName) {
		System.out.println("Batman's enemy is " + enemyName);
	}
	
	public void beingBatMan() throws attitudeProblemException{
		throw new attitudeProblemException();
	}
	
	public void equiment() {
		if(isRich) {
			try {
				throw new tooRichProblemException();
			} catch (tooRichProblemException e) {
				e.printStackTrace();
			}
		} else {
			try {
				throw new makeItYourOwnException();
			} catch (makeItYourOwnException e) {
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
	boolean isFlyAbout() {
		return this.isFlyAbout;
	}

	@Override
	boolean isRich() {
		return this.isRich;
	}


	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("I'M BATMAN!");
	}

}
