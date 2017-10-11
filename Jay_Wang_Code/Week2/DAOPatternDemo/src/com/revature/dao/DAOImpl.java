package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.pojo.Customer;
import com.revature.util.ConnectionUtil;

public class DAOImpl implements DAO{

	@Override
	public int addCustomer(Customer customer) {
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql = "INSERT INTO CUSTOMER(customer_first_name, customer_last_name) values(?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			
			int num = ps.executeUpdate();
			return num;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
