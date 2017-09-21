package com.revature.abstracts;

import com.revature.exceptions.AttitudeProblemException;
import com.revature.exceptions.MakeItYourOwnException;
import com.revature.exceptions.TooRichProblemException;
import com.revature.pojo.HumanAble;

public class SpiderMan extends SuperHero implements HumanAble{
	boolean isFlyAbout = false;
	boolean isRich = false;
	boolean isSuperHero = true;
	
	public SpiderMan() {
		System.out.println("My spider sense is tingling");
	}
	
	public void beingSuperHero() throws AttitudeProblemException {
		if(isSuperHero) {
			throw new AttitudeProblemException();
		}
	}
	
	public void equiments() {
		if(isRich) {
			try {
				throw new TooRichProblemException();
			} catch (TooRichProblemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				throw new MakeItYourOwnException();
			} catch (MakeItYourOwnException e ) {
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
