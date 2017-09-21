package com.revature.pojo;

public interface HumanAble {
	int legs = 2;
	int hands = 2;
	boolean goodGuy = true;
	default void goodHeart() {
		System.out.println("Super heroes are good guys " + goodGuy);
	}
	void talk();
}
