package com.revature;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class MainClass {

	/*
	 * JDBC: Java Database Connectivity JDBC API - Application Protocol
	 * Interface Used to talk with our Database, Oracle DB or anything other
	 * RDBMS Interface - Abstraction
	 * 
	 * Important Interfaces: 
	 * 			1. Connection 
	 * 			2. Statement 
	 * 			3. PreparedStatement  - precompiles the SQL string without the parameters, 
	 * 													once the parameters are added, their only treated as values never Keywords
	 * 			4. CallableStatement - Stored Procedure? Function? - used with Stored Procedure for Transactions
	 * 
	 * 		Statement vs PreparedStatement
	 * 			1. PS has better Readability 
	 * 			2.  PS more secure than Statement
	 * 
	 * We need a driver for these Interfaces -ojbc7.jar
	 * 
	 * To connect to our Database 4 things: 1. URL 2. Username 3. Password 4.
	 * Driver - the jar that implements JDBC
	 * 
	 * What is the JDBC Exception? -SQLException
	 * 
	 */

	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "flashcard_db";
	private static String password = "p4ssw0rd";

	public static void main(String[] args) {

//		statementExample("Who are you?", "Bob");
//		preparedStatementExample("Drop Table?", "this works");
		callableStatementExample("Whats Good Good?", "pizza pizza");
	}

	public static void callableStatementExample(String question, String answer){
		
			try (Connection conn = DriverManager.getConnection(url, username, password);) {
					String sql = "{ call insert_fc_proc(?,?,?) }"; //works without the {} but nothing gets returned
					String errMessage = null;
					
					CallableStatement  cs = conn.prepareCall(sql);
					cs.setString(1, question);
					cs.setString(2, answer);
					cs.setString(3, errMessage);
					
					int status = cs.executeUpdate();
					System.out.println("CallableStatement returns: " + status);
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void preparedStatementExample(String question, String answer) {
			
		try (Connection conn = DriverManager.getConnection(url, username, password);){
			
			String sql = "INSERT INTO flash_card(FC_QUESTION,FC_ANSWER) VALUES(?,? )";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, question);
			ps.setString(2, answer);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void statementExample(String question, String answer) {
		// Use try w/ resources or make sure to close() your connection
		try (Connection conn = DriverManager.getConnection(url, username, password);) {
			String sql = "INSERT INTO flash_card(FC_QUESTION,FC_ANSWER) VALUES(' " + question + " ', ' " + answer
					+ " '   )";
			Statement statement = conn.createStatement();
			int numOfRowsChanged = statement.executeUpdate(sql);
			System.out.println("The # of rows changed: " + numOfRowsChanged);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
