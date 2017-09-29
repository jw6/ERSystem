package com.revature.dao;

import java.util.List;

import com.revature.domain.FlashCard;

public interface Dao {
		/*
		 *			CRUD METHODS ONLY! 		
		 */
	
	//CREATE
	public int createFlashCard(FlashCard fc);
	//READ
	public List<FlashCard> getAllFlashCard();
	public FlashCard getFlashCardById(int id);
	public FlashCard getFlashCardByQuestion(String question);
	//UPDATE
	public int updateFlashCard(FlashCard fc);
	
	//DELETE
	public int deleteFlashCard(FlashCard fc);
}
