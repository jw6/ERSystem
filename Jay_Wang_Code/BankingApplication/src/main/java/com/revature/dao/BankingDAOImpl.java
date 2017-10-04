package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.exceptions.InvalidOperationException;
import com.revature.models.BankAccount;
import com.revature.models.BankTransaction;
import com.revature.models.BankUser;
import com.revature.utils.ConnectionUtil;

public class BankingDAOImpl implements BankingDAO {
	
	public static void main(String[] args) {
//		BankingDAOImpl bank = new BankingDAOImpl();
//		bank.userLogin("jwang", "jw123");
		
//		BankTransaction bt = new BankTransaction(1, 1, 1, 101.12, new Date());
//		System.out.println(bt.toString());
		
//		bank.performTransaction(bt);
		
//		bank.performTransaction(8,112.4,1);
		
	}	

	@Override
	public BankUser userLogin(String username, String password) {
		BankUser user = null;
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			String sql = "SELECT u_id, u_fn, u_ln FROM bank_user WHERE u_username=? AND u_password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new BankUser(rs.getInt("u_id"), rs.getString("u_fn"), rs.getString("u_ln"));
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}


	@Override
	public List<BankAccount> getBankAccountByUser(BankUser user) {
		List<BankAccount> accounts = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			String sql = "Select ba_id, ba_balance FROM bank_account  WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getBankUserID());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accounts.add(new BankAccount(rs.getInt("ba_id"), rs.getDouble("ba_balance")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	@Override
	public void performTransaction(BankTransaction bt) {
		
		try(Connection conn = ConnectionUtil.getConnection();){
			String sql = "{CALL make_transaction(?, ?, ?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, bt.getBankAccountID());
			cs.setDouble(2, bt.getTransactionAmount());
			cs.setInt(3, bt.getTransactionType());
			cs.execute();
			System.out.println("test inside");
			}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void performTransaction(int baID, double amount, int type) {
		
		try(Connection conn = ConnectionUtil.getConnection();){
			String sql = "{CALL make_transaction(?, ?, ?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, baID);
			cs.setDouble(2, amount);
			cs.setInt(3, type);
			cs.execute();
			System.out.println("test");
			}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public double viewBalance(int bankAccountID) {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public boolean isOverDraft(double balance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transactionOnRecord() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void transactionHistory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BankUser registerUser(String firstName, String lastName, String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
