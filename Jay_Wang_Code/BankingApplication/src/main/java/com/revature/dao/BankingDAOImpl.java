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
import com.revature.models.RegisterUser;
import com.revature.utils.ConnectionUtil;

public class BankingDAOImpl implements BankingDAO {
	
	public static void main(String[] args) {
		BankingDAOImpl bank = new BankingDAOImpl();
//		bank.userLogin("jwang", "jw123");
//		
//		BankTransaction bt = new BankTransaction(1, 3, 1, 100, new Date());
//		System.out.println(bt.toString());
//		
// 		bank.performTransaction(bt);
//		
//		bank.performTransaction(8,112.4,1);
//		
		RegisterUser client = new RegisterUser("Ryan", "Giggs", "efisher", "ef123");
		System.out.println(client.toString());
		
		System.out.println(bank.getBankUserID(client));
//		bank.register(client);
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
			for(int i = 0; i < accounts.size(); i++) {
				System.out.println(accounts.get(i));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	@Override
	public int performTransaction(BankTransaction bt) {
		
		try(Connection conn = ConnectionUtil.getConnection();){
//			conn.setAutoCommit(false);
			//fetch current balance of the account
			String sql1 = "Select ba_balance FROM bank_account  WHERE ba_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setInt(1, bt.getBankAccountID());
			ResultSet rs = ps.executeQuery();
			double balance = 0;
			
			if(rs.next()) {
				balance = rs.getDouble("ba_balance");
			}
			System.out.println("Your current balance:\t$" + balance);
			
			String sql = "{CALL make_transaction(?, ?, ?)}";
			
			//above and below both work, add control flow later to check overdraft later
			
			if( ((balance < 0) || bt.getTransactionAmount() > balance ) && bt.getTransactionType() == 2) {
				System.out.println("Sorry, you cannot overdraft from your account");
				return -1;
			} 
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, bt.getBankAccountID());
			cs.setDouble(2, bt.getTransactionAmount());
			cs.setInt(3, bt.getTransactionType());
			cs.execute();		
			
			postTransactionBalance(bt.getBankAccountID());
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void postTransactionBalance(int BankAccountID) {
		try(Connection conn = ConnectionUtil.getConnection();){
			conn.setAutoCommit(false);
			//fetch current balance of the account
			String sql1 = "Select ba_balance FROM bank_account  WHERE ba_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setInt(1, BankAccountID);
			ResultSet rs = ps.executeQuery();
			double balance = 0;
			
			if(rs.next()) {
				balance = rs.getDouble("ba_balance");
			}
			System.out.println("Your balance after this transaction:\t$" + balance);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public BankUser register(RegisterUser user) {
		BankUser bu = new BankUser();
		try(Connection conn = ConnectionUtil.getConnection();) {
			String sql = "INSERT INTO bank_user(u_fn, u_ln, u_username, u_password) VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bu;
	}

	@Override
	public int getBankUserID(RegisterUser user) {
		int BankUserID = 0;
		try(Connection conn = ConnectionUtil.getConnection();){
			conn.setAutoCommit(false);
			String sql = "SELECT u_id FROM bank_user WHERE u_username = ? AND u_password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BankUserID = rs.getInt("u_id");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return BankUserID;
	}

	@Override
	public void createAccount(int BankUserID) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO bank_account(u_id) VALUES(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, BankUserID);
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
