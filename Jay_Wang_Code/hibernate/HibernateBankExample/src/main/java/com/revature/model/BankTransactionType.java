package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_TX_TYPE")
public class BankTransactionType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BTT_ID")
	private int bttId;

	@Column(name = "BTT_TYPE")
	private String bttType;

	public BankTransactionType() {

	}

	public BankTransactionType(int bttId, String bttType) {
		super();
		this.bttId = bttId;
		this.bttType = bttType;
	}

	public int getBttId() {
		return bttId;
	}

	public void setBttId(int bttId) {
		this.bttId = bttId;
	}

	public String getBttType() {
		return bttType;
	}

	public void setBttType(String bttType) {
		this.bttType = bttType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BankTransactionType [bttId=" + bttId + ", bttType=" + bttType + "]";
	}

}