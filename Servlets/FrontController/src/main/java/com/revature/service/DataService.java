package com.revature.service;

import java.util.List;

import com.revature.beans.CocoaBean;
import com.revature.dao.CocoaDAO;
import com.revature.dao.CocoaDAOImpl;

public class DataService
{
	public void saveBeans(List<CocoaBean> beanList)
	{
		System.out.println("Calling Data Service");
		//create a DAO
		CocoaDAO dao = new CocoaDAOImpl();
		//start transaction
		//open a connection
		//set autocommit false
		for(CocoaBean bean : beanList)
		{
			if(dao.saveCocoaBean(bean)==0)
			{
				//rollback
				//break and set a variable to false
			}
		}
		//check to see if that variable was false
		//commit
	}
}
