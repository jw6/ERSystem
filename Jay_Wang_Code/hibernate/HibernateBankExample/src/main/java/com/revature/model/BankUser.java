package com.revature.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//JavaBean
/*
 * 	Once we have created our pojo/bean/model whatever you want to call it...
 * 		we need to map it to our table!
 * 
 * 	Can map through @'s or XML for our pojos
 * 		@ using JPA
 * 		when mapped through XML it is called hbm
 */
@Entity
@Table(name = "BANK_USER")
public class BankUser implements Serializable {

	/**
	 * JPA Annotations: Java Persistence API
	 * 
	 * @Entity
	 * @Table
	 * @Column
	 * @Id These annotations tell hibernate config it is mapped to a table
	 * 
	 */
	private static final long serialVersionUID = -2669661945821816492L;

	@Id
	@Column(name="U_ID")
	private int userId;
	
	@Column(name = "U_USERNAME")
	private String username;

	@Column(name = "U_PASSWORD")
	private String password;

	@Column(name = "FIRST_NAMES")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@OneToMany(mappedBy = "bankUser", fetch = FetchType.EAGER) 
	Set<BankAccount> bankAccount = new HashSet<BankAccount>(); 	

	public BankUser() {
	}

	public BankUser(int userId, String username, String password, String firstName, String lastName,
			Set<BankAccount> bankAccount) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bankAccount = bankAccount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<BankAccount> getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Set<BankAccount> bankAccount) {
		this.bankAccount = bankAccount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BankUser [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", bankAccount=" + bankAccount + "]";
	}

}