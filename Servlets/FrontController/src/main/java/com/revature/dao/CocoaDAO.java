package com.revature.dao;

import java.util.List;

import com.revature.beans.CocoaBean;

public interface CocoaDAO
{
	public CocoaBean getById(int id);
	public int saveCocoaBean(CocoaBean bean);
	public List<CocoaBean> getAll();
	public int destroyCocoaBeanById(int id);
	public int updateCocoaBean(CocoaBean bean);
}
