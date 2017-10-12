package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bean.BankAccount;
import com.revature.bean.BankUser;

public class BankImpl implements BankDAO {
	//3 add ojdbc
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "banking_db";
	private static final String PASSWORD = "p4ssw0rd";
	
	@Override
	public BankUser getUserByUsername(BankUser user) {
		BankUser dbUser = null;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM bank_user WHERE u_username = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dbUser = new BankUser(rs.getInt("U_ID"),rs.getString("U_USERNAME"),rs.getString("U_FN"),
						rs.getString("U_LN"), rs.getString("U_PASSWORD"));
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	return dbUser;
	}

	@Override
	public BankAccount getBankAccountByUserId(BankUser user) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public static void main(String[] args) {
//		BankUser u = new BankUser("jwang");
//		new BankImpl().getUserByUsername(u);
//		System.out.println(u);
//	}
}
