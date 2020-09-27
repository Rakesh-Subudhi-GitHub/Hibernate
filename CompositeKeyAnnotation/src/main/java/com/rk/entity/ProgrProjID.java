package com.rk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;
//import javax.persistence.EmbeddedId;

@Embeddable//bcz of entitikey inside in entity object(main class in subclass to called @Embeddable)
public class ProgrProjID implements Serializable {

	//some jars
	@Type(type="int")
	//@Column(name="PID")
	private Integer pid;
	
	@Type(type="int")
	//@Column(name="PROJID")
	private Integer projid;
	
	//getters & setters
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getProjid() {
		return projid;
	}
	public void setProjid(Integer projid) {
		this.projid = projid;
	}

	//to string
	@Override
	public String toString() {
		return "ProgrProjID [pid=" + pid + ", projid=" + projid + "]";
	}
	
	
}
