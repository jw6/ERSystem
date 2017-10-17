package com.revature.bean;

import java.io.Serializable;
import java.sql.Blob;

public class Reimbursement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5410066155980345306L;
	
	private int rbId;
	private double rbAmount;
	private Blob rbReceipt;
	private int ersId;
	private int stId;
	private int managerId;
	private int rbtId;
	private String rbSubmitted;
	private String rbResolved;
	private String description;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int rbId, double rbAmount, Blob rbReceipt, int ersId, int stId, int managerId, int rbtId,
			String rbSubmitted, String rbResolved, String description) {
		super();
		this.rbId = rbId;
		this.rbAmount = rbAmount;
		this.rbReceipt = rbReceipt;
		this.ersId = ersId;
		this.stId = stId;
		this.managerId = managerId;
		this.rbtId = rbtId;
		this.rbSubmitted = rbSubmitted;
		this.rbResolved = rbResolved;
		this.description = description;
	}

	public int getRbId() {
		return rbId;
	}

	public void setRbId(int rbId) {
		this.rbId = rbId;
	}

	public double getRbAmount() {
		return rbAmount;
	}

	public void setRbAmount(double rbAmount) {
		this.rbAmount = rbAmount;
	}

	public Blob getRbReceipt() {
		return rbReceipt;
	}

	public void setRbReceipt(Blob rbReceipt) {
		this.rbReceipt = rbReceipt;
	}

	public int getErsId() {
		return ersId;
	}

	public void setErsId(int ersId) {
		this.ersId = ersId;
	}

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getRbtId() {
		return rbtId;
	}

	public void setRbtId(int rbtId) {
		this.rbtId = rbtId;
	}

	public String getRbSubmitted() {
		return rbSubmitted;
	}

	public void setRbSubmitted(String rbSubmitted) {
		this.rbSubmitted = rbSubmitted;
	}

	public String getRbResolved() {
		return rbResolved;
	}

	public void setRbResolved(String rbResolved) {
		this.rbResolved = rbResolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Reimbursement [rbId=" + rbId + ", rbAmount=" + rbAmount + ", rbReceipt=" + rbReceipt + ", ersId="
				+ ersId + ", stId=" + stId + ", managerId=" + managerId + ", rbtId=" + rbtId + ", rbSubmitted="
				+ rbSubmitted + ", rbResolved=" + rbResolved + ", description=" + description + "]";
	}
}
