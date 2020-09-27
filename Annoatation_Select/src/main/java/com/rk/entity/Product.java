package com.rk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

@Entity
@Proxy(lazy = true)
public class Product implements Serializable{
	private Long pid;
	private String pname;
	private Integer teamSize;
	private String company;
	
	//getters & setters
	@Id
	@Column(name="PID")
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	
	@Column(name="PNAME",length =10,unique = true,nullable =false)
	@Type(type="string")
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	@Column(name="TEAMSIZE",length = 5)
	@Type(type="int")
	public Integer getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}
	
	@Column(name="COMPANY",length =10)
	@Type(type="string")
	//@Transient
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	//to string
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", teamSize=" + teamSize + ", company=" + company + "]";
	}
	
}
