package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_TX")
public class BankTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TX_ID")
	private int txId;

	@Column(name = "TX_AMOUNT")
	private int txAmount;

	@Column(name = "TX_TIMESTAMP")
	private String txTimestamp;

	@OneToOne
	@JoinColumn(name = "BTT_ID")
	private BankTransactionType bankTxType;
	
	@ManyToOne
	@JoinColumn(name="BA_ID")
	private BankAccount bankAccount;
	
	public BankTransaction() {
		
	}

	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public int getTxAmount() {
		return txAmount;
	}

	public void setTxAmount(int txAmount) {
		this.txAmount = txAmount;
	}

	public String getTxTimestamp() {
		return txTimestamp;
	}

	public void setTxTimestamp(String txTimestamp) {
		this.txTimestamp = txTimestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BankTransactionType getBankTxType() {
		return bankTxType;
	}

	public void setBankTxType(BankTransactionType bankTxType) {
		this.bankTxType = bankTxType;
	}

}