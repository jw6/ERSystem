package com.revature;

import java.util.List;

import com.revature.dao.Dao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.domain.FlashCard;

public class MainClass {
	/*
	 *	JDBC API
	 *		Connection
	 *		Statement
	 *		PreparedStatement
	 *		CallableStatement
	 *
	 *	DAO: Data Access Object type of Design Pattern
	 */
	
	public static void main(String[] args) {
		System.out.println("Create a Flash Card");
		
//		FlashCard fc = new FlashCard("Whens QC", "Less than an hour");
		
		Dao dao = new FlashCardDaoImpl();
//		System.out.println("Saving the new Flashcard: " + dao.createFlashCard(fc));
		
		List<FlashCard> fcList = dao.getAllFlashCard();
		System.out.println(fcList);
	}
}
