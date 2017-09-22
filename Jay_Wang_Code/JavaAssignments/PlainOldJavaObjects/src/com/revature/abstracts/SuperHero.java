package com.revature.abstracts;

public abstract class SuperHero {
	//fields
	String nickName;
	String outfit;
	
	//no-args
	public SuperHero() {
		
	}
	
	public SuperHero(String nickName, String outfit) {
		super();
		this.nickName = nickName;
		this.outfit = outfit;
	}

	void human() {
		System.out.println("Super heroes are also humans");
	}

	public abstract boolean isFlyAbout();
	
	public abstract boolean isRich();

	@Override
	public String toString() {
		return "SuperHero [nickName=" + nickName + ", outfit=" + outfit + "]";
	}
}
