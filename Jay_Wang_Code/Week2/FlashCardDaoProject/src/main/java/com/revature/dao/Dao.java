package com.revature.dao;

import java.util.List;

import com.revature.domain.FlashCard;

public interface Dao {
	/*
	 * 
	 * 	CRUD Methods Only!
	 */
	
	//Create
	public int createFlashCard(FlashCard fc);
	
	//Read
	public List<FlashCard> getAllFlashCard();
	public FlashCard getFlashCardById(int id);
	public FlashCard getFlashCardByQuestion(String Question);
	
	//Update
	public int updateFlashCard(FlashCard fc);
	
	//Delete
	public int deleteFlashCard(FlashCard fc);
}
