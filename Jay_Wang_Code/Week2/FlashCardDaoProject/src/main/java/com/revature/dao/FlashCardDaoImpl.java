package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.FlashCard;

public class FlashCardDaoImpl implements Dao{

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "flashcard_db";
	private String password = "p4ssw0rd";
	
	@Override
	public int createFlashCard(FlashCard fc) {
		int status = 0;
		try (Connection conn = DriverManager.getConnection(url,username, password);){
			conn.setAutoCommit(false); //do this to run a tx with multiple statement;
			String sql = "INSERT INTO flash_card(FC_QUESTION, FC_ANSWER) VALUES(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			//index 1 for first question mark
			ps.setString(1, fc.getQuestion());
			ps.setString(2, fc.getAnswer());
			status = ps.executeUpdate();
			//It's only for testing
			System.out.println(status);
			//multiple ps can happen here
			//but if one of them has expection, it would jump to catch
			//conn.commit()
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<FlashCard> getAllFlashCard() {
		List<FlashCard> flashCards = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url,username, password);){
			String sql = "SELECT * FROM flash_card";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				flashCards.add(new FlashCard(rs.getInt(1), rs.getString(2), rs.getString("FC_ANSWER")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flashCards;
	}

	@Override
	public FlashCard getFlashCardById(int id) {
		return null;
	}

	@Override
	public FlashCard getFlashCardByQuestion(String Question) {
		return null;
	}

	@Override
	public int updateFlashCard(FlashCard fc) {
		return 0;
	}

	@Override
	public int deleteFlashCard(FlashCard fc) {
		return 0;
	}
	
	
}
