package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.ERSUser;
import com.revature.bean.Reimbursement;
import com.sun.java.xml.ns.j2Ee.UserDataConstraintType;

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
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "INSERT INTO ers_user (ers_fn, ers_ln, ers_username, ers_password, rt_id, ers_email) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getRtId());
			ps.setString(6, user.getEmail());
			
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int createReimbursement(Reimbursement rb) {
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "INSERT INTO reimbursement (ers_id, rbt_id, rb_amount, rb_description) "  
					      + "VALUES(?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rb.getErsId());
			ps.setInt(2, rb.getRbtId());
			ps.setDouble(3, rb.getRbAmount());
			ps.setString(4, rb.getDescription());
			int status = ps.executeUpdate();
			return status;
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
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
		ERSUser dbUser = new ERSUser();
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "SELECT * FROM ers_user WHERE ers_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ersId);
			
			ResultSet rs = ps.executeQuery();
			
			dbUser.setErsId(rs.getInt(1));
			dbUser.setFirstName(rs.getString(2));
			dbUser.setLastName(rs.getString(3));
			dbUser.setUsername(rs.getString(4));
			dbUser.setPassword(rs.getString(5));
			dbUser.setRtId(rs.getInt(6));
			dbUser.setEmail(rs.getString(7));
			
			return dbUser;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ERSUser> getAllEmployees() {
		List<Reimbursement> rbList = new ArrayList<>();
		Reimbursement rb = new Reimbursement();
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "SELECT * FROM reimbursement";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				rb.setRbId(rs.getInt(1));
				rb.setErsId(rs.getInt(2));
				rb.setStId(rs.getInt(3));
				rb.setManagerId(rs.getInt(4));
				rb.setRbtId(rs.getInt(5));
				rb.setRbAmount(rs.getDouble(6));
				rb.setRbSubmitted(rs.getString(7));
				rb.setRbResolved(rs.getString(8));
				rb.setDescription(rs.getString(9));
				
				rbList.add(rb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> rbs = new ArrayList<>();
		Reimbursement rb = null;
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "SELECT * FROM reimbursement";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				rb = new Reimbursement();
				rb.setRbId(rs.getInt(1));
				rb.setErsId(rs.getInt(2));
				rb.setStId(rs.getInt(3));
				rb.setManagerId(rs.getInt(4));
				rb.setRbtId(rs.getInt(5));
				rb.setRbAmount(rs.getDouble(6));
				rb.setRbSubmitted(rs.getString(7));
				rb.setRbResolved(rs.getString(8));
				rb.setDescription(rs.getString(9));
				
				rbs.add(rb);
			}
			for(Reimbursement reimb : rbs) {
				System.err.println(reimb.toString());
			}
			return rbs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
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
	public int updateEmployeeInfo(ERSUser user) {
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "UPDATE ers_user SET ers_fn = ?, ers_ln = ?, ers_username = ?, ers_password = ?, ers_email =?"
					+ "WHERE ers_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getErsId());
			
			int status =  ps.executeUpdate();
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public void updateReimbursementStatus(Reimbursement rb) {
		// TODO Auto-generated method stub
		
	}

}
