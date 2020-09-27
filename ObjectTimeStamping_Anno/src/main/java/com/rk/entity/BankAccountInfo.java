package com.rk.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="BANK_ACCOUNT_INFO")
public class BankAccountInfo implements Serializable{

	//read inputs
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long acno;
	
	@Column(length = 20)
	@Type(type = "string")
	private String holderName;

	@Column
	@Type(type = "double")
	private Double balance;

	@Column(length = 10)
	@Type(type = "string")
	private String type;

	@CreationTimestamp
	private LocalDateTime openingDate;  //to just hold record creation date and time
	
	@UpdateTimestamp
	private LocalDateTime lastDateUpdated;  //to hold the date and time indicating when record lastly updated


	@Version
	private Integer version;

	
	//setters & getters
	
	public LocalDateTime getLastDateUpdated() {
		return lastDateUpdated;
	}
	public void setLastDateUpdated(LocalDateTime lastDateUpdated) {
		this.lastDateUpdated = lastDateUpdated;
	}

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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}

	
	
	//to string
	@Override
	public String toString() {
		return "BankAccountInfo [acno=" + acno + ", holderName=" + holderName + ", balance=" + balance + ", type="
				+ type + ", openingDate=" + openingDate + ", lastDateUpdated=" + lastDateUpdated + ", version="
				+ version + "]";
	}
	
	
	
	
}//class
