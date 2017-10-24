package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_TX_TYPE")
public class BankTxType {

	@Id
	@Column(name = "BTT_ID")
	private int bttNumber;

	@Column(name = "BTT_TYPE")
	private String bttType;

	public BankTxType() {
		super();
	}

	public int getBttNumber() {
		return bttNumber;
	}

	public void setBttNumber(int bttNumber) {
		this.bttNumber = bttNumber;
	}

	public String getBttType() {
		return bttType;
	}

	public void setBttType(String bttType) {
		this.bttType = bttType;
	}

	@Override
	public String toString() {
		return "BankTxType [bttNumber=" + bttNumber + ", bttType=" + bttType + "]" +"\n";
	}

}
