package com.revature.abstracts;

public abstract class SuperHero {
	//fields
	private String nickName;
	private String outfit;
	
	//no-args
	public SuperHero() {
		
	}
	
	public SuperHero(String nickName, String outfit) {
		super();
		this.nickName = nickName;
		this.outfit = outfit;
		System.out.printf("A super hero " + nickName + " " +outfit + "\n");
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
