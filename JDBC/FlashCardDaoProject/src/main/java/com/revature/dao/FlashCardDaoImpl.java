package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.FlashCard;

import oracle.jdbc.OracleTypes;

public class FlashCardDaoImpl implements Dao{
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "flashcard_db";
	private String password = "p4ssw0rd";
	
	@Override
	public int createFlashCard(FlashCard fc) {
		int status = 0;
		/*
		 *   JDBC Transaction
		 *   		-set auto to false when doing more than 1 statement
		 */
		try (Connection conn = DriverManager.getConnection(url, username, password);) {
			conn.setAutoCommit(false);//do this to run a tx with multiple statements
			String sql = "INSERT INTO flash_card(FC_QUESTION,FC_ANSWER) VALUES(?,? )";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fc.getQuestion());
			ps.setString(2, fc.getAnswer());
			
//			PreparedStatement ps1 = conn.prepareStatement(sql);
//			ps.setString(1, fc.getQuestion());
//			ps.setString(2, fc.getAnswer());
//			
//			
//			PreparedStatement ps2 = conn.prepareStatement(sql);
//			ps.setString(1, fc.getQuestion());
//			ps.setString(2, fc.getAnswer());
//			
//			 status = ps0.executeUpdate(); //will commit by default
//			 status = ps1.executeUpdate();
//			 status = ps2.executeUpdate();
			System.out.println("Status: " + status);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return status;
	}

	@Override
	public List<FlashCard> getAllFlashCard() {
	
		List<FlashCard> flashCards = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password);) {
			
			String sql = "SELECT * FROM flash_card";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				flashCards.add( new FlashCard(rs.getInt(1), rs.getString(2), rs.getString("FC_ANSWER")) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flashCards;
	}

	@Override
	public List<FlashCard> retrieveAllFlashCards() {
		
		List<FlashCard> fcList = new ArrayList<>();
			try (Connection connect =  DriverManager.getConnection(url, username, password);) {
				
				String getFCbyStoredProc = "{call get_all_fc_procedure(?)}";
				
				CallableStatement cs = connect.prepareCall(getFCbyStoredProc);
				cs.registerOutParameter(1, OracleTypes.CURSOR);
				
				int numRow = cs.executeUpdate();
				System.out.println(numRow + " effected");
				
				ResultSet rs = (ResultSet) cs.getObject(1);
				while(rs.next()){
					fcList.add(new FlashCard(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return fcList;
	}
	
	@Override
	public FlashCard getFlashCardById(int id) {
		return null;
	}

	@Override
	public FlashCard getFlashCardByQuestion(String question) {
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
