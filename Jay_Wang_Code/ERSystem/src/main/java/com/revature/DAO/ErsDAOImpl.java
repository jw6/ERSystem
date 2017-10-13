package com.revature.DAO;

import com.revature.beans.ERSUser;

public class ErsDAOImpl implements ErsDAO {
	private static final String URL = "jdbc:oracle:thin@localhost:1521:xe";
	private static final String USERNAME = "ERSystem";
	private static final String PASSWORD = "p4ssw0rd";
		
	@Override
	public ERSUser getUserByUsername(ERSUser user) {
		// TODO Auto-generated method stub
		return null;
	}

}
