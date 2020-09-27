package com.rk.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
public class MobileCustInfo implements Serializable {

	//read inputs
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cno;
	
	@Column(length=20)
	@Type(type = "string")
	private String cname;
	
	@Column(length=20)
	@Type(type = "string")
	private String caddrs;
	
	@Column(length=40)
	@Type(type = "string")
	private String callerTune;
	
	@Column(length=10)
	@Type(type = "long")
	private Long phon;
	
	@Column(length=10)
	@Version
	private int versionCount;
	
	//Getters& setters
	
	public Long getPhon() {
		return phon;
	}
	public void setPhon(Long phon) {
		this.phon = phon;
	}
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddrs() {
		return caddrs;
	}
	public void setCaddrs(String caddrs) {
		this.caddrs = caddrs;
	}
	public String getCallerTune() {
		return callerTune;
	}
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	public Integer getVersionCount() {
		return versionCount;
	}
	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}
	
	//to String
	@Override
	public String toString() {
		return "MobileCustInfo [cno=" + cno + ", cname=" + cname + ", caddrs=" + caddrs + ", callerTune=" + callerTune
				+ ", versionCount=" + versionCount + "]";
	}
	
	
}
