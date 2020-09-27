package com.rk.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;


public class BankAccountInfo implements Serializable{

	//read inputs
	private Long acno;
	private String holderName;
	private Double balance;
	private String type;
	private LocalDateTime openingDate;  //to just hold creation date and time
	private Timestamp lastDateUpdated;  //for timestamp
	

	//setters & getters
	public Long getAcno() {
		return acno;
	}
	public void setAcno(Long acno) {
		this.acno = acno;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDateTime getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}
	public Timestamp getLastDateUpdated() {
		return lastDateUpdated;
	}
	public void setLastDateUpdated(Timestamp lastDateUpdated) {
		this.lastDateUpdated = lastDateUpdated;
	}
	
	
	//to string
	@Override
	public String toString() {
		return "BankAccountInfo [acno=" + acno + ", holderName=" + holderName + ", balance=" + balance + ", type="
				+ type + ", openingDate=" + openingDate + ", lastDateUpdated=" + lastDateUpdated + "]";
	}
	
	
	
}//class
