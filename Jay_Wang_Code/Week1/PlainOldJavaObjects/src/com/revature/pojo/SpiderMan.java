package com.revature.pojo;

import com.revature.abstracts.HumanAble;
import com.revature.abstracts.SuperHero;
import com.revature.exceptions.AttitudeProblemException;
import com.revature.exceptions.MakeItYourOwnException;
import com.revature.exceptions.TooRichProblemException;

public class SpiderMan extends SuperHero implements HumanAble{
	private boolean isFlyAbout = false;
	private boolean isRich = false;
	private boolean isSuperHero = true;
	
	public SpiderMan() {
		super("Spidy", "Cool outfit");
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
	public boolean isFlyAbout() {
		return this.isFlyAbout;
	}

	@Override
	public boolean isRich() {
		return this.isRich;
	}

	@Override
	public void talk() {
		System.out.println("Hey, what's up?");
	}

}
