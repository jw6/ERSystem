package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.ERSUser;

public class ErsDAOImpl implements ErsDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "ERSystem";
	private static final String PASSWORD = "p4ssw0rd";
	
	public static void main(String[] args) {
		ERSUser user = new ERSUser("Dinash", "d123");
		System.out.println(user.toString());
		ErsDAO dao = new ErsDAOImpl();
		user = dao.getUserByUsername(user);
		System.out.println(user.toString());
	}
		
	@Override
	public ERSUser getUserByUsername(ERSUser user) {
		ERSUser dbUser = null;
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "SELECT * FROM ers_user WHERE ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dbUser = new ERSUser(rs.getInt("ers_id"), rs.getString("ers_username"),
									rs.getString("ers_password"),
									rs.getString("ers_email"), rs.getString("ers_fn"),
									rs.getString("ers_ln"), rs.getInt("rt_id"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dbUser;
	}

}
