package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.CocoaBean;

public class CocoaDAOImpl implements CocoaDAO {

	private static List<CocoaBean> cocoaList;
	
	static{
		cocoaList = new ArrayList<CocoaBean>();
		cocoaList.add(new CocoaBean(1, "Cocoa1"));
		cocoaList.add(new CocoaBean(2, "Cocoa2"));
		cocoaList.add(new CocoaBean(3, "Cocoa3"));
		cocoaList.add(new CocoaBean(4, "Cocoa4"));
	}
	
	public CocoaBean getById(int id)
	{
		return cocoaList.get(id);
	}

	public int saveCocoaBean(CocoaBean bean) {
		for(CocoaBean b : cocoaList)
		{
			if(bean.getId()==b.getId())
			{
				return 0;
			}
		}
		cocoaList.add(bean);
		return 1;
	}

	public List<CocoaBean> getAll() {
		return cocoaList;
	}

	public int destroyCocoaBeanById(int id) {
		return 0;
	}

	public int updateCocoaBean(CocoaBean bean) {
		for(CocoaBean b : cocoaList)
		{
			if(b.getId()==bean.getId())
			{
				b.setFlavor(bean.getFlavor());
				return 1;
			}
		}
		return 0;
	}

}
