package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.bean.ERSUser;
import com.revature.bean.Reimbursement;

public class DAOImpl implements DAO{
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "ERSystem";
	private static final String PASSWORD = "p4ssw0rd";
	
//	public static void main(String[] args) {
//		ERSUser user = new ERSUser("Dinash", "d123");
//		System.out.println(user.toString());
//		DAO dao = new DAOImpl();
//		user = dao.getUserByUsername(user);
//		System.out.println(user.toString());
//	}

	@Override
	public void registerUser(ERSUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createReimbursement(Reimbursement rb) {
		// TODO Auto-generated method stub
		
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
				dbUser = new ERSUser(rs.getInt("ers_id"), 
									rs.getString("ers_fn"),
									rs.getString("ers_ln"), 
									rs.getString("ers_username"),
									rs.getString("ers_password"),
									rs.getInt("rt_id"),
									rs.getString("ers_email") 
									 );
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dbUser;
	}

	@Override
	public ERSUser getUserById(int ersId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ERSUser> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ERSUser getAllReimbursementByEmployee(ERSUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ERSUser getEmployeeByReimbursement(Reimbursement rb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployeeInfo(ERSUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReimbursementStatus(Reimbursement rb) {
		// TODO Auto-generated method stub
		
	}

}
