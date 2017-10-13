package com.revature.DAO;

import com.revature.beans.ERSUser;

public interface ErsDAO {
	/*
	 * CRUD methods only
	 * 
	 */
	
	public ERSUser getUserByUsername(ERSUser user);
}
