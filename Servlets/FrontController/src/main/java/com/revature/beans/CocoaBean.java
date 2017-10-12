package com.revature.beans;

import java.io.Serializable;

/*
 * 	Special POJO called JavaBean
 * 		1. Fully encapsulated
 * 		2. ToString
 * 		3. Implements Serializable
 */

public class CocoaBean implements Serializable
{
	private static final long serialVersionUID = -4052521612164869498L;
	
	private int id;
	private String flavor;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	@Override
	public String toString() {
		return "CocoaBean [id=" + id + ", flavor=" + flavor + "]";
	}
	public CocoaBean(int id, String flavor) {
		super();
		this.id = id;
		this.flavor = flavor;
	}
	public CocoaBean() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CocoaBean other = (CocoaBean) obj;
		if (flavor == null) {
			if (other.flavor != null)
				return false;
		} else if (!flavor.equals(other.flavor))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
