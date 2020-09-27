package com.rk.entity;

import java.io.Serializable;

public class ProgrProjID implements Serializable {

	//some jars
	private Integer pid;
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
