package com.rk.entity;

import java.io.Serializable;

public class MobileCustInfo implements Serializable {

	//read inputs
	private Integer cno;
	private String cname;
	private String caddrs;
	private String callerTune;
	private Long phon;
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
