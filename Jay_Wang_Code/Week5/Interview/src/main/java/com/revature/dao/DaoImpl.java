package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bean.HagenRanchUser;

public class DaoImpl implements DAO{
	
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String USERNAME = "School_db";
	private final static String PASSWORD = "p4ssw0rd";
	
	@Override
	public void saveUser(HagenRanchUser user) {
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			/* Example from database
			 * INSERT INTO users(user_fn, user_ln, user_username, user_password, user_email) 
			 *	VALUES ('Jay', 'Wang', 'jay', 'abc123', 'jaywang007@yahoo.com');
			 */
			
			String sql = "INSERT INTO users(user_fn, user_ln, user_username, user_password, user_email)"
					+ " VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2,  user.getLastName());
			ps.setString(3,  user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5,  user.getEmail());
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public HagenRanchUser getUserByUsername(HagenRanchUser user) {
		HagenRanchUser dbUser = null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT  * FROM USERS WHERE user_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
					
			if(rs.next()) {
				dbUser = new HagenRanchUser(rs.getInt("user_id"), rs.getString("user_fn"), rs.getString("user_ln"),
											rs.getString("user_username"), rs.getString("user_password"),
											rs.getInt("rt_id"), rs.getString("user_email"));
			}
//			System.out.println(dbUser.toString());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dbUser;
	}
	
	
	public static void main(String[] args) {
//		DaoImpl dao = new DaoImpl();
//		HagenRanchUser clientUser = new HagenRanchUser(1,"cam","gerald","cam","abc123",1,"jaywang007@yahoo.com" );
//		clientUser.setUsername("jay");
//		System.out.println(clientUser.toString());
//		clientUser = dao.getUserByUsername(clientUser);
//		System.out.println(clientUser.toString());
//		dao.saveUser(clientUser);
//		clientUser = dao.getUserByUsername(clientUser);
//		System.out.println(clientUser.toString());
		
	}
}
