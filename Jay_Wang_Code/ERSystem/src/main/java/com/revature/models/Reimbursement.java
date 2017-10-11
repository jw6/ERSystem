package com.revature.models;

import java.util.Date;

public class Reimbursement {
	private int reimbursementID;
	private ReimbursementStatus statusID;
	private ReimbursementType typeID;
	private double amount;
	private Date submitted;
	private Date resolved;
	private String description;

	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int reimbursementID, ReimbursementStatus statusID, ReimbursementType typeID, double amount,
			Date submitted, Date resolved, String description) {
		super();
		this.reimbursementID = reimbursementID;
		this.statusID = statusID;
		this.typeID = typeID;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", statusID=" + statusID + ", typeID=" + typeID
				+ ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved + ", description="
				+ description + "]";
	}


	public int getReimbursementID() {
		return reimbursementID;
	}


	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}


	public ReimbursementStatus getStatusID() {
		return statusID;
	}


	public void setStatusID(ReimbursementStatus statusID) {
		this.statusID = statusID;
	}


	public ReimbursementType getTypeID() {
		return typeID;
	}


	public void setTypeID(ReimbursementType typeID) {
		this.typeID = typeID;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getSubmitted() {
		return submitted;
	}


	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}


	public Date getResolved() {
		return resolved;
	}


	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}



	
}
