package com.revature.dao;

import com.revature.bean.HagenRanchUser;

/**
 * 
 * @author jay
 *
 */
public interface DAO {
	//Create
	public void saveUser(HagenRanchUser clientUser);
	
	//Read
	public HagenRanchUser getUserByUsername(HagenRanchUser clientUser);
	
}
