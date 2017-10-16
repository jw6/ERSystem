package com.revature.service;

import com.revature.bean.HagenRanchUser;
import com.revature.dao.DAO;
import com.revature.dao.DaoImpl;
import com.revature.dto.UserDTO;

public class Service {
	public HagenRanchUser validateUser(HagenRanchUser clientUser) {
		DAO dao = new DaoImpl();
		
		HagenRanchUser dbUser = dao.getUserByUsername(clientUser);
		
		if(dbUser != null) {
			if(dbUser.getUsername().equals(clientUser.getUsername()) &&
					dbUser.getPassword().equals(clientUser.getPassword())) {
				return dbUser;
			}
		}
		return null;
	}
	
	public UserDTO convertToUserDTO(HagenRanchUser user) {
		return new UserDTO(user.getRoleId(), user.getFirstName(),
						   user.getLastName(), user.getUsername(),
						   user.getPassword(), user.getRoleId(),
						   user.getEmail());
	}
}
