package com.revature.abstracts;

import com.revature.exceptions.attitudeProblemException;
import com.revature.exceptions.makeItYourOwnException;
import com.revature.exceptions.tooRichProblemException;
import com.revature.pojo.HumanAble;

public class SpiderMan extends SuperHero implements HumanAble{
	boolean isFlyAbout = false;
	boolean isRich = false;
	boolean isSuperHero = true;
	
	public SpiderMan() {
		System.out.println("My spider sense is tingling");
	}
	
	public void beingSuperHero() throws attitudeProblemException {
		if(isSuperHero) {
			throw new attitudeProblemException();
		}
	}
	
	public void equiments() {
		if(isRich) {
			try {
				throw new tooRichProblemException();
			} catch (tooRichProblemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				throw new makeItYourOwnException();
			} catch (makeItYourOwnException e ) {
				e.printStackTrace();
			}
		}
	}
	
	public void naturalSuperPower(boolean flag) {
		System.out.println("Natural super power? " + flag);
	}
	
	public void crawling() {
		System.out.println("Slight skill");
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
		System.out.println("Hey, what's up?");
	}

}
